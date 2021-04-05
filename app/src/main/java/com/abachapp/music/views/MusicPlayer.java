package com.abachapp.music.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;

import com.abachapp.music.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.exoplayer2.ui.PlayerView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MusicPlayer extends AppCompatActivity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player2);
        /*intent1 = new Intent(this, MainActivity.class);
        pendingIntent= PendingIntent.getActivity(this,0,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent=getIntent();
        uri=intent.getStringExtra("uri");
        title=intent.getStringExtra("title");
        image=intent.getStringExtra("bitmap");
        artist=intent.getStringExtra("artist");
        playerView=findViewById(R.id.player);


        init();*/
    }


}