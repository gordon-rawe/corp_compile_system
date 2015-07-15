package com.gordon.nicole.paralax;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by mcluo on 2015/7/14.
 */
public class GSHomeMenu extends RelativeLayout implements View.OnClickListener, View.OnTouchListener {
    /*
    *   <dimen name="menu_right">20dp</dimen>
    *   <dimen name="menu_bottom">20dp</dimen>
    *   <dimen name="menu_main_radius">60dp</dimen>
    *   <dimen name="menu_item_height">60dp</dimen>
    *   <dimen name="menu_item_width">140dp</dimen>
    *   <dimen name="menu_bottom1">90dp</dimen>
    *   <dimen name="menu_bottom2">160dp</dimen>
    *   <dimen name="menu_bottom3">230dp</dimen>
    *   <dimen name="menu_bottom4">300dp</dimen>
    */

    private RelativeLayout rootView;
    private RelativeLayout mainButton;
    private RelativeLayout one, two, three, four;
    private ArrayList<RelativeLayout> views;
    private MenuListener listener;
    private volatile boolean state = true;

    public GSHomeMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        rootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.layout_menu, this);
        findViews();

    }

    private void findViews() {
        mainButton = (RelativeLayout) rootView.findViewById(R.id.main_button);
        one = (RelativeLayout) rootView.findViewById(R.id.one);
        two = (RelativeLayout) rootView.findViewById(R.id.two);
        three = (RelativeLayout) rootView.findViewById(R.id.three);
        four = (RelativeLayout) rootView.findViewById(R.id.four);
        mainButton.setOnClickListener(this);
        views = new ArrayList<>();
        views.add(one);
        views.add(two);
        views.add(three);
        views.add(four);
        for(RelativeLayout l:views){
            l.setOnClickListener(this);
            l.setOnTouchListener(this);
        }
    }

    public GSHomeMenu setMenuListener(MenuListener listener) {
        this.listener = listener;
        return this;
    }

    private void expands() {
        GSAnimationUtil.startRotateAnimation(mainButton, 0);
//        for (int i = 0; i < views.size(); i++) {
//            GSAnimationUtil.playBlinkIn(views.get(i), i, 0.8f, 0.5f);
//        }
    }

    private void shrinks() {
        GSAnimationUtil.startRotateAnimation(mainButton, 10);
//        for (int i = 0; i < views.size(); i++) {
//            GSAnimationUtil.playBlinkOut(views.get(i), 3-i, 0.8f, 0.5f);
//        }
    }

    private void toggle(){
        state = !state;
        if (state) shrinks();
        else expands();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_button:
                toggle();
                break;
            case R.id.one:
                if (listener != null) listener.oneClicked();
                toggle();
                break;
            case R.id.two:
                if (listener != null) listener.twoClicked();
                toggle();
                break;
            case R.id.three:
                if (listener != null) listener.threeClicked();
                toggle();
                break;
            case R.id.four:
                if (listener != null) listener.fourClicked();
                toggle();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.one:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        GSAnimationUtil.playMagicIn(v,0,0.8f,0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        GSAnimationUtil.playMagicOut(v,0,0.8f,0.5f);
                        break;
                }
                break;
            case R.id.two:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        GSAnimationUtil.playMagicIn(v,0,0.8f,0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        GSAnimationUtil.playMagicOut(v,0,0.8f,0.5f);
                        break;
                }
                break;
            case R.id.three:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        GSAnimationUtil.playMagicIn(v,0,0.8f,0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        GSAnimationUtil.playMagicOut(v,0,0.8f,0.5f);
                        break;
                }
                break;
            case R.id.four:
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        GSAnimationUtil.playMagicIn(v,0,0.8f,0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        GSAnimationUtil.playMagicOut(v,0,0.8f,0.5f);
                        break;
                }
                break;
        }

        return false;
    }

    public interface MenuListener {
        void oneClicked();

        void twoClicked();

        void threeClicked();

        void fourClicked();
    }
}
