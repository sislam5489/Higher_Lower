package edu.fordham.higher_lower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomInt = generateRandomInt();
    }
    public int generateRandomInt(){
        return getRandomNumberInRange(1,20);
    }
    private int getRandomNumberInRange(int min, int max){
        if(min >= max) throw new IllegalArgumentException("max must be greater than min");
        Random r = new Random();
        return r.nextInt((max-min)+1) + min;
    }

    int randomInt;

    public void guess(View view){
        Log.i("app2","Button clicked");
        EditText editText = findViewById(R.id.editTextNumber);
        String guessStr = editText.getText().toString();
        if(guessStr.isEmpty()) {
            Toast t = Toast.makeText(this, "Please enter an Integer", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        int guessInt = Integer.parseInt(guessStr);
        Log.i("app2", "Guess string: " + guessStr);

        String msg;
        if(guessInt > randomInt){
            msg = "Lower";
        }else if (guessInt < randomInt) {
            msg = "Higher";
        }else{
            msg = "You got it! Try again!";
            randomInt = generateRandomInt();
        }
        Toast t = Toast.makeText(this,msg, Toast.LENGTH_SHORT);
        t.show();

    }

}