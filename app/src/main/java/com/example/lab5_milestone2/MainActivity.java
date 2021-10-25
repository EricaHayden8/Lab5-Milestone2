package com.example.lab5_milestone2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String usernameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone2", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(usernameKey, "").equals("")){
            String username = sharedPreferences.getString(usernameKey, "");
            goToActivity2(username);
        }
        else{
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View view){
        EditText myTextField = (EditText) findViewById(R.id.editTextUsername);
        String str = myTextField.getText().toString();
        EditText myTextField2 = (EditText) findViewById(R.id.editTextPassword);
        String str2 = myTextField2.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_milestone2", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();
        goToActivity2(str);
    }

    public void goToActivity2(String s){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

}