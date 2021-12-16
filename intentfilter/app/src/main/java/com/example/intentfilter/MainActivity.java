package com.example.intentfilter;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonOpenCite, btnTime, btnDate, buttonCamera, btnChangeName, btn_image;
    EditText site, editText_Name;
    ImageView imageView;
    LinearLayout layout;
    TextView text_example, tvName;
    ImageView Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTime = (Button) findViewById(R.id.btnTime);
        btnDate = (Button) findViewById(R.id.btnDate);
        text_example = (TextView) findViewById(R.id.text_example);
        btnChangeName = (Button) findViewById(R.id.btnChangeName);
        buttonOpenCite = (Button) findViewById(R.id.buttonOpenCite);
        btn_image= (Button) findViewById(R.id.btn_image);
        editText_Name = (EditText) findViewById(R.id.etLName);
        buttonCamera= (Button) findViewById(R.id.buttonCamera);
        site =  (EditText) findViewById(R.id.edit_text);
        imageView = findViewById(R.id.img);
        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
        btn_image.setOnClickListener(this);
        buttonOpenCite.setOnClickListener(this);
        buttonCamera.setOnClickListener(this);
        btnChangeName.setOnClickListener(this);
        layout = findViewById(R.id.cont);
        findViewById(R.id.color).setOnClickListener(this);
        findViewById(R.id.align).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()) {
            case R.id.btnTime:
                intent = new Intent("android.example.intent.showtime");
                intent.putExtra("lname", editText_Name.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("android.example.intent.showdate");
                intent.putExtra("lname", editText_Name.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnChangeName:
                intent = new Intent(this, InputName.class);
                intent.putExtra("lname", editText_Name.getText().toString());
                mStartForResult.launch(intent);
                break;
            case R.id.buttonOpenCite:
                String url = site.getText().toString();
                if (!url.startsWith("https://") && !url.startsWith("http://")) {
                    url = "http://" + url;
                }
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
                break;
            case R.id.buttonCamera:
                startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                break;
            case R.id.color:
                Intent color_intent = new Intent(this, ColorText.class);
                mStartForResult.launch(color_intent);
                break;
            case R.id.align:
                Intent align_intent = new Intent(this, AlignActivity.class);
                mStartForResult.launch(align_intent);
                break;
            case R.id.btn_image:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                ResultCamera.launch(intent);
                break;
        }

    }
    ActivityResultLauncher<Intent> ResultCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result ) {
                    Intent intent;
                    switch (result.getResultCode()) {
                        case -1:
                            intent = result.getData();
                            Bundle extra = intent.getExtras();
                            Bitmap bitmap = (Bitmap) extra.get("data");
                            imageView.setImageBitmap(bitmap);
                    }
                }
            });


    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result ) {
                    Intent intent;
                    switch (result.getResultCode()) {
                        case InputName.RESULT_OK:
                            intent = result.getData();
                            tvName = (TextView) findViewById(R.id.tvName);
                            String name = intent.getStringExtra("name");
                            tvName.setText("Your name is " + name);
                            break;
                        case 1:
                            intent = result.getData();
                            String colorInt = intent.getStringExtra("color");
                            text_example.setTextColor(Integer.parseInt(colorInt));
                            break;
                        case 2:
                            intent = result.getData();
                            switch (intent.getStringExtra("align")) {
                                case "start":
                                    layout.setGravity(Gravity.START);
                                    break;
                                case "center":
                                    layout.setGravity(Gravity.CENTER);
                                    break;
                                case "end":
                                    layout.setGravity(Gravity.END);
                                    break;
                            }
                    }
                }
            });
}