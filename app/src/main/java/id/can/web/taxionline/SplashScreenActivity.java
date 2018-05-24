package id.can.web.taxionline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import id.can.web.taxionline.Activity.HomeActivity;
import id.can.web.taxionline.Helper.Config;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, MODE_PRIVATE);
                String username = sp.getString(Config.SHARED_USERNAME, "");
                String email = sp.getString(Config.SHARED_EMAIL, "");
                String rule = sp.getString(Config.SHARED_RULE, "");

                // TODO jika belum masuk ke LoginActivity
                if (username.equalsIgnoreCase("") || TextUtils.isEmpty(username)){
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
                // TODO jika sudah nantinya akan masuk ke Home
//                else {
//                    if (rule.contains("user")){
//                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                    }
                    else {
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }

//                }
            }
        }, 2000);
    }
}
