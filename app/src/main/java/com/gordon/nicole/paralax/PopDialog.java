package com.gordon.nicole.paralax;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by mcluo on 2015/7/14.
 */
public class PopDialog extends Dialog {
    private Context context;
    private GSDeviceUtil deviceUtil;
    private int right, bottom;
    private MenuListenr listenr;

    private RelativeLayout one,two,three,four;

    public PopDialog(Context context) {
        super(context);
        this.context = context;
        deviceUtil = new GSDeviceUtil(context);
        right = (int) deviceUtil.dip2pix(60);
        bottom = (int) deviceUtil.dip2pix(60);
    }

    public PopDialog setPosition(int right, int bottom) {//right 为靠右的距离，bottom为距底部的距离
        this.right = right;
        this.bottom = bottom;
        return this;
    }

    public void setRight(float right) {
        this.right = (int) right;
    }

    public void setBottom(float bottom) {
        this.bottom = (int) bottom;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_dialog);
        getWindow().setWindowAnimations(R.style.PopupAnimation);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setGravity(Gravity.RIGHT | Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        one = (RelativeLayout)findViewById(R.id.one);
        two = (RelativeLayout)findViewById(R.id.two);
        three = (RelativeLayout)findViewById(R.id.three);
        four = (RelativeLayout)findViewById(R.id.four);
        startInAnimation(one,3);
        startInAnimation(two,2);
        startInAnimation(three,1);
        startInAnimation(four,0);
        startRotateAnimation(findViewById(R.id.five),0);
        findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listenr!=null) listenr.onRotate();
                dismiss();
            }
        });
    }



    public PopDialog setMenuListener(MenuListenr l){
        this.listenr = l;

        return this;
    }

    public static void startRotateAnimation(View v,int direction){
        Animation animation;
        if(direction==0) animation = new RotateAnimation(0,135,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        else animation = new RotateAnimation(135,0,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        v.startAnimation(animation);
    }

    public void startInAnimation(View v,int i) {
        Animation animation = new ScaleAnimation(0,1f,0,1f,Animation.RELATIVE_TO_SELF,0.75f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setFillAfter(true);
        animation.setStartOffset(100 * i);
        animation.setDuration(400);
        v.startAnimation(animation);
    }

    public interface MenuListenr{
        void onRotate();
    }
}
