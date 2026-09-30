package edu.zsk.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );
            return insets;
        });

        ListView lista = findViewById(R.id.lista);
        Button guzik = findViewById(R.id.button);
        EditText tekst1 = findViewById(R.id.editTextText);
        ArrayList<String> elementy = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                elementy
        );

        lista.setAdapter(adapter);

        guzik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tekst_z_guzika = tekst1.getText().toString().trim();

                if (!tekst_z_guzika.isEmpty()) {
                    elementy.add(tekst_z_guzika);
                    adapter.notifyDataSetChanged();
                    tekst1.setText("");
                }
            }
        });
    }
}
