package com.ediertamayo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bMas,bPor,bMenos,bDividido,bModulo;
    TextView tvBarra;
    String cadena="";
    double num1,num2,resultado;
    int nodo,operacion,recurrente=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b0=findViewById(R.id.b0);
        tvBarra=findViewById(R.id.tvBarra);
    }

    public void calcular(View view) {
        int id=view.getId();

        switch (id){
            case R.id.b0:
                cadena=cadena+"0";
                break;
            case R.id.b1:
                cadena=cadena+"1";
                break;
            case R.id.b2:
                cadena=cadena+"2";
                break;
            case R.id.b3:
                cadena=cadena+"3";
                break;
            case R.id.b4:
                cadena=cadena+"4";
                break;
            case R.id.b5:
                cadena=cadena+"5";
                break;
            case R.id.b6:
                cadena=cadena+"6";
                break;
            case R.id.b7:
                cadena=cadena+"7";
                break;
            case R.id.b8:
                cadena=cadena+"8";
                break;
            case R.id.b9:
                cadena=cadena+"9";
                break;
            case R.id.bPunto:
                cadena=cadena+".";
                break;
            case R.id.bMas:
                if(!cadena.equals("")){
                    String ultimo=cadena.substring(cadena.length()-1,cadena.length());
                    if(!ultimo.equals("+")&&!ultimo.equals("-")&&!ultimo.equals("*")&&!ultimo.equals("/")&&!ultimo.equals("%")){
                        if(recurrente==1)cadena=Double.toString(resultado);                       num1=Double.parseDouble(cadena);
                        cadena=cadena+"+";
                        nodo=cadena.length();
                        operacion=1;
                        recurrente=0;
                    }
                }
                break;
            case R.id.bMenos:
                if(!cadena.equals("")){
                    String ultimo=cadena.substring(cadena.length()-1,cadena.length());
                    if(!ultimo.equals("+")&&!ultimo.equals("-")&&!ultimo.equals("*")&&!ultimo.equals("/")&&!ultimo.equals("%")){
                        if(recurrente==1)cadena=Double.toString(resultado);
                        num1=Double.parseDouble(cadena);
                        cadena=cadena+"-";
                        nodo=cadena.length();
                        operacion=2;
                        recurrente=0;
                    }
                }
                break;
            case R.id.bPor:
                if(!cadena.equals("")){
                    String ultimo=cadena.substring(cadena.length()-1,cadena.length());
                    if(!ultimo.equals("+")&&!ultimo.equals("-")&&!ultimo.equals("*")&&!ultimo.equals("/")&&!ultimo.equals("%")){
                        if(recurrente==1)cadena=Double.toString(resultado);
                        num1=Double.parseDouble(cadena);
                        cadena=cadena+"*";
                        nodo=cadena.length();
                        operacion=3;
                        recurrente=0;
                    }
                }
                break;
            case R.id.bDividido:
                if(!cadena.equals("")){
                String ultimo=cadena.substring(cadena.length()-1,cadena.length());
                    if(!ultimo.equals("+")&&!ultimo.equals("-")&&!ultimo.equals("*")&&!ultimo.equals("/")&&!ultimo.equals("%")){
                        if(recurrente==1)cadena=Double.toString(resultado);
                        num1=Double.parseDouble(cadena);
                        cadena=cadena+"/";
                        nodo=cadena.length();
                        operacion=4;
                        recurrente=0;
                    }
                }
                break;
            case R.id.bModulo:
                if(!cadena.equals("")){
                    String ultimo=cadena.substring(cadena.length()-1,cadena.length());
                    if(!ultimo.equals("+")&&!ultimo.equals("-")&&!ultimo.equals("*")&&!ultimo.equals("/")&&!ultimo.equals("%")){
                        if(recurrente==1)cadena=Double.toString(resultado);
                        num1=Double.parseDouble(cadena);
                        cadena=cadena+"%";
                        nodo=cadena.length();
                        operacion=5;
                        recurrente=0;
                    }
                }
                break;
            case R.id.bAc:
                cadena="";
                recurrente=0;
                operacion=7;
                break;
            case R.id.bIgual:
                num2=Double.parseDouble(cadena.substring(nodo,cadena.length()));
               if(operacion==1)resultado=num1+num2;
               if(operacion==2)resultado=num1-num2;
               if(operacion==3)resultado=num1*num2;
               if(operacion==4)resultado=num1/num2;
               if(operacion==5)resultado=num1%num2;
               operacion=6;
                break;
        }
        if(operacion==6){
            tvBarra.setText(Double.toString(resultado));
            recurrente=1;
        }
        else if(operacion==7){
            tvBarra.setText(cadena.toString());
        }
        else tvBarra.setText(cadena.toString());
    }
}
