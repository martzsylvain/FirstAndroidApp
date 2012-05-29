package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Stack;

public class MyActivity extends Activity implements View.OnClickListener {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    /**
     * LifeCycle ****************************************************************************************************
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onRestart() {
        super.onRestart();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onResume() {
        super.onResume();    //To change body of overridden methods use File | Settings | File Templates.

        Stack<Activity> activities = ((FirstAndroidApplicationController) getApplication()).getCurrentStack();
        if (activities != null) {
            Log.v("trololo", "number of activities : " + activities.size());
            Stack<String> activitiesName = new Stack<String>();
            for (Activity act : activities) {
                activitiesName.push(act.getClass().getName());
            }

          //  if (mAdapter == null)
                mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activitiesName);
            if (mListView != null)
            {
                mListView.setAdapter(mAdapter);
                mListView.invalidate();
            }
        }

        if (mButton1 != null)
            mButton1.setOnClickListener(this);
        if (mButton2 != null)
            mButton2.setOnClickListener(this);
        if (mButton3 != null)
            mButton3.setOnClickListener(this);
        if (mButton4 != null)
            mButton4.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();    //To change body of overridden methods use File | Settings | File Templates.

        if (mButton1 != null)
            mButton1.setOnClickListener(null);
        if (mButton2 != null)
            mButton2.setOnClickListener(null);
        if (mButton3 != null)
            mButton3.setOnClickListener(null);
        if (mButton4 != null)
            mButton4.setOnClickListener(null);
    }

    @Override
    protected void onStop() {
        super.onStop();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();  //To change body of overridden methods use File | Settings | File Templates.
    }

    /**
     * Events *******************************************************************************************************
     */
    @Override
    public void onClick(View view) {
        Intent intent = null;
        final int viewId = view.getId();
        switch (viewId) {
            case R.id.button_1:
                intent = new Intent(MyActivity.this, SingleTopActivity.class);
                break;
            case R.id.button_2:
                intent = new Intent(MyActivity.this, SingleTaskActivity.class);
                break;
            case R.id.button_3:
                intent = new Intent(MyActivity.this, SingleInstanceActivity.class);
                break;
            case R.id.button_4:
                finish();
                break;
            default:
                break;
        }

        if (intent != null)
            startActivity(intent);
    }
}
