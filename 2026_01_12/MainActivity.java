package com.example.beta;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
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

        // Initial state
        messageTextView.setText("Autor: 00000000000");
        messageTextView.setTextColor(Color.BLACK);

        submitButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString();
            String repeatPassword = repeatPasswordEditText.getText().toString();

            if (!isValidEmail(email)) {
                showError("Nieprawidłowy adres e-mail");
            } else if (!password.equals(repeatPassword)) {
                showError("Hasła się różnią");
            } else if (!isValidPassword(password)) {
                showError("Hasło nie spełnia wymagań");
            } else {
                // Success: Navigate to WelcomeActivity
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("USER_EMAIL", email);
                startActivity(intent);
            }
        });
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
        }

        return hasDigit && hasUpper && hasLower;
    }

    private void showError(String message) {
        messageTextView.setText(message);
        messageTextView.setTextColor(Color.RED);
    }
}
