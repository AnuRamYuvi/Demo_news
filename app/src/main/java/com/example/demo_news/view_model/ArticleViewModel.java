package com.example.demo_news.view_model;

import static com.example.demo_news.constants.AppConstant.API_KEY;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.demo_news.repository.ArticleRepository;
import com.example.demo_news.response.ArticaleResponse;


public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticaleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles(API_KEY);
    }

    public LiveData<ArticaleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
}