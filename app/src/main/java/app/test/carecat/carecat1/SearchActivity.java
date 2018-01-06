package app.test.carecat.carecat1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SearchActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button doSetDate;
    private Button doSetStartTime;
    private TextView textDate;
    private TextView textStart;
    private DatePickerDialog datePickDialog;
    private TimePickerDialog startTimePickDialog;
    private GregorianCalendar calendar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_calendar:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_chat:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_person:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        doFindView();
       calendar = new GregorianCalendar();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Spinner
        Spinner serviceCategory = (Spinner)findViewById(R.id.serviceCategory);
        ArrayAdapter<CharSequence> serviceCategory_nAdapter = ArrayAdapter.createFromResource(
                this, R.array.serviceCategory_array, android.R.layout.simple_spinner_item );
        serviceCategory_nAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        serviceCategory.setAdapter(serviceCategory_nAdapter);
        String text = serviceCategory.getSelectedItem().toString();

        // do datePickDialog
        datePickDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                textDate.setText(year + "/" + month + "/" + day);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        // do startTimePickDialog
        startTimePickDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                textStart.setText((hour > 12 ? hour - 12 : hour)+":"+minute+" "+(hour > 12 ? "PM" : "AM"));
            }
        },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(calendar.MINUTE),false);

    }

    // 連接Layout
    public void doFindView(){
        doSetDate = (Button) findViewById(R.id.buttonDate);
        textDate = (TextView) findViewById(R.id.datetext);
        doSetStartTime = (Button) findViewById(R.id.buttonStartTime);
        textStart = (TextView) findViewById(R.id.textStart);
    }
    // setDate onclick
    public void setDate(View v){
        datePickDialog.show();
    }
    // setDate onclick
    public void setStartTime(View v){
        startTimePickDialog.show();
    }
}
