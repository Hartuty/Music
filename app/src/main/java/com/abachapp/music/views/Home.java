package com.abachapp.music.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.abachapp.music.R;
import com.abachapp.music.adapters.HomepageAdapter;
import com.abachapp.music.api.MusicApiClient;
import com.abachapp.music.api.MusicInterface;
import com.abachapp.music.model.MusicModel;
import com.abachapp.music.model.Result;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class Home extends Fragment {
    RecyclerView recyclerView;
    TextView textView1,textView2,textView3,textView4;
    String clientid="568e92e8";
    String format="jsonpretty";
    ProgressBar progressBar;
    List<Result> results =new ArrayList<>();
    List<String> uri=new ArrayList<>();
    List<MediaItem> mediaItems=new ArrayList<>();
    List<MediaMetadata> mediaMetadata=new ArrayList<>();
    Button playall;



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
        textView1=getView().findViewById(R.id.playlist1);
        textView2=getView().findViewById(R.id.playlist2);
        textView3=getView().findViewById(R.id.playlist3);
        textView4=getView().findViewById(R.id.playlist4);
        progressBar=getView().findViewById(R.id.progressbar_home);
        playall=getView().findViewById(R.id.playallbtn);
        playall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int x=0;x<uri.size();x++)
                {
                    mediaItems.add(MediaItem.fromUri(uri.get(x)));
                }
                for(int x=0;x<mediaItems.size();x++)
                {
                    ((MainActivity) Objects.requireNonNull(getActivity())).simpleExoPlayer.addMediaItem(mediaItems.get(x));
                }
                ((MainActivity) Objects.requireNonNull(getActivity())).simpleExoPlayer.prepare();
                ((MainActivity)getActivity()).simpleExoPlayer.play();


            }
        });
        init();
        getstore();
    }

    public void init()
    {
        MusicInterface musicInterface= MusicApiClient.getRetrofit().create(MusicInterface.class);
        Call<MusicModel> call=musicInterface.gethomepage(clientid,"40",format);
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<MusicModel>() {
            @Override
            public void onResponse(Call<MusicModel> call, Response<MusicModel> response) {
                progressBar.setVisibility(View.GONE);
                results=response.body().getResults();
                //getting the uris
                for(int x=0;x<results.size();x++)
                {
                    uri.add(results.get(x).getAudio());
                }
                generatedatalist(results);
                //Toast.makeText(getContext(), results.get(0).getAudio(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MusicModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getstore()
    {
        //query firestore
        DocumentReference docRef = ((MainActivity)getActivity()).db.collection("music").document("handpicked");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        textView1.setText(document.get("playlist1").toString());
                        textView2.setText(document.get("playlist2").toString());
                        textView3.setText(document.get("playlist3").toString());
                        textView4.setText(document.get("playlist4").toString());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    private void generatedatalist(List<Result> h)
    {

        //adapter
        HomepageAdapter adapter= new HomepageAdapter(h, getActivity());
        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        playall.setVisibility(View.VISIBLE);
    }
}