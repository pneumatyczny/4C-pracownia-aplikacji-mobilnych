package edu.zsk.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.zsk.myapplication.R;

public class MainActivity extends AppCompatActivity {

    void ustawKosc(ImageView holder, int wynik){
        switch (wynik) {
            case 0:
                holder.setImageResource(R.drawable.question);
                break;
            case 1:
                holder.setImageResource(R.drawable.k1);
                break;
            case 2:
                holder.setImageResource(R.drawable.k2);
                break;
            case 3:
                holder.setImageResource(R.drawable.k3);
                break;
            case 4:
                holder.setImageResource(R.drawable.k4);
                break;
            case 5:
                holder.setImageResource(R.drawable.k5);
                break;
            case 6:
                holder.setImageResource(R.drawable.k6);
                break;
        }
    }
    Button rzucaj;
    Button resetuj;
    ImageView kosc1;
    ImageView kosc2;
    ImageView kosc3;
    ImageView kosc4;
    ImageView kosc5;
    TextView wynik_sz_holder;
    TextView wynik_og_holder;
    int wynik_og = 0;
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
        rzucaj = findViewById(R.id.button);
        resetuj = findViewById(R.id.button2);
        kosc1 = findViewById(R.id.imageView2);
        kosc2 = findViewById(R.id.imageView3);
        kosc3 = findViewById(R.id.imageView4);
        kosc4 = findViewById(R.id.imageView5);
        kosc5 = findViewById(R.id.imageView6);
        wynik_sz_holder = findViewById(R.id.textView);
        wynik_og_holder = findViewById(R.id.textView2);


        rzucaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] tablicaKosci = {(int)(Math.random()*6)+1,(int)(Math.random()*6)+1,(int)(Math.random()*6)+1,(int)(Math.random()*6)+1,(int)(Math.random()*6)+1};
                int wynik_sz = tablicaKosci[0]+tablicaKosci[1]+tablicaKosci[2]+tablicaKosci[3]+tablicaKosci[4];
                wynik_og = wynik_og + wynik_sz;
                wynik_sz_holder.setText("Wynik tego losowania: "+String.valueOf(wynik_sz));
                wynik_og_holder.setText("Wynik gry: "+String.valueOf(wynik_og));
                ustawKosc(kosc1, tablicaKosci[0]);
                ustawKosc(kosc2, tablicaKosci[1]);
                ustawKosc(kosc3, tablicaKosci[2]);
                ustawKosc(kosc4, tablicaKosci[3]);
                ustawKosc(kosc5, tablicaKosci[4]);
            }
        });
        resetuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik_sz_holder.setText("Wynik tego losowania: ");
                wynik_og_holder.setText("Wynik gry: ");
                ustawKosc(kosc1, 0);
                ustawKosc(kosc2, 0);
                ustawKosc(kosc3, 0);
                ustawKosc(kosc4, 0);
                ustawKosc(kosc5, 0);
                wynik_og = 0;
            }
        });
    }
}
