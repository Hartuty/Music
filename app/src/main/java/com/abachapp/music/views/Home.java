package com.abachapp.music.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abachapp.music.R;
import com.abachapp.music.adapters.HomepageAdapter;
import com.abachapp.music.api.MusicApiClient;
import com.abachapp.music.api.MusicInterface;
import com.abachapp.music.model.MusicModel;
import com.abachapp.music.model.Result;
import com.google.android.exoplayer2.C;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {
    RecyclerView recyclerView;
    String clientid="568e92e8";
    String format="jsonpretty";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=getView().findViewById(R.id.recyclerview);
        init();
    }

    public void init()
    {
        MusicInterface musicInterface= MusicApiClient.getRetrofit().create(MusicInterface.class);
        Call<MusicModel> call=musicInterface.gethomepage(clientid,"60",format,"popularity_total");
        call.enqueue(new Callback<MusicModel>() {
            @Override
            public void onResponse(Call<MusicModel> call, Response<MusicModel> response) {
                generatedatalist(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MusicModel> call, Throwable t) {

            }
        });
    }

    private void generatedatalist(List<Result> h)
    {
        HomepageAdapter adapter= new HomepageAdapter(h, getContext());
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}