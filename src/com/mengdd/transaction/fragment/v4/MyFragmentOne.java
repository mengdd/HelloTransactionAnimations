package com.mengdd.transaction.fragment.v4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.mengdd.transactionani.R;

public class MyFragmentOne extends Fragment {

	private static int sCount = 0;
	private int mId = 0;
	private final int[] mColors = new int[] { Color.RED, Color.GREEN,
			Color.BLUE, Color.BLACK };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		++sCount;
		mId = sCount;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.myfragment_layout, container,
				false);

		TextView textView = (TextView) view.findViewById(R.id.fragment_name);
		textView.setText("This is Fragment No." + mId);
		textView.setBackgroundColor(mColors[mId % mColors.length]);

		return view;
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
		return super.onCreateAnimation(transit, enter, nextAnim);
	}
}
