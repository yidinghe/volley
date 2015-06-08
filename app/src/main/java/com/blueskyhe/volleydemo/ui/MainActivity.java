package com.blueskyhe.volleydemo.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.blueskyhe.volleydemo.R;
import com.blueskyhe.volleydemo.util.VolleyUtil;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button mBtnStringRequest;

    private VolleyUtil mVolleyUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initVolley();
    }

    private void initVolley() {
        mVolleyUtil = new VolleyUtil(this);
    }


    private void initViews() {
        mBtnStringRequest = (Button) findViewById(R.id.btn_string_request);
        mBtnStringRequest.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnStringRequest) {
            onStringRequestClicked();
        }
    }

    private void onStringRequestClicked() {
        mVolleyUtil.volleyStringRequest("http://www.baidu.com");
    }
}
