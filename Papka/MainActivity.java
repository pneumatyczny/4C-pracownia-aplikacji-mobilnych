package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

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
    }

    public void wyswietl(View view) {
        TextView textView = findViewById(R.id.textView);
        TextView myTextView = findViewById(R.id.editTextText);
        String tekst = myTextView.getText().toString();
        textView.setText(tekst);
    }


//    public void toast(View view) {
//        TextView toscik1 = findViewById(R.id.editTextText2);
//        String toscik2 = toscik1.getText().toString();
//        var duration = Toast.LENGTH_SHORT;
//        var toast = Toast.makeText(this, toscik2, duration);
//        toast.show();
//    }

//    public class MyFragment extends Fragment {
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            View view = inflater.inflate(R.layout.fragment_layout, container, false);
//
//            Button button = view.findViewById(R.id.button);
//            button.setOnClickListener(v -> {
//                EditText edit = view.findViewById(R.id.editTextText2);
//                Toast.makeText(requireContext(), edit.getText().toString(), Toast.LENGTH_SHORT).show();
//            });
//
//            return view;
//        }
//    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {

            FragmentActivity activity = getActivity();
            assert activity != null;
            EditText edit = activity.findViewById(R.id.editTextText2);
            Toast.makeText(activity, edit.getText().toString(), Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}