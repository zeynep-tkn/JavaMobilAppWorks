package com.zeyneptekin.firebasedeneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GirisActivity extends AppCompatActivity {
    private EditText editEmail;
    private EditText editPassword;
    private String txtEmail;
    private String txtPassword;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        editEmail=(EditText)findViewById(R.id.girisyap_mail);
        editPassword=(EditText)findViewById(R.id.girisyap_sifre);
        mAuth=FirebaseAuth.getInstance();

    }
    public void girisYap(View view){
     txtEmail=editEmail.getText().toString();
     txtPassword=editPassword.getText().toString();
     if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)){
       mAuth.signInWithEmailAndPassword(txtEmail,txtPassword)
               .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                   @Override
                   public void onSuccess(AuthResult authResult) {
                     mUser=mAuth.getCurrentUser();
                       System.out.println("Kullanıcı Adı: "+mUser.getDisplayName());
                       System.out.println("Email: "+mUser.getEmail());
                       System.out.println("Kullanıcı Uid: "+mUser.getUid());
                   }
               }).addOnFailureListener(this, new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                      Toast.makeText(GirisActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                   }
               });
     }
     else{
         Toast.makeText(this, "Email ve şifre boş olamaz", Toast.LENGTH_SHORT).show();
     }



    }




}