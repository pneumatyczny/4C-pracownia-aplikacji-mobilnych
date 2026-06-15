package edu.zsk.wladyslaw_furmanczyk_4C;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText name_input, surname_input, class_input;

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

        name_input = findViewById(R.id.name_input);
        surname_input = findViewById(R.id.surname_input);
        class_input = findViewById(R.id.class_input);
        Button save_note_button = findViewById(R.id.save_note_button);

        save_note_button.setOnClickListener(v -> {
            String name = name_input.getText().toString();
            String surname = surname_input.getText().toString();
            String className = class_input.getText().toString();

            if (name.isEmpty() || surname.isEmpty() || className.isEmpty()) {
                Toast.makeText(MainActivity.this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
            } else {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Dodaję uwagę…");
                progressDialog.setMessage("Proszę czekać.");
                progressDialog.show();

                name_input.setText("");
                surname_input.setText("");
                class_input.setText("");

                new Handler().postDelayed(() -> {
                    progressDialog.dismiss();
                    Intent intent = new Intent(MainActivity.this, ReportedActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("surname", surname);
                    intent.putExtra("className", className);
                    startActivity(intent);
                }, 2000);
            }
        });
    }
}
