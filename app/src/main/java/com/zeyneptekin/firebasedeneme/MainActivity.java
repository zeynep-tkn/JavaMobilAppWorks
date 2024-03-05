package com.zeyneptekin.firebasedeneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
   private EditText editEmail;
   private EditText editPassword;
   private EditText editIsim;
   private String txtEmail;
   private String txtPassword;
    private String txtIsim;
   private FirebaseAuth mAuth;
   private FirebaseUser mUser;
   private DatabaseReference mReference;
   private HashMap<String,Object>mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEmail=(EditText)findViewById(R.id.kayitol_mail);
        editPassword=(EditText)findViewById(R.id.kayitol_sifre);
        editIsim=(EditText)findViewById(R.id.kayitol_editIsim);
        mAuth=FirebaseAuth.getInstance();
        mReference= FirebaseDatabase.getInstance().getReference();
    }
    public void kayitOl(View view){
      txtEmail=editEmail.getText().toString();
      txtPassword=editPassword.getText().toString();
      txtIsim=editIsim.getText().toString();
        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)&& !TextUtils.isEmpty(txtIsim)){
            mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                             mUser=mAuth.getCurrentUser();

                             mData=new HashMap<>();
                             mData.put("KullaniciAdi",txtIsim);
                             mData.put("KullaniciEmail",txtEmail);
                             mData.put("KullaniciSifre",txtPassword);
                             mData.put("KullaniciId",mUser.getUid());

                             mReference.child("Kullanıcı")
                                     .setValue(mData)
                                     .addOnCompleteListener(MainActivity.this, new OnCompleteListener<Void>() {
                                         @Override
                                         public void onComplete(@NonNull Task<Void> task) {
                                             if(task.isSuccessful()){
                                                 Toast.makeText(MainActivity.this, "Kayıt işlemi başarılı", Toast.LENGTH_SHORT).show();
                                             }
                                             else{
                                                 Toast.makeText(MainActivity.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                             }
                                         }
                                     });
                          }
                          else
                              Toast.makeText(MainActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this, "Email ve şifre boş olamaz", Toast.LENGTH_SHORT).show();
        }

    }




}