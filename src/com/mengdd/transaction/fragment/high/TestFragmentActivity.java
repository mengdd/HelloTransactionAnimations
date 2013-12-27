package com.mengdd.transaction.fragment.high;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mengdd.transactionani.R;

public class TestFragmentActivity extends Activity {

	private Button mAddButton = null;
	private Button mRemoveButton = null;
	private FragmentManager mFragmentManager = null;
	private Fragment mTextFragmentOne = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_fragment_activity);

		mFragmentManager = getFragmentManager();
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
			mFragmentManager = getFragmentManager();
		}

		mTextFragmentOne = new MyFragmentOne();
		FragmentTransaction fragmentTransaction = mFragmentManager
				.beginTransaction();

		// 标准动画
		// fragmentTransaction
		// .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		// fragmentTransaction
		// .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

		// fragmentTransaction
		// .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);

		// 自定义动画

		// API LEVEL 11
		// fragmentTransaction.setCustomAnimations(
		// R.animator.fragment_slide_left_enter,
		// R.animator.fragment_slide_right_exit);

		// API LEVEL 13
		// fragmentTransaction.setCustomAnimations(
		// R.animator.fragment_slide_left_enter,
		// R.animator.fragment_slide_left_exit,
		// R.animator.fragment_slide_right_enter,
		// R.animator.fragment_slide_right_exit);

		fragmentTransaction.add(R.id.container, mTextFragmentOne);

		// 加入到BackStack中
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();

	}

	private void removeFragment() {
		if (null == mFragmentManager) {
			mFragmentManager = getFragmentManager();
		}
		mFragmentManager.popBackStack();
	}

}
