package com.example.zouplocalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button bt0;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button btSupp;
    Button btVirg;
    Button btDiv;
    Button btPlus;
    Button btMoins;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult= (TextView) findViewById(R.id.tvResult);
        bt0  = (Button) findViewById(R.id.button0);
        bt1 = (Button) findViewById(R.id.button1);
        bt2  = (Button) findViewById(R.id.button2);
        bt3  = (Button) findViewById(R.id.button3);
        bt4  = (Button) findViewById(R.id.button4);
        bt5  = (Button) findViewById(R.id.button5);
        bt6  = (Button) findViewById(R.id.button6);
        bt7  = (Button) findViewById(R.id.button7);
        bt8  = (Button) findViewById(R.id.button8);
        bt9  = (Button) findViewById(R.id.button9);

        btSupp  = (Button) findViewById(R.id.buttonSupp);
        btVirg= (Button) findViewById(R.id.buttonvirg);
        btDiv= (Button) findViewById(R.id.buttondiv);
        btPlus= (Button) findViewById(R.id.buttonPlus);
        btMoins= (Button) findViewById(R.id.buttonMoins);


        btMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEqual(btMoins))
                    return;

                writeNumber(btMoins);
            }
        });
        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(btPlus);
            }
        });
        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(btDiv);
            }
        });
        btVirg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(btVirg);
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt0);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt3);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt4);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt5);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt6);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt7);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt8);
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt9);
            }
        });
        btSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvResult.length()>0){
                    tvResult.setText(tvResult.getText().toString().substring(0, tvResult.getText().toString().length()-1));
                }
            }
        });


    }

    public void writeNumber(Button bt){
        tvResult.setText(tvResult.getText().toString()+bt.getTag());
    }
    public boolean isEqual(Button bt){
        if(bt.getTag().toString() == tvResult.getText().toString().substring(tvResult.getText().length() - 1))
            return true;
        return false;

    }
    public String getLastCar(){
        String mot = tvResult.getText().toString();
        if(mot=="")
            return "";

        char lettre = mot.charAt(mot.length()-1);
        mot="";
        mot+=lettre;
        return mot;
    }
}