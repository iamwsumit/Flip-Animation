package com.Sumit1334.FlipAnimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = 1,  description = "This extension helps you to do the flip animation with any android view component by Sumit Kumar",category = ComponentCategory.EXTENSION,
        nonVisible = true,   iconName = "https://community.kodular.io/user_avatar/community.kodular.io/sumit1334/120/82654_2.png")
@SimpleObject(external = true)

public class FlipAnimation extends AndroidNonvisibleComponent implements Component {
    public FlipAnimation(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleEvent(description = "This event raises when animation completed")
    public void AnimationEnd(AndroidViewComponent component,long duration){
        EventDispatcher.dispatchEvent(this,"AnimationEnd",component,duration);
    }
    @SimpleEvent(description = "This event raises when Animation started")
    public void AnimationStart(AndroidViewComponent component,long duration){
        EventDispatcher.dispatchEvent(this,"AnimationStart",component,duration);
    }
    @SimpleProperty(description = "Return the left to right direction")
    public int Left(){
        return 2;
    }
    @SimpleProperty(description = "Return the up to down direction")
    public int Up(){
        return 1;
    }
    @SimpleProperty(description = "Return the Down to up direction")
    public int Down(){
        return 0;
    }
    @SimpleProperty(description = "Return the right to left direction")
    public int Right(){
        return 3;
    }
    @SimpleFunction(description = "Do the animation")
    public void Flip(final AndroidViewComponent component,final long duration,int direction){
        component.getView().setRotationY(0);
        component.getView().setRotationX(0);
        if (direction==2) {
            component.getView().animate().rotationY(-180).setDuration(duration).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    AnimationStart(component,duration);
                }
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    AnimationEnd(component,duration);
                    component.getView().setRotationY(0);
                }
            });
        }
        else if (direction==3) {
            component.getView().animate().rotationY(180).setDuration(duration).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);

                    AnimationStart(component,duration);

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    AnimationEnd(component,duration);
                    component.getView().setRotationY(0);
                }
            });
        }
        else if (direction==0){
            component.getView().animate().rotationX(-180).setDuration(duration).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    AnimationStart(component,duration);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    AnimationEnd(component, duration);
                    component.getView().setRotationX(0);
                }
            });
        }else if (direction==1){
            component.getView().animate().rotationX(180).setDuration(duration).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    AnimationStart(component,duration);
                }
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    AnimationEnd(component,duration);
                    component.getView().setRotationX(0);
                }
            });
        }


    }
}