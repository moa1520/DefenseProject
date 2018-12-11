package com.example.taekyoungkang.defenseproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimActivity extends AppCompatActivity {

    ImageView mrun;
    ImageView mrocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        mrun = (ImageView) findViewById(R.id.run);
        mrocket = (ImageView) findViewById(R.id.rocket);

    }

    @Override
    protected void onResume(){
        super.onResume();

        startRunFrameAnimation();
        startRocetdTweenAnimation();
    }

    private void startRunFrameAnimation(){
        mrun.setBackgroundResource(R.drawable.anim);
        AnimationDrawable runAnim = (AnimationDrawable) mrun.getBackground();
        runAnim.start();
    }

    private void startRocetdTweenAnimation(){
        Animation rockedtd_anim = AnimationUtils.loadAnimation(this,R.anim.rocket);
        mrocket.startAnimation(rockedtd_anim);
        rockedtd_anim.setAnimationListener(animationListener);
    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };



}
