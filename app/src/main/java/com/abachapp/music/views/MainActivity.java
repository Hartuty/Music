package com.abachapp.music.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.abachapp.music.R;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment homefrag,playingfrag;
    SimpleExoPlayer simpleExoPlayer;
    String uri;
    String title;
    String artist;
    String image;
    Bitmap bitmap1;
    Intent intent1;
    PendingIntent pendingIntent;
    private PlayerNotificationManager playerNotificationManager;
    private int notificationId = 1234;
    FirebaseFirestore db ;

    private PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter = new PlayerNotificationManager.MediaDescriptionAdapter() {
        @Override
        public String getCurrentSubText(Player player) {
            return "Now Playing";
        }

        @Override
        public String getCurrentContentTitle(Player player) {
            return title;
        }

        @Override
        public PendingIntent createCurrentContentIntent(Player player) {
            return pendingIntent;
        }

        @Override
        public String getCurrentContentText(Player player) {
            return artist;
        }

        @Override
        public Bitmap getCurrentLargeIcon(Player player, PlayerNotificationManager.BitmapCallback callback) {
            return bitmap1;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= FirebaseFirestore.getInstance();
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();
        homefrag=new Home();
        playingfrag=new PlayingFragment();
        loadFragment(homefrag);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.page_1)
                {
                    loadFragment(homefrag);
                    item.setChecked(true);
                }
                if(item.getItemId()==R.id.page_2)
                {
                    loadFragment(playingfrag);
                    item.setChecked(true);
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout, fragment);
        transaction.commit();
    }

    public void play(String uri,String title, String artist, String image)
    {
        this.uri=uri;
        this.title=title;
        this.artist=artist;
        this.image=image;
        getbit();
        MediaItem mediaItem = MediaItem.fromUri(uri);
        playerNotificationManager = PlayerNotificationManager.createWithNotificationChannel(this,
                "My_channel_id",
                R.string.channel_name,
                notificationId, mediaDescriptionAdapter,
                new PlayerNotificationManager.NotificationListener() {
                    @Override
                    public void onNotificationPosted(int notificationId, Notification notification, boolean ongoing) {
                    }

                    @Override
                    public void onNotificationCancelled(int notificationId, boolean dismissedByUser) {
                    }
                });
        playerNotificationManager.setUseChronometer(true);
        playerNotificationManager.setPlayer(simpleExoPlayer);
        simpleExoPlayer.setMediaItem(mediaItem);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();
    }

    private void getbit()
    {
        Picasso.get().load(image).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                bitmap1=bitmap;
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        try {
            playerNotificationManager.setPlayer(null);
            simpleExoPlayer.release();
        } catch (Exception ex)
        {

        }
        super.onDestroy();

    }

}