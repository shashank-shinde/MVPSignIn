package com.sas_apps.mvpsignin.view;
/*
 * Created by Shashank Shinde.
 */

public interface SignInView {
    void onSuccess();
    void onEmptyData();
    void onInvalidCredentials();
}
