package com.gordon.nicole.paralax;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by mcluo on 2015/7/9.
 */
public class ShakeView extends ImageView {
    private int sequenceIndex = 0;
    private OnClickListener listener;

    public ShakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    public void setShakeViewListener(OnClickListener listener){
        this.listener = listener;
        setOnClickListener(listener);
    }

    public int getSequenceIndex() {
        return sequenceIndex;
    }

    public void setSequenceIndex(int sequenceIndex) {
        this.sequenceIndex = sequenceIndex;
    }

    public void startAnimation() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", 0.9f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", 0.9f);
        ObjectAnimator scaleXx = ObjectAnimator.ofFloat(this, "scaleX", 1f);
        ObjectAnimator scaleYy = ObjectAnimator.ofFloat(this, "scaleY", 1f);
        set.playTogether(scaleX, scaleY);
        set.play(scaleXx).after(scaleX);
        set.play(scaleYy).after(scaleY);
        set.setStartDelay(100*sequenceIndex);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();
    }

    public void startInAnimation() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", 0.9f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", 0.9f);
        set.playTogether(scaleX, scaleY);
        set.setStartDelay(100*sequenceIndex);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();
    }

    public void startOutAnimation() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1f);
        set.playTogether(scaleX, scaleY);
        set.setStartDelay(100*sequenceIndex);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startInAnimation();
                break;
            case MotionEvent.ACTION_UP:
                startOutAnimation();
                break;
        }
        return super.onTouchEvent(event);
    }
}
