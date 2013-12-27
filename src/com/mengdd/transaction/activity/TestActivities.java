package com.mengdd.transaction.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.mengdd.transactionani.R;


public class TestActivities extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activities);

		View firstButton = findViewById(R.id.first_btn);
		firstButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestActivities.this,
						TestActivityFirst.class);
				startActivity(intent);
				//transaction animation
				overridePendingTransition(R.anim.slide_in_bottom,
						R.anim.slide_out_bottom);
			}
		});

		View secondButton = findViewById(R.id.second_btn);
		secondButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TestActivities.this,
						TestActivitySecond.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		});
	}
}
