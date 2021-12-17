package com.example.practicewithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    ListView lv_Works;
    Button button_back;
    ArrayList<String> Works;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        lv_Works = (ListView) findViewById(R.id.lv_Works);
        button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(this);
        Intent intent = getIntent();
        Works = intent.getStringArrayListExtra("month");
        ArrayAdapter<String> adapter_works = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Works);
        adapter_works.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lv_Works.setAdapter(adapter_works);
        adapter_works.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("month", Works);
        setResult(2, intent);
        finish();
    }
}