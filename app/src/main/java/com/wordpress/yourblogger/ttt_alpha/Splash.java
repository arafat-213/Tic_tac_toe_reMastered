package com.wordpress.yourblogger.ttt_alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        imageView= (ImageView) findViewById(R.id.imageView);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanim);

        imageView.startAnimation(myanim);


        final Intent intent = new Intent(this,HomeActivity.class);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();

    }
}
