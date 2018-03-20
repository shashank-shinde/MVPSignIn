package com.sas_apps.mvpsignin;
/*
 * Created by Shashank Shinde.
 */


import com.sas_apps.mvpsignin.model.SignInPresenterImplementation;
import com.sas_apps.mvpsignin.view.SignInView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PresenterUnitTesting {

    @Mock
    SignInView signInView;
    @Mock
    SignInPresenterImplementation presenterImplementation;

    @Before
    public void setUpTest() throws Exception{
        presenterImplementation=new SignInPresenterImplementation(signInView);
    }

    @Test
    public void  checkInvalidUser() throws Exception{
        presenterImplementation.attemptSignIn("dsfsdfsd","42453453");
        presenterImplementation.attemptSignIn("afasgg","453543");
        presenterImplementation.attemptSignIn("affbdbgngnasgg","45356f43");
        presenterImplementation.attemptSignIn("jhgjghjghjghj","4532422");
        verify(signInView,times(4)).onInvalidCredentials();
    }

    @Test
    public void checkEmptyCredentials() throws Exception{
        presenterImplementation.attemptSignIn("","");
        verify(signInView).onEmptyData();
    }


    @Test
    public void checkSignInSuccess() throws Exception{
        presenterImplementation.attemptSignIn("sha44.shinde@gmail.com","12345");
        verify(signInView).onSuccess();
    }

}
