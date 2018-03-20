package com.sas_apps.mvpsignin.model;
/*
 * Created by Shashank Shinde.
 */

import com.sas_apps.mvpsignin.presenter.SignInPresenter;
import com.sas_apps.mvpsignin.view.SignInView;

public class SignInPresenterImplementation implements SignInPresenter {

    private SignInView signInView;

    public SignInPresenterImplementation(SignInView signInView) {
        this.signInView = signInView;
    }

    @Override
    public void attemptSignIn(String email, String password) {
        if (email.isEmpty() && password.isEmpty()) {
            signInView.onEmptyData();
        } else {
            if (email.equalsIgnoreCase("sha44.shinde@gmail.com") && password.equals("12345")) {
                signInView.onSuccess();
            } else {
                signInView.onInvalidCredentials();
            }
        }
    }
}
