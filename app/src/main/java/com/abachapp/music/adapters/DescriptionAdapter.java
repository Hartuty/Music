package com.abachapp.music.adapters;

import android.app.PendingIntent;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;


public class DescriptionAdapter implements PlayerNotificationManager.MediaDescriptionAdapter {

    @Override
    public CharSequence getCurrentContentTitle(Player player) {
        return null;
    }

    @Nullable
    @Override
    public PendingIntent createCurrentContentIntent(Player player) {
        return null;
    }

    @Nullable
    @Override
    public CharSequence getCurrentContentText(Player player) {
        return getCurrentContentText(player);
    }

    @Nullable
    @Override
    public CharSequence getCurrentSubText(Player player) {
        return null;
    }

    @Nullable
    @Override
    public Bitmap getCurrentLargeIcon(Player player, PlayerNotificationManager.BitmapCallback callback) {
        return getCurrentLargeIcon(player,callback);
    }
}
