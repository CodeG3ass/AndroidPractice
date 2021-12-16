package com.example.secondapplicationwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent intent;
        switch (item.getItemId()) {
            case R.id.activity_1:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_2:
                intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.activity_3:
                intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                break;
            case R.id.activity_4:
                intent = new Intent(this, MainActivity4.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}