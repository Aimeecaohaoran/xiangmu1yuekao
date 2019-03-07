package com.example.caohaoran0120;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;

import com.example.caohaoran0120.view.CusView;


public class MainActivity extends AppCompatActivity {

    private CusView imageView;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "translationY", 0, 1100f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 600f);
        animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator).with(objectAnimator1);
        animatorSet.setDuration(5000);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
           startActivity(new Intent(MainActivity.this,SanActivity.class));
           finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }

}
