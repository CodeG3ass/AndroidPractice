package com.example.secondapplicationwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editAge;
    Button button_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAge = (EditText) findViewById(R.id.editAge);
        //button_next = (Button) findViewById(R.id.button_next);
        //button_next.setOnClickListener(this::OnClick);
    }

    public void OnClick(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        /*Object[] SendValues = new Object[]{ editText_puls.getText(), editText_puls2.getText(), s_day.getSelectedItem().toString(),
                s_month.getSelectedItem().toString(), s_year.getSelectedItem().toString(), s_year.getSelectedItem().toString()
        };*/
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent intent;
        switch (item.getItemId()) {
            case R.id.activity_2:
                intent = new Intent(this, MainActivity2.class);
                Bundle b = new Bundle();
                b.putStringArray("values", new String[]{editAge.getText().toString()});
                intent.putExtras(b);
                startActivity(intent);
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