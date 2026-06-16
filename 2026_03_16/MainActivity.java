package edu.zsk.dzeta;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String wybraneZwierze = "";

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

        EditText etWlasciciel = findViewById(R.id.editTextText);
        ListView listView = findViewById(R.id.listView);
        TextView tvWiek = findViewById(R.id.textView5);
        SeekBar seekBar = findViewById(R.id.seekBar);
        EditText etCel = findViewById(R.id.editTextText2);
        EditText etCzas = findViewById(R.id.editTextTime);
        Button button = findViewById(R.id.button);
        TextView tvWynik = findViewById(R.id.textViewResult);

        String[] zwierzeta = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, zwierzeta);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wybraneZwierze = zwierzeta[position];
                switch (position) {
                    case 0: // Pies
                        seekBar.setMax(18);
                        break;
                    case 1: // Kot
                        seekBar.setMax(20);
                        break;
                    case 2: // Świnka morska
                        seekBar.setMax(9);
                        break;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvWiek.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wlasciciel = etWlasciciel.getText().toString();
                String cel = etCel.getText().toString();
                String czas = etCzas.getText().toString();
                int wiek = seekBar.getProgress();

                String wynik = wlasciciel + ", " + wybraneZwierze + ", " + wiek + ", " + cel + ", " + czas;
                tvWynik.setText(wynik);
                Toast.makeText(MainActivity.this, wynik, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
