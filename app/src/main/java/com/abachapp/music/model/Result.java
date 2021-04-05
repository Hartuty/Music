package com.abachapp.music.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("artist_id")
    @Expose
    private String artistId;
    @SerializedName("artist_name")
    @Expose
    private String artistName;
    @SerializedName("artist_idstr")
    @Expose
    private String artistIdstr;
    @SerializedName("album_name")
    @Expose
    private String albumName;
    @SerializedName("album_id")
    @Expose
    private String albumId;
    @SerializedName("license_ccurl")
    @Expose
    private String licenseCcurl;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("releasedate")
    @Expose
    private String releasedate;
    @SerializedName("album_image")
    @Expose
    private String albumImage;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("audiodownload")
    @Expose
    private String audiodownload;
    @SerializedName("prourl")
    @Expose
    private String prourl;
    @SerializedName("shorturl")
    @Expose
    private String shorturl;
    @SerializedName("shareurl")
    @Expose
    private String shareurl;
    @SerializedName("waveform")
    @Expose
    private String waveform;
    @SerializedName("image")
    @Expose
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistIdstr() {
        return artistIdstr;
    }

    public void setArtistIdstr(String artistIdstr) {
        this.artistIdstr = artistIdstr;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getLicenseCcurl() {
        return licenseCcurl;
    }

    public void setLicenseCcurl(String licenseCcurl) {
        this.licenseCcurl = licenseCcurl;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudiodownload() {
        return audiodownload;
    }

    public void setAudiodownload(String audiodownload) {
        this.audiodownload = audiodownload;
    }

    public String getProurl() {
        return prourl;
    }

    public void setProurl(String prourl) {
        this.prourl = prourl;
    }

    public String getShorturl() {
        return shorturl;
    }

    public void setShorturl(String shorturl) {
        this.shorturl = shorturl;
    }

    public String getShareurl() {
        return shareurl;
    }

    public void setShareurl(String shareurl) {
        this.shareurl = shareurl;
    }

    public String getWaveform() {
        return waveform;
    }

    public void setWaveform(String waveform) {
        this.waveform = waveform;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
