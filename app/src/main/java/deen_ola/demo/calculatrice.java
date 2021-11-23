package deen_ola.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class calculatrice extends AppCompatActivity {

    String oldNumber="";
    String op = "+";
    boolean isNewOp = true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        ed1 = findViewById(R.id.editText);
    }

    public void touchEvent(View view) {
        if (isNewOp)
            ed1.setText("");
        isNewOp = false;

        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.b0:
                number += "0";
                break;
            case R.id.b1:
                number += "1";
                break;
            case R.id.b2:
                number += "2";
                break;
            case R.id.b3:
                number += "3";
                break;
            case R.id.b4:
                number += "4";
                break;
            case R.id.b5:
                number += "5";
                break;
            case R.id.b6:
                number += "6";
                break;
            case R.id.b7:
                number += "7";
                break;
            case R.id.b8:
                number += "8";
                break;
            case R.id.b9:
                number += "9";
                break;
            case R.id.bpouint:
                number += ",";
                break;
            case R.id.bplusmoins:
                number += "-"+number;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view){
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.bdiv: op = "/"; break;
            case R.id.bmulti: op = "*"; break;
            case R.id.bplus: op = "+"; break;
            case R.id.bmoins: op = "-"; break;

        }

    }

    public void equalEvent(View view){

        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op){

            case "+":
                result = Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }

    public void clearEvent(View view){

        ed1.setText("0");
        isNewOp = true;
    }

    public void pourcentEvent(View view){

        double no = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isNewOp = true;
    }
}