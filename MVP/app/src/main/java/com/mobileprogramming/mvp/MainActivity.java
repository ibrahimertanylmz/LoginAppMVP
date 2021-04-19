package com.mobileprogramming.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobileprogramming.mvp.Presenter.InterfaceLoginPresenter;
import com.mobileprogramming.mvp.Presenter.LoginPresenter;
import com.mobileprogramming.mvp.View.InterfaceLoginView;

public class MainActivity extends AppCompatActivity implements InterfaceLoginView {

    EditText edtUsername, edtPassword;
    Button btnLogin;

    InterfaceLoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.buttonLogin);

        loginPresenter=new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edtUsername.getText().toString(),edtPassword.getText().toString());
            }
        });
    }

    @Override
    public void OnLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}