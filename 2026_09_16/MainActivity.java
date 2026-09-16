package edu.zsk.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean stan = false;
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

        Button zatwierdz = findViewById(R.id.button);
        Button wlaczWylacz = findViewById(R.id.button3);
        EditText numerPrania = findViewById(R.id.editTextNumber);
        TextView pranie = findViewById(R.id.textView3);
        TextView odkurzacz = findViewById(R.id.textView8);
        TextView status = findViewById(R.id.textView9);

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numer = numerPrania.getText().toString();
                int a = Integer.parseInt(numer);
                if (a >= 1 && a <= 12) {
                    pranie.setText("Numer prania: " + numer);
                }
            }
        });
        wlaczWylacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stan == false) {
                    odkurzacz.setText("Odkurzacz włączony");
                    wlaczWylacz.setText("Wyłącz");
                    stan = true;
                } else {
                    odkurzacz.setText("Odkurzacz wyłączony");
                    wlaczWylacz.setText("Włącz");
                    stan = false;
                }
            }
        });
    }


}
