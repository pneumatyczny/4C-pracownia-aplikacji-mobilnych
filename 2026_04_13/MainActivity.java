package edu.zsk.eta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editEmail;
    private TextView txt1, txt2;
    private int clickCount = 0;

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

        editName = findViewById(R.id.editTextText2);
        editEmail = findViewById(R.id.editTextTextEmailAddress2);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        Button button = findViewById(R.id.button2);

        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt("clickCount");
            txt1.setText(savedInstanceState.getString("txt1_text"));
            txt2.setText(savedInstanceState.getString("txt2_text"));
        }

        button.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, R.string.error_missing_data, Toast.LENGTH_SHORT).show();
            } else {
                clickCount++;
                txt1.setText(getString(R.string.welcome_message, name, email));
                txt2.setText(getString(R.string.click_count_message, clickCount));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickCount", clickCount);
        outState.putString("txt1_text", txt1.getText().toString());
        outState.putString("txt2_text", txt2.getText().toString());
    }
}
