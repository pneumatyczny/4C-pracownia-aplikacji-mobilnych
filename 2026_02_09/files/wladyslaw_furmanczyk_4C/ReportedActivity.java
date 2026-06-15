package edu.zsk.wladyslaw_furmanczyk_4C;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReportedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reported);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView reported_name = findViewById(R.id.reported_name);
        TextView reported_surname = findViewById(R.id.reported_surname);
        TextView reposted_class = findViewById(R.id.reposted_class);
        Button add_note_button = findViewById(R.id.add_note_button);

        Intent intent = getIntent();
        if (intent != null) {
            reported_name.setText(intent.getStringExtra("name"));
            reported_surname.setText(intent.getStringExtra("surname"));
            reposted_class.setText(intent.getStringExtra("className"));
        }

        add_note_button.setOnClickListener(v -> finish());
    }
}
