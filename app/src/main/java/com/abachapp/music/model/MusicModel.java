package com.abachapp.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MusicModel {
    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
