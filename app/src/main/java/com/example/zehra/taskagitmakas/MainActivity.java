package com.example.zehra.taskagitmakas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1="com.example.zehra.taskagitmakas.extra.MESSAGE1";
    public static final String EXTRA_MESSAGE2="com.example.zehra.taskagitmakas.extra.MESSAGE2";
    Button button_oyuna_basla;
    EditText editText_kullanici1Adi;
    EditText editText_kullanici2Adi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_kullanici1Adi=findViewById(R.id.editText_kullanici1adi);
        editText_kullanici2Adi=findViewById(R.id.editText_kullanici2adi);
    }

    public void oyunaBasla(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        String message1=editText_kullanici1Adi.getText().toString();
        String message2=editText_kullanici2Adi.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1,message1);
        intent.putExtra(EXTRA_MESSAGE2,message2);
        startActivity(intent);

    }
}
