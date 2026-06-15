package com.example.gamma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private static final String ARG_EMAIL = "email";
    private static final String ARG_FIRST_NAME = "first_name";
    private static final String ARG_LAST_NAME = "last_name";

    public static SecondFragment newInstance(String email, String firstName, String lastName) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_FIRST_NAME, firstName);
        args.putString(ARG_LAST_NAME, lastName);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        TextView tvEmail = view.findViewById(R.id.tvEmail);
        TextView tvFirstName = view.findViewById(R.id.tvFirstName);
        TextView tvLastName = view.findViewById(R.id.tvLastName);

        if (getArguments() != null) {
            tvEmail.setText("Email: " + getArguments().getString(ARG_EMAIL));
            tvFirstName.setText("Imię: " + getArguments().getString(ARG_FIRST_NAME));
            tvLastName.setText("Nazwisko: " + getArguments().getString(ARG_LAST_NAME));
        }

        return view;
    }
}
