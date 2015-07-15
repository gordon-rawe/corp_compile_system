package com.gordon.nicole.paralax;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private RelativeLayout container,title;
    private WatcherScrollView scrollView;
    private float heightBase = 600f;
    private float titleHeight = 140f;
    private TextView centerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (RelativeLayout) findViewById(R.id.container);
        title = (RelativeLayout) findViewById(R.id.title);
        scrollView = (WatcherScrollView) findViewById(R.id.scrollview);
        centerText = (TextView) findViewById(R.id.center);
        final ViewGroup.LayoutParams lp = container.getLayoutParams();
        scrollView.setOnScrollListener(new WatcherScrollView.OnScrollListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldX, int oldY) {
                if(y<=heightBase-titleHeight){
                    float ratio = (heightBase-y)/(heightBase);
                    lp.height = (int)(ratio*heightBase);
                    container.setLayoutParams(lp);
                    centerText.setScaleY(ratio);
                    centerText.setScaleX(ratio);
                    title.setAlpha(1f-ratio);
                }
            }

            @Override
            public void onScrollStopped() {

            }

            @Override
            public void onScrolling() {

            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Toast.makeText(getApplicationContext(), "y->" + title.getHeight(), Toast.LENGTH_LONG).show();
    }
}
