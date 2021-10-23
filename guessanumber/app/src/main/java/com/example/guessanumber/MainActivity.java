package com.example.guessanumber;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bControl = (Button) findViewById(R.id.button_input);
        bControl.setOnClickListener(OnClick);
        Button bExit = (Button) findViewById(R.id.appexit);
        bExit.setOnClickListener(ExitClick);
        Button bHelp = (Button) findViewById(R.id.button_help);
        bHelp.setOnClickListener(HelpClick);
        RadioButton rbHelp_1 = (RadioButton) findViewById(R.id.radioLvl1);
        RadioButton rbHelp_2 = (RadioButton) findViewById(R.id.radioLvl2);
        rbHelp_1.setOnClickListener(SelectLvl1Click);
        rbHelp_2.setOnClickListener(SelectLvl2Click);
    }


    private  int GetNumber(){
        Random rnd = new Random();
        return rnd.nextInt(100);
    }

    public  int number = GetNumber();

    private void onClickNewGame(){
        TextView tvInfo = (TextView) findViewById(R.id.text_show_info);
        tvInfo.setText(getResources().getString(R.string.try_to_guess));
        EditText etInput = (EditText) findViewById(R.id.text_input_number);
        etInput.setText("");
        number = GetNumber();
    }

    private View.OnClickListener StarNewGame = new View.OnClickListener() {
        public void onClick(View v) {
            Button bControl = (Button) findViewById(R.id.button_input);
            bControl.setText(getResources().getString(R.string.input_value));
            onClickNewGame();
            bControl.setOnClickListener(OnClick);
        }
    };

    private boolean isEmpty(EditText etText) {
     String  validation = etText.getText().toString();
     TextView tvInfo = (TextView) findViewById(R.id.text_show_info);
     if (validation.matches("")){
         return false;
        }
     else{
         return  true;
     }
    }

    private View.OnClickListener ExitClick = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
            System.exit(0);
        }
    };

    private View.OnClickListener SelectLvl1Click = new View.OnClickListener() {
        public void onClick(View v) {
            TextView tvHelp = (TextView) findViewById(R.id.textHelper);
            Button bHelp = (Button) findViewById(R.id.button_help);
            tvHelp.setVisibility(View.VISIBLE);
            bHelp.setEnabled(true);
        }
    };

    private View.OnClickListener SelectLvl2Click = new View.OnClickListener() {
        public void onClick(View v) {
            TextView tvHelp = (TextView) findViewById(R.id.textHelper);
            Button bHelp = (Button) findViewById(R.id.button_help);
            tvHelp.setVisibility(View.INVISIBLE);
            bHelp.setEnabled(false);
        }
        };

    private View.OnClickListener HelpClick = new View.OnClickListener() {
        public void onClick(View v) {
            TextView tvHelp = (TextView) findViewById(R.id.textHelper);
            tvHelp.setText(""+number);
        }
    };

    private View.OnClickListener OnClick = new View.OnClickListener() {
        public void onClick(View v) {
            TextView tvInfo = (TextView) findViewById(R.id.text_show_info);
            EditText etInput = (EditText) findViewById(R.id.text_input_number);
            Button bControl = (Button) findViewById(R.id.button_input);
            if (isEmpty(etInput)){
                if(Integer.parseInt(etInput.getText().toString()) > 100 || Integer.parseInt(etInput.getText().toString()) < 0) {
                    tvInfo.setText(getResources().getString(R.string.error2));
                }
                if (number < Integer.parseInt(etInput.getText().toString())) {
                    tvInfo.setText(getResources().getString(R.string.ahead));
                }
                if (number > Integer.parseInt(etInput.getText().toString())) {
                    tvInfo.setText(getResources().getString(R.string.behind));
                }
                if (number == Integer.parseInt(etInput.getText().toString())) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    bControl.setOnClickListener(StarNewGame);
                }
            }
            else{
                tvInfo.setText(getResources().getString(R.string.error));
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public  void onClickExit(){
        finish();
        System.exit(0);
    }

    // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        TextView tvHelp = (TextView) findViewById(R.id.textHelper);
        Button bHelp = (Button) findViewById(R.id.button_help);
        switch (item.getItemId()) {
            case R.id.menu_exit:
                onClickExit();
                return true;
            case R.id.menu_newgame:
                onClickNewGame();
                return true;
            case R.id.menu_dif1:
                tvHelp.setVisibility(View.VISIBLE);
                bHelp.setEnabled(true);
                return true;

            case R.id.menu_dif2:
                tvHelp.setVisibility(View.INVISIBLE);
                bHelp.setEnabled(false);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        // Выведем в TextView информацию о нажатом пункте меню
    }
}