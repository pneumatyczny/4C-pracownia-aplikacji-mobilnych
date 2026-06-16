package edu.zsk.epsilon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            Intent intent = new Intent(Activity3.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
