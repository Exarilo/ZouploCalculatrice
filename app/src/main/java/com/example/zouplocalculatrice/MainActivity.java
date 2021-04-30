package com.example.zouplocalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
    Button btequal;
    static boolean isOperator =false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult= (TextView) findViewById(R.id.tvResult);
        tvResult.setText("");
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

        btequal= (Button) findViewById(R.id.buttonequal);

        btSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvResult.length()>0){
                    tvResult.setText(tvResult.getText().toString().substring(0, tvResult.getText().toString().length()-1));
                }
            }
        });
        btMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOperator||tvResult.getText()=="")
                    return;
                writeNumber(btMoins);
                isOperator=true;
            }
        });
        btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOperator||tvResult.getText()=="")
                    return;
                writeNumber(btPlus);
                isOperator=true;
            }
        });
        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOperator||tvResult.getText()=="")
                    return;
                writeNumber(btDiv);
                isOperator=true;
            }
        });
        btVirg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOperator||tvResult.getText()=="")
                    return;
                writeNumber(btVirg);
                isOperator=true;
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt0);
                isOperator=false;
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt1);
                isOperator=false;
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt2);
                isOperator=false;
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt3);
                isOperator=false;
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt4);
                isOperator=false;
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt5);
                isOperator=false;
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt6);
                isOperator=false;
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt7);
                isOperator=false;
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt8);
                isOperator=false;
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNumber(bt9);
                isOperator=false;
            }
        });

        btequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcul();
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
    public void Calcul(){
        List<Character>listChars = convertStringToCharList(tvResult.getText().toString());
        List<String> listOperator =  new ArrayList<String>() ;
        List<String> listCharNumber =  new ArrayList<String>() ;
        List<String> listNumber =  new ArrayList<String>() ;
        int indexOfOperator;

        String RealNumber;
        boolean isOperator=false;

        for (int i = 0; i < listChars.size(); i++) {
            if(listChars.get(i).toString().contentEquals("+")|| listChars.get(i).toString().contentEquals("-")|| listChars.get(i).toString().contentEquals("/")){
                listOperator.add(listChars.get(i).toString());
                isOperator=true;
            }
            else{
                if(isOperator) {
                    RealNumber="";
                    for (int j = 0; j < listCharNumber.size(); j++) {
                      RealNumber+= listCharNumber.get(j);
                    }
                    listNumber.add(RealNumber);
                    listCharNumber.clear();
                    isOperator=false;

                }
                listCharNumber.add(listChars.get(i).toString());
            }
        }
        RealNumber="";
        for (int j = 0; j < listCharNumber.size(); j++) {
            RealNumber+= listCharNumber.get(j);
        }
        listNumber.add(RealNumber);
        int res=Integer.parseInt(listNumber.get(0));
        for (int i = 1; i < listNumber.size(); i++) {
            if(listOperator.get(i-1).contentEquals("+"))
                res+=Integer.parseInt(listNumber.get(i));
            else if(listOperator.get(i-1).contentEquals("-"))
                res-=Integer.parseInt(listNumber.get(i));
            else if(listOperator.get(i-1).contentEquals("/"))
                res/=Integer.parseInt(listNumber.get(i));
        }
        tvResult.setText(String.valueOf(res));
    }

    public static List<Character> convertStringToCharList(String str)
    {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }
}