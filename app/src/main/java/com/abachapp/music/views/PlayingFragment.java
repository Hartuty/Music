package com.abachapp.music.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abachapp.music.R;
import com.google.android.exoplayer2.ui.PlayerView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


public class PlayingFragment extends Fragment {

    PlayerView playerView;
    ImageView imageView;
    TextView song,artist;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        playerView=getView().findViewById(R.id.playerview);
        imageView=getView().findViewById(R.id.image_artist);
        song=getView().findViewById(R.id.songname);
        artist=getView().findViewById(R.id.artistname);
        song.setText(((MainActivity)getActivity()).title);
        artist.setText(((MainActivity)getActivity()).artist);
        Picasso.get().load(((MainActivity)getActivity()).image).into(imageView);
        playerView.setPlayer(((MainActivity)getActivity()).simpleExoPlayer);
        playerView.showController();
        playerView.setUseArtwork(false);
        playerView.setControllerHideOnTouch(false);
        playerView.setControllerShowTimeoutMs(0);
    }
}