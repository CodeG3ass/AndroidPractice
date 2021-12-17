package com.example.practicewithimage;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_Add;
    EditText edittext_work;
    ListView listview_works;
    int SelectedItemId;
    String item;
    String extraWeek = "currentWeekArrayList";
    ArrayList<String> WorksDay;
    ArrayList<String> WorksWeek;
    ArrayList<String> WorksMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_Add = (Button) findViewById(R.id.button_Add);
        edittext_work = (EditText) findViewById(R.id.edittext_work);
        listview_works = (ListView) findViewById(R.id.listview_works);
        WorksDay = new ArrayList<>();
        WorksWeek = new ArrayList<>();
        WorksMonth = new ArrayList<>();
        String[] Works = new String[]{"Ежедневное", "Еженедельное", "Ежемесячное",};
        ArrayAdapter<String> adapter_works = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Works);
        adapter_works.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listview_works.setAdapter(adapter_works);
        button_Add.setOnClickListener(this);
        listview_works.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                SelectedItemId = position;
                listview_works.setItemChecked(SelectedItemId,true);
            }
        });
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button_Add:
                switch (SelectedItemId) {
                    case 0:
                        intent = new Intent(this, MainActivity2.class);
                        WorksDay.add(edittext_work.getText().toString());
                        if (WorksDay != null) {
                            intent.putExtra("day", WorksDay);
                        }
                        startActivity(intent);
                        break;
                    case 1:
                        WorksWeek.add(edittext_work.getText().toString());
                        intent = new Intent(this, MainActivity3.class);
                        if (WorksWeek != null) {
                            intent.putExtra("week", WorksWeek);
                        }
                        startActivity(intent);
                        break;
                    case 2:
                        WorksMonth.add(edittext_work.getText().toString());
                        intent = new Intent(this, MainActivity4.class);
                        if (WorksMonth != null) {
                            intent.putExtra("month", WorksMonth);
                        }
                        startActivity(intent);
                        break;
                }
                break;
        }
    }

    ActivityResultLauncher<Intent> GetResultFromIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result ) {
                    Intent data;
                    String key;
                    switch (result.getResultCode()) {
                        case 0:
                            data = result.getData();
                            key = "day";
                            WorksDay = data.getExtras().getStringArrayList(key);
                            break;
                        case 1:
                            key = "week";
                            data = result.getData();
                            WorksWeek = data.getExtras().getStringArrayList(key);
                            break;
                        case 2:
                            key = "month";
                            data = result.getData();
                            WorksMonth = data.getExtras().getStringArrayList(key);
                            break;
                    }

                    }
                });
}