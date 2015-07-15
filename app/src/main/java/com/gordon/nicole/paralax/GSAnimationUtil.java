package com.gordon.nicole.paralax;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by mcluo on 2015/6/2.
 */
public class GSAnimationUtil {
    public static Animation getUpAnimation(int height){
        Animation animation = new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,0,Animation.ABSOLUTE,height,Animation.ABSOLUTE,0);
        animation.setDuration(800);
//        animation.setFillAfter(true);
        return animation;
    }

    public static Animation getDownAnimation(int height){
        Animation animation = new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,0,Animation.ABSOLUTE,0,Animation.ABSOLUTE,height);
        animation.setDuration(800);
//        animation.setFillAfter(true);
        return animation;
    }

    public static void playBlinkIn(final View v,int i,float pivotX,float pivotY){
        v.setPivotX(pivotX*v.getWidth());
        v.setPivotY(pivotY*v.getHeight());
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v,"scaleX",1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v,"scaleY",1f);
        AnimatorSet set = new AnimatorSet();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.playTogether(scaleX,scaleY);
        set.setDuration(500);
        set.setStartDelay(100*i);
        set.start();
    }

    public static void playBlinkOut(final View v,int i,float pivotX,float pivotY){
        v.setPivotX(pivotX*v.getWidth());
        v.setPivotY(pivotY*v.getHeight());
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v,"scaleX",0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v,"scaleY",0f);
        AnimatorSet set = new AnimatorSet();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                v.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.playTogether(scaleX,scaleY);
        set.setDuration(300);
        set.setStartDelay(40*i);
        set.start();
    }
    public static void playMagicIn(View v,int i,float pivotX,float pivotY){
        v.setPivotX(pivotX*v.getWidth());
        v.setPivotY(pivotY*v.getHeight());
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v,"scaleX",0.8f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v,"scaleY",0.8f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX,scaleY);
        set.setDuration(500);
        set.setStartDelay(100*i);
        set.start();
    }

    public static void playMagicOut(View v,int i,float pivotX,float pivotY){
        v.setPivotX(pivotX*v.getWidth());
        v.setPivotY(pivotY*v.getHeight());
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v,"scaleX",1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v,"scaleY",1f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(scaleX,scaleY);
        set.setDuration(500);
        set.setStartDelay(100*i);
        set.start();
    }

    public static void startRotateAnimation(View v,int direction){
        Animation animation;
        if(direction==0) animation = new RotateAnimation(0,135,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        else animation = new RotateAnimation(135,0,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        animation.setDuration(500);
        animation.setFillAfter(true);
        v.startAnimation(animation);
    }
}
