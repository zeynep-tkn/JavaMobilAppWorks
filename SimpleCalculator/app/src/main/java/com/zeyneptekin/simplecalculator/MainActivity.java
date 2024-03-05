package com.zeyneptekin.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextText;   //degisken tanimlama
    EditText editTextText2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editTextText=findViewById(R.id.editTextText);  //id tanimlama
         editTextText2=findViewById(R.id.editTextText2);
         textView=findViewById(R.id.textView);
    }
    public void Toplama(View view) {
        if (editTextText.getText().toString().matches("") ||
        editTextText2.getText().toString().matches("")) {
            textView.setText("enter number!");
        }
        else{
            int number1 = Integer.parseInt(editTextText.getText().toString()); //Sayi aldik ve string i int degerine cevirdik
            int number2 = Integer.parseInt(editTextText2.getText().toString());
            int result = number1 + number2;
            textView.setText("Result=" + result); //sonucu yazdirdik
        }
    }

    public void Cikarma(View view){
        if (editTextText.getText().toString().matches("") ||
        editTextText2.getText().toString().matches("")) {
            textView.setText("enter number!");
        }
        else{
            int number1 = Integer.parseInt(editTextText.getText().toString()); //Sayi aldik ve string i int degerine cevirdik
            int number2 = Integer.parseInt(editTextText2.getText().toString());
            int result = number1 - number2;
            textView.setText("Result=" + result); //sonucu yazdirdik
        }
    }
    public void Carpma(View view){
        if (editTextText.getText().toString().matches("") ||
        editTextText2.getText().toString().matches("")) {
            textView.setText("enter number!");
        }
        else{
            int number1 = Integer.parseInt(editTextText.getText().toString()); //Sayi aldik ve string i int degerine cevirdik
            int number2 = Integer.parseInt(editTextText2.getText().toString());
            int result = number1 * number2;
            textView.setText("Result=" + result); //sonucu yazdirdik
        }
    }
    public void Bolme(View view){
        if (editTextText.getText().toString().matches("") ||
        editTextText2.getText().toString().matches("")) {
            textView.setText("enter number!");
        }
        else{
            int number1 = Integer.parseInt(editTextText.getText().toString()); //Sayi aldik ve string i int degerine cevirdik
            int number2 = Integer.parseInt(editTextText2.getText().toString());
            int result = number1 / number2;
            textView.setText("Result=" + result); //sonucu yazdirdik
        }
    }

}