package com.mobileprogramming.mvp.Presenter;

import com.mobileprogramming.mvp.Model.User;
import com.mobileprogramming.mvp.View.InterfaceLoginView;

public class LoginPresenter implements InterfaceLoginPresenter {

    InterfaceLoginView LoginView;

    public LoginPresenter(InterfaceLoginView loginView) {
        LoginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        boolean isLoginSuccess = user.isValid();

        if (isLoginSuccess)
        {
            LoginView.OnLoginResult("Succesful Login!");
        } else {
            LoginView.OnLoginResult("Error!");
        }
    }
}
