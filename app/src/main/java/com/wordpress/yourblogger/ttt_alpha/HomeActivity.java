package com.wordpress.yourblogger.ttt_alpha;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.wordpress.yourblogger.ttt_alpha.R.*;

public class HomeActivity extends AppCompatActivity {
    Button button_rules,button_exit;
    Button button_newGame;
    Button buttonMute;
    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        mediaPlayer = MediaPlayer.create(HomeActivity.this, raw.song);

       /* if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }*/

        final Intent intent = new Intent(this, MainActivity.class);
        button_newGame = (Button) findViewById(id.button_newGame);
        button_newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });

        buttonMute = (Button) findViewById(id.button_Mute);
        buttonMute.setBackgroundResource(R.drawable.button_unmute);
        buttonMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                    buttonMute.setBackgroundResource(R.drawable.button_unmute);
                }
                else{
                    mediaPlayer.pause();
                    buttonMute.setBackgroundResource(R.drawable.button_mute);
                }
            }
        });
        button_rules = (Button) findViewById(id.button_info);
        button_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setMessage("Look at this dialog!")
                        .setTitle("This is a title")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        button_exit = (Button) findViewById(id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                HomeActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

    }



   @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        HomeActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    protected void onStart() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
        super.onStart();
    }
/*
    @Override
    protected void onStop() {
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        super.onStop();
    }

    /* @Override
    protected void onDestroy() {
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        super.onDestroy();
    }*/
}
