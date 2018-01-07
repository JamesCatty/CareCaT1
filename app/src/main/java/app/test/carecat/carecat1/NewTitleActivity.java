package app.test.carecat.carecat1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class NewTitleActivity extends AppCompatActivity {

    private final static String TAG = "aaa";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Log.d(TAG,"navigation_home");
                    return true;
                case R.id.navigation_calendar:
                    Log.d(TAG,"navigation_calendar");
                    return true;
                case R.id.navigation_chat:
                    Log.d(TAG,"navigation_chat");
                    return true;
                case R.id.navigation_person:
                    Log.d(TAG,"navigation_person");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_title);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
