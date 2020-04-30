package com.example.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText emailAddressEditText;
    private EditText phoneEditText;
    private CheckBox checkBox;
    private TextView emailOutput;
    private TextView phoneOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailAddressEditText = findViewById(R.id.emailAddressInput);
        phoneEditText = findViewById(R.id.phoneInput);
        checkBox = findViewById(R.id.checking);
        emailOutput = findViewById(R.id.email_output);
        phoneOutput = findViewById(R.id.phone_output);
    }


    /**
     * This method is activated when the button on activity_login is activated.
     * It verifies if the mail and phone is valid
     */
    public void loginOnClick(View view) {
        String email = emailAddressEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        if (!isValidEmail(email)) {
            emailAddressEditText.setError(getString(R.string.error_email));
            return;
        }
        if (!isValidPhone(phone)) {
            phoneEditText.setError(getString(R.string.phone_error));
            return;
        }

        if (!checkBox.isChecked()) {
            Toast.makeText(this, R.string.checkbox_error, Toast.LENGTH_LONG).show();
            return;
        }
        emailOutput.setText(email);
        phoneOutput.setText(phone);
    }

    /**
     * This method validates the email
     *
     * @param email a String that represent the mail that should be valid
     * @return boolean
     */
    public boolean isValidEmail(String email) {
        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * This method validates the email
     *
     * @param phone a String that represent the mail that should be valid
     * @return boolean
     */
    public boolean isValidPhone(String phone) {
        return !phone.isEmpty() && Patterns.PHONE.matcher(phone).matches();
    }
}