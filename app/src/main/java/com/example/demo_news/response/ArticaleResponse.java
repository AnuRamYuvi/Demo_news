package com.example.demo_news.response;

import java.util.List;

import com.example.demo_news.model.Source;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticaleResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private List<Source> sources = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

}