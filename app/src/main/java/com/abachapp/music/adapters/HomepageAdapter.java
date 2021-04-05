package com.abachapp.music.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abachapp.music.R;
import com.abachapp.music.model.Result;
import com.abachapp.music.views.MainActivity;
import com.abachapp.music.views.MusicPlayer;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomepageAdapter extends RecyclerView.Adapter<HomepageAdapter.CustomViewHolder> {

    private List<Result> datalist;
    private Context context;

    public HomepageAdapter(List<Result> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.one_song,parent,false);
        return new HomepageAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageAdapter.CustomViewHolder holder, int position) {
        holder.textView.setText(datalist.get(position).getName());
        holder.textView3.setText(datalist.get(position).getArtistName());
        Picasso.get().load(datalist.get(position).getAlbumImage()).into(holder.imageView);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof MainActivity){

                    MainActivity activity = (MainActivity)context;
                    activity.play(datalist.get(position).getAudio(),
                            datalist.get(position).getName(),
                            datalist.get(position).getArtistName(),
                            datalist.get(position).getImage());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView textView;
        TextView textView3;
        ImageView imageView;
        MaterialCardView materialCardView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
            textView=mView.findViewById(R.id.homesongtitle);
            textView3=mView.findViewById(R.id.homesongartist);
            imageView=mView.findViewById(R.id.oneimageview);
            materialCardView=mView.findViewById(R.id.materialCardView);


        }
    }


}
