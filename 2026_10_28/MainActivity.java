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
    private String Cezar(String napis, int k){
        StringBuilder wynik = new StringBuilder();
        k = (k % 26 + 26) % 26;

        for (char znak : napis  .toCharArray()) {
            if (Character.isLetter(znak)) {
                if (Character.isUpperCase(znak)) {
                    char nowyZnak = (char) ('A' + (znak - 'A' + k) % 26);
                    wynik.append(nowyZnak);
                } else {
                    char nowyZnak = (char) ('a' + (znak - 'a' + k) % 26);
                    wynik.append(nowyZnak);
                }
            } else {
                wynik.append(znak);
            }
        }
        return wynik.toString();
    }

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
        EditText klucz = findViewById(R.id.editTextNumber);
        EditText oryginal = findViewById(R.id.editTextText2);
        Button szyfruj = findViewById(R.id.button);
        TextView wyjscie = findViewById(R.id.textView5);


        szyfruj.setOnClickListener(v -> {
            int kluczyk = Integer.parseInt(klucz.getText().toString());
            String orgyginalek = oryginal.getText().toString();
            String gotowe = Cezar(orgyginalek,kluczyk);
            wyjscie.setText(gotowe);
        });
    }
}
