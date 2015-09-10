package com.treehouse.whatsmyage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker mDatePicker;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        mDatePicker.updateDate(1940, 0, 01);

        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = mDatePicker.getYear();
                int month = mDatePicker.getMonth();
                int day = mDatePicker.getDayOfMonth();

                int age = calculateAge(year,month,day);
                displayAge(age+"");
            }
        });

    }

    private int calculateAge(int year, int month, int day) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        int age = currentYear - year;

        if (currentMonth < month ) {
            age = age - 1;
        }

        else if (currentMonth == month ) {
            if (currentDayOfMonth < day) {
                age = age - 1;
            }
        }

        return age;
    }

    private void displayAge (String age) {
        Intent intent = new Intent(this, AgeActivity.class);
        intent.putExtra(getString(R.string.get_age), age);
        startActivity(intent);
    }




}
