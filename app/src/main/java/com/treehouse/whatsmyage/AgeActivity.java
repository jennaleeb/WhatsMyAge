package com.treehouse.whatsmyage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AgeActivity extends AppCompatActivity {

    private TextView mAgeText;
    private String mAge;
    private Button mStartAgainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        Intent intent = getIntent();
        mAge = intent.getStringExtra(getString(R.string.get_age));

        mAgeText = (TextView) findViewById(R.id.textAge);
        mAgeText.setText(mAge);

        mStartAgainButton = (Button) findViewById(R.id.startAgainButton);

        mStartAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
