package com.example.iscampos.fcmpoc.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by iscampos on 2/3/17.
 */

public class PocFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG = PocFirebaseInstanceIdService.class.getSimpleName();
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token){
        Log.d(TAG, "Token: ");
        Log.d(TAG, token);
    }
}
