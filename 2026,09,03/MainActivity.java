package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button rzucaj;
    ImageView kosc1;
    ImageView kosc2;
    ImageView kosc3;
    ImageView kosc4;
    ImageView kosc5;

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
        kosc1 = findViewById(R.id.imageView2);
        kosc2 = findViewById(R.id.imageView3);
        kosc3 = findViewById(R.id.imageView4);
        kosc4 = findViewById(R.id.imageView5);
        kosc5 = findViewById(R.id.imageView6);

        int wynik_og;

        rzucaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tablicaKosci[] = {(int)Math.random()*5+1,(int)Math.random()*5+1,(int)Math.random()*5+1,(int)Math.random()*5+1,(int)Math.random()*5+1};
                int wynik_sz = tablicaKosci[1]+tablicaKosci[2]+tablicaKosci[3]+tablicaKosci[4]+tablicaKosci[5];

            }
        });
    }
}