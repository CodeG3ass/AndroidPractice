package com.example.layoutandview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener  {

    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    TextView mainTextView;
    Button ok_btn, cnc_btn;
    ListItemSlect listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mainTextView = (TextView) findViewById(R.id.main_textview);
        Button mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        mainTextView.setText("Set in Java!");
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);
        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);
        ok_btn.setOnClickListener(oclBtn);
        cnc_btn.setOnClickListener(oclBtn);
        mainListView.setOnItemClickListener(this);
        mainListView.setOnItemLongClickListener(this::onItemLongClick);

        mArrayAdapter.sort(new Comparator<String>() {
            @Override
            public int compare(String arg1, String arg0) {
                return arg1.compareTo(arg0);
            }
        });

    }

    public void onClick(View v) {
        mainTextView = (TextView) findViewById(R.id.main_textview);
        EditText mainEditText = (EditText) findViewById(R.id.main_edittext);
        ListView mainListView = findViewById(R.id.main_listview);
        mainTextView.setText(mainEditText.getText().toString() + " is learning Android development!");
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }

    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long id) {
        String selectedItem = mainListView.getItemAtPosition(position).toString();

        mArrayAdapter.remove(selectedItem);
        mArrayAdapter.notifyDataSetChanged();

        Toast.makeText(getApplicationContext(),
                selectedItem + " удалён.",
                Toast.LENGTH_SHORT).show();

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        mainListView.setOnItemClickListener(this);
        Log.d("omg android", position + ": " + mNameList.get(position));
        Toast.makeText(getApplicationContext(),
                mainListView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }


    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // по id определеяем кнопку, вызвавшую этот обработчик
            switch (v.getId()) {
                case R.id.ok_btn:
                    // кнопка ОК
                    Toast.makeText(getApplicationContext(), "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
                    break;
                case R.id.cnc_btn:
                    // кнопка Cancel
                    Toast.makeText(getApplicationContext(), "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                    break;
            }

        }

    };
}