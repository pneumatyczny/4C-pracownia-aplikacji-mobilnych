package com.example.gamma;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        EditText etEmail = view.findViewById(R.id.etEmail);
        EditText etFirstName = view.findViewById(R.id.etFirstName);
        EditText etLastName = view.findViewById(R.id.etLastName);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String firstName = etFirstName.getText().toString().trim();
            String lastName = etLastName.getText().toString().trim();

            if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(getContext(), "Wszystkie pola są wymagane", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(getContext(), "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                return;
            }

            SecondFragment secondFragment = SecondFragment.newInstance(email, firstName, lastName);
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}
