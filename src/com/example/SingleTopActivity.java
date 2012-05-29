package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kiki
 * Date: 28/05/12
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public class SingleTopActivity extends Activity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singletopactivity);

        ((FirstAndroidApplicationController) getApplication()).pushToStack(this);
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
        super.onResume();
//        MyActivity.sItems.push(this.getComponentName().getShortClassName());
//        ListView mListView = (ListView) findViewById(R.id.list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MyActivity.sItems);
//        mListView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onDestroy() {

       // ((FirstAndroidApplicationController) getApplication()).removeFromStack(this);

        super.onDestroy();    //To change body of overridden methods use File | Settings | File Templates.

    }

}