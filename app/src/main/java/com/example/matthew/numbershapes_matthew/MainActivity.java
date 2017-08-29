package com.example.matthew.numbershapes_matthew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    class Number {

        int number;

        public boolean isTriangular(){

            int x = 1, triangularNumer = 1;
            while (triangularNumer < number ){
                x++;
                triangularNumer = triangularNumer +x;
            }
            if (triangularNumer == number){ return true; }
            else return false;
        }

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)){return true;}
            else return false;
        }
    }


    public void testNum (View view) {
        EditText userNumber = (EditText) findViewById(R.id.userNumber);
        String message = "";

        if (userNumber.getText().toString().isEmpty()) {
            message = "please enter a number";
        } else {
            Log.i("userNumber", userNumber.getText().toString());
            Number myNum = new Number();
            myNum.number = Integer.parseInt(userNumber.getText().toString()); //string to int
            System.out.println(myNum.isTriangular() + " triangular");
            System.out.println(myNum.isSquare() + " square");

            if (myNum.isSquare()) {
                if (myNum.isTriangular()) {
                    message = myNum.number + " is both a square and triangular ";
                } else {
                    message = myNum.number + " is square but not triangular";
                }
            } else {
                if (myNum.isTriangular()) {
                    message = myNum.number + " is not square but is triangular";
                } else {
                    message = myNum.number + " is not square and not triangular";
                }
            }
        }
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
