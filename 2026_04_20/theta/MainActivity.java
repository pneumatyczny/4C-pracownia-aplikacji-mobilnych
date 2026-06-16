package edu.zsk.theta;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        LinearLayout container = findViewById(R.id.imageContainer);
        for (int i = 1; i <= 15; i++) {
            String imageName = "obraz_" + i;
            int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            
            if (resId != 0) {
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(400, 400);
                params.setMargins(8, 0, 8, 0);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(resId);
                
                imageView.setOnClickListener(v -> {
                    ImageDialogFragment dialog = ImageDialogFragment.newInstance(resId);
                    dialog.show(getSupportFragmentManager(), "image_dialog");
                });
                
                container.addView(imageView);
            }
        }
    }
}
