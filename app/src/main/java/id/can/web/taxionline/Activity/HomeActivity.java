package id.can.web.taxionline.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import id.can.web.taxionline.Fragment.CallCenterFragment;
import id.can.web.taxionline.Fragment.GlobalHistoryFragment;
import id.can.web.taxionline.Helper.Config;
import id.can.web.taxionline.R;
import id.can.web.taxionline.Fragment.HomeFragment;
import id.can.web.taxionline.Fragment.ProfilFragment;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.frame_layout, new HomeFragment())
                            .commit();
                    return true;
                case R.id.navigation_history:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.frame_layout, new GlobalHistoryFragment())
                            .commit();

                    return true;
                case R.id.navigation_help:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.frame_layout, new CallCenterFragment())
                            .commit();
                    return true;
                case R.id.navigation_profil:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.frame_layout, new ProfilFragment())
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        SharedPreferences sp = getSharedPreferences(Config.SHARED_PREF_NAME, 0);
        Log.e("FALSE US TTTTT: ",sp.getString(Config.SHARED_PREF_TOKEN,""));
        Log.e("FALSE US UID: ",sp.getString(Config.SHARED_USERNAME,""));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.frame_layout, new HomeFragment())
                .commit();



    }

}
