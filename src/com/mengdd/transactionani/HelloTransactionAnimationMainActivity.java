package com.mengdd.transactionani;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mengdd.transaction.activity.TestActivities;
import com.mengdd.transaction.activity.leftfade.FirstActivity;
import com.mengdd.transaction.fragment.high.TestFragmentActivity;
import com.mengdd.transaction.fragment.v4.TestFragmentV4Activity;

public class HelloTransactionAnimationMainActivity extends Activity {

    private ListView mListView = null;
    private static Sample[] mSamples = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSamples();
        mListView = (ListView) findViewById(R.id.list);
        mListView.setAdapter(new ArrayAdapter<Sample>(this,
                R.layout.my_list_item, R.id.text, mSamples));

        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                startActivity(new Intent(
                        HelloTransactionAnimationMainActivity.this,
                        mSamples[position].activityClass));
            }
        });
    }

    private void initSamples() {
        mSamples = new Sample[] {

                new Sample(R.string.fragment_test, TestFragmentV4Activity.class),
                new Sample(R.string.fragment_test_high,
                        TestFragmentActivity.class),
                new Sample(R.string.activity_test, TestActivities.class),
                new Sample(R.string.activity_test_left_fade,
                        FirstActivity.class)

        };
    }

    private class Sample {
        private final CharSequence title;
        private final Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);

        }

        @Override
        public String toString() {
            return title.toString();
        }
    }

}
