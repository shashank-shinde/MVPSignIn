package com.sas_apps.mvpsignin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sas_apps.mvpsignin.model.SignInPresenterImplementation;
import com.sas_apps.mvpsignin.presenter.SignInPresenter;
import com.sas_apps.mvpsignin.view.SignInView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SignInView {

    private EditText editEmail, editPassword;
    private Button buttonSignIn;
    SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        buttonSignIn = findViewById(R.id.button_signIn);
        buttonSignIn.setOnClickListener(this);
        signInPresenter = new SignInPresenterImplementation(this);
    }

    @Override
    public void onClick(View v) {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        signInPresenter.attemptSignIn(email, password);
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyData() {
        Toast.makeText(this, "Empty data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInvalidCredentials() {
        Toast.makeText(this, "Invalid user", Toast.LENGTH_SHORT).show();
    }
}
