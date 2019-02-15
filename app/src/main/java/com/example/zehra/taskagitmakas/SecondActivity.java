package com.example.zehra.taskagitmakas;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView_kullanici1Skor;
    TextView textView_kullanici2Skor;
    TextView textView_Sira;
    TextView tv_kullanici1Skor;
    TextView tv_kullanici2Skor;
    TextView textView_sonKazanan;
    TextView tv_bilgi;
    Button button_tas,button_kagit,button_makas;

    public static int skor_kullanici1=0;
    public static int skor_kullanici2=0;
    public static int sayac=0;

    String kullanici1=null;
    String kullanici2=null;
    String son_kazanan;
    String bilgi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String message1=intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String message2=intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        textView_kullanici1Skor=findViewById(R.id.textView_kullanici1skor);
        textView_kullanici2Skor=findViewById(R.id.textView_kullanici2skor);
        textView_Sira=findViewById(R.id.textView_sira);
        tv_kullanici1Skor=findViewById(R.id.tv_kullanici1skor);
        tv_kullanici2Skor=findViewById(R.id.tv_kullanici2skor);
        textView_sonKazanan=findViewById(R.id.textView_sonKazanan);
        tv_bilgi=findViewById(R.id.textView_bilgi);
        button_tas=findViewById(R.id.buton_tas);
        button_kagit=findViewById(R.id.buton_kagit);
        button_makas=findViewById(R.id.buton_makas);

        button_tas.setOnClickListener(this);
        button_kagit.setOnClickListener(this);
        button_makas.setOnClickListener(this);

        textView_kullanici1Skor.setText(message1);
        textView_kullanici2Skor.setText(message2);

    }
    public void onClick(View v) {
        sayac++;

         if(sayac==1){
             textView_Sira.setText("Sıra:"+ textView_kullanici2Skor.getText());
         }
         else {
             textView_Sira.setText("Sıra:"+ textView_kullanici1Skor.getText());
         }


           if (v.getId() == button_kagit.getId()) {
                if (sayac== 1)
                    kullanici1 = "kagit";
                else if (sayac== 2)
                    kullanici2 = "kagit";
            } else if (v.getId() == button_makas.getId()) {
                if (sayac == 1)
                    kullanici1 = "makas";
                else if (sayac == 2)
                    kullanici2 = "makas";
            } else if (v.getId() == button_tas.getId()) {
                if (sayac  == 1)
                    kullanici1 = "tas";
                else if (sayac == 2)
                    kullanici2 = "tas";
            }



        if(sayac==2){
            if(kullanici1!=null && kullanici2!=null){
                if(kullanici1=="tas"&&kullanici2=="kagit"){
                    skor_kullanici2++;
                    bilgi="Kağıt taşı sarar.";
                    son_kazanan=textView_kullanici2Skor.getText().toString();
                }
                else if(kullanici2=="tas"&&kullanici1=="kagit"){
                    skor_kullanici1++;
                    bilgi="Kağıt taşı sarar.";
                    son_kazanan=textView_kullanici1Skor.getText().toString();
                }
                else if(kullanici2=="tas"&&kullanici1=="makas"){
                    skor_kullanici2++;
                    bilgi="Taş makası kırar.";
                    son_kazanan=textView_kullanici2Skor.getText().toString();
                }
                else if(kullanici1=="tas"&&kullanici2=="makas"){
                    skor_kullanici1++;
                    bilgi="Taş makası kırar.";
                    son_kazanan=textView_kullanici1Skor.getText().toString();
                }
                else if(kullanici1=="kagit"&&kullanici2=="makas"){
                    skor_kullanici2++;
                    bilgi="Makas kağıdı keser.";
                    son_kazanan=textView_kullanici2Skor.getText().toString();
                }
                else if(kullanici1=="makas"&&kullanici2=="kagit"){
                    skor_kullanici1++;
                    bilgi="Makas kağıdı keser.";
                    son_kazanan=textView_kullanici1Skor.getText().toString();
                }
                else
                    bilgi="Aynı seçimi yaptınız.";


            }

            tv_kullanici1Skor.setText(":"+String.valueOf(skor_kullanici1));
            tv_kullanici2Skor.setText(":"+String.valueOf(skor_kullanici2));
            tv_bilgi.setText(bilgi);
            textView_sonKazanan.setText("Son kazanan:"+son_kazanan);
            sayac=0;
            kullanici1=null;
            kullanici2=null;
        }
    }
}



