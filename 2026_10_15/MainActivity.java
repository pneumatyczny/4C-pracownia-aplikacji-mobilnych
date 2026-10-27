package edu.zsk.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int polubienia = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button polub = findViewById(R.id.button);
        Button usun = findViewById(R.id.button2);
        TextView liczba = findViewById(R.id.textView3);

        polub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                polubienia++;
                liczba.setText(polubienia+" polubień");
            }
        });
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (polubienia>0){
                    polubienia--;
                }
                liczba.setText(polubienia+" polubień");
            }
        });
    }
}
