package com.mengdd.transaction.fragment.v4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mengdd.transactionani.R;


public class TestFragmentV4Activity extends FragmentActivity {

	private Button mAddButton = null;
	private Button mRemoveButton = null;
	private FragmentManager mFragmentManager = null;
	private Fragment mTextFragmentOne = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_fragment_activity);

		mFragmentManager = getSupportFragmentManager();
		mAddButton = (Button) findViewById(R.id.add_btn);
		mAddButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				addFragment();
			}
		});

		mRemoveButton = (Button) findViewById(R.id.remove_btn);
		mRemoveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				removeFragment();

			}
		});
	}

	private void addFragment() {
		if (null == mFragmentManager) {
			mFragmentManager = getSupportFragmentManager();
		}

		mTextFragmentOne = new MyFragmentOne();
		FragmentTransaction fragmentTransaction = mFragmentManager
				.beginTransaction();
		fragmentTransaction.setCustomAnimations(
				R.anim.push_left_in,
				R.anim.push_left_out,
				R.anim.push_left_in,
				R.anim.push_left_out);

		fragmentTransaction.add(R.id.container, mTextFragmentOne);

		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}

	private void removeFragment() {
		if (null == mFragmentManager) {
			mFragmentManager = getSupportFragmentManager();
		}
		mFragmentManager.popBackStack();
	}

}
