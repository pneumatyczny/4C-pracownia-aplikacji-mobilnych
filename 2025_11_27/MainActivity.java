package com.example.alfa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private TextView textView3;
    private EditText editText4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText1 = findViewById(R.id.editText1);
        textView3 = findViewById(R.id.textView3);
        editText4 = findViewById(R.id.editText4);
        Button button5 = findViewById(R.id.button5);

        button5.setOnClickListener(v -> {
            String text = editText4.getText().toString();
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        });
    }

    public void onButtonClick(View view) {
        String text = editText1.getText().toString();
        textView3.setText(text);
    }
}
