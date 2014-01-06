package com.mengdd.transaction.activity.leftfade;

import com.mengdd.transactionani.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leftfade_layout);

        View decorView = getWindow().getDecorView();
//        decorView.setBackgroundColor(Color.RED);
//        decorView.setBackgroundColor(Color.BLACK);
        decorView.setBackgroundColor(Color.WHITE);

        View nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in,
                        R.anim.fade_out_left);
            }
        });
    }
}
