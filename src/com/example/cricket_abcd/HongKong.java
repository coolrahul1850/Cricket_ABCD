package com.example.cricket_abcd;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HongKong extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hong_kong);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hong_kong, menu);
        return true;
    }
}
