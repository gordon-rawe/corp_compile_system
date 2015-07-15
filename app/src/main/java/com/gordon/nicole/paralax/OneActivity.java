package com.gordon.nicole.paralax;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by mcluo on 2015/7/9.
 */
public class OneActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        ((GSHomeMenu)findViewById(R.id.menu)).setMenuListener(new GSHomeMenu.MenuListener() {
            @Override
            public void oneClicked() {
                Toast.makeText(getApplicationContext(),"one",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void twoClicked() {
                Toast.makeText(getApplicationContext(),"two",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void threeClicked() {
                Toast.makeText(getApplicationContext(),"three",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void fourClicked() {
                Toast.makeText(getApplicationContext(),"four",Toast.LENGTH_SHORT).show();
            }
        });
    }
}