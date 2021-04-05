package com.abachapp.music.api;

import com.abachapp.music.model.MusicModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusicInterface {

    @GET("tracks")
    Call<MusicModel> gethomepage(@Query("client_id") String clientid,@Query("limit") String limit,
                                 @Query("format") String format, @Query("boost") String boost);
}
