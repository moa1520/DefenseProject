package com.example.taekyoungkang.defenseproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class AnimActivity extends AppCompatActivity {

    ImageView mrun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        mrun = (ImageView) findViewById(R.id.run);
    }

    @Override
    protected void onResume(){
        super.onResume();

        startRunFrameAnimation();
    }

    private void startRunFrameAnimation(){
        mrun.setBackgroundResource(R.drawable.anim);
        AnimationDrawable runAnim = (AnimationDrawable) mrun.getBackground();
        runAnim.start();

    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            finish();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };



}
