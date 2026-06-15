package com.example.beta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText repeatPasswordEditText;
    private Button submitButton;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        submitButton = findViewById(R.id.submitButton);
        messageTextView = findViewById(R.id.messageTextView);

        messageTextView.setText("Autor: 67213767");

        submitButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString();
            String repeatPassword = repeatPasswordEditText.getText().toString();

            if (!email.contains("@")) {
                messageTextView.setText("Nieprawidłowy adres e-mail");
            } else if (!password.equals(repeatPassword)) {
                messageTextView.setText("Hasła się różnią");
            } else {
                messageTextView.setText("Witaj " + email);
            }
        });
    }
}
