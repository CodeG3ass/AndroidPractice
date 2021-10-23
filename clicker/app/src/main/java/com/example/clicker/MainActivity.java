package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int count = 0;

    private void SetTextCount() {
        int lastCharacter = count%10;
        int lastTwoCharacter = count%100;
        String raz = " раз";
        if ((lastCharacter == 2  || lastCharacter == 3 || lastCharacter == 4) && (lastTwoCharacter<10 || lastTwoCharacter>20)){

            raz =" раза";
        }
        TextView textView = (TextView) findViewById(R.id.clicks_count);
        textView.setText("Вы нажали кнопку "+ count+raz);
    }

    public void increseCount(View view) {
        count++;
        SetTextCount();
    }

    public void decreaseCount(View view) {
        count--;
        SetTextCount();
    }

    public void resetCount(View view) {
        count = 0;
        SetTextCount();
    }
}