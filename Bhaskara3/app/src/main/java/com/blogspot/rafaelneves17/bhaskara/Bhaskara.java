package com.blogspot.rafaelneves17.bhaskara;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Bhaskara extends AppCompatActivity implements View.OnClickListener{

    private EditText edtvalor1;
    private EditText edtvalor2;
    private EditText edtvalor3;

    private Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhaskara);

        edtvalor1 = (EditText) findViewById(R.id.edtvalor1);
        edtvalor2 = (EditText) findViewById(R.id.edtvalor2);
        edtvalor3 = (EditText) findViewById(R.id.edtvalor3);
        btncalcular = (Button) findViewById(R.id.btncalcular);

        btncalcular.setOnClickListener(this);


    }

    public void onClick(View v) {


        String v1 = edtvalor1.getText().toString();
        String v2 = edtvalor2.getText().toString();
        String v3 = edtvalor3.getText().toString();

        if (v1.trim().isEmpty() || v2.trim().isEmpty()  || v3.trim().isEmpty()) {


            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Há dados em branco :");
            dlg.setNeutralButton("OK", null);
            dlg.show();


        } else {
            double valor1 = Double.parseDouble(edtvalor1.getText().toString());
            double valor2 = Double.parseDouble(edtvalor2.getText().toString());
            double valor3 = Double.parseDouble(edtvalor3.getText().toString());

            if(valor1==0){
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("ERRO: VALOR DE A TEM QUE SER DIFERENTE DE 0");
                dlg.setNeutralButton("OK", null);
                dlg.show();



            }
            else {
                double x1,x2 ;
                double DELTA;
                DELTA = ((Math.pow(valor2,2))-(4*(valor1*valor3)));
                if(DELTA<0){

                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setMessage("ERROR: Delta menor que 0 : " +DELTA);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();


                }
                else{
                    x1=( ((-valor2)+(Math.sqrt(DELTA))) / (2*valor1) );
                    x2=( ((-valor2)-(Math.sqrt(DELTA))) / (2*valor1) );


                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setMessage("DELTA:"+ DELTA +  "\n X1 é :" + x1 +"\n X2 é:" + x2);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();

                }
            }
        }

    }
}
