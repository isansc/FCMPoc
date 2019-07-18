package com.example.iscampos.fcmpoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GoogleApiAvailability.getInstance().makeGooglePlayServicesAvailable(this);

        Button btnToken = findViewById(R.id.btn_token);
        if(btnToken != null){
            btnToken.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");

                        String token = FirebaseInstanceId.getInstance().getToken();

                        Log.d(TAG, "Firebase Token: " + token);

                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, token);
                        startActivity(Intent.createChooser(sharingIntent, getString(R.string.txt_share_title)));
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                        Toast.makeText(MainActivity.this, R.string.txt_token_error, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
