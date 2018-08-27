package com.aceplussolutions.mvp.model;

import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.retrofit.RetrofitServiceFactory;
import com.aceplussolutions.retrofit.Service;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by phonelin on 8/16/18.
 */

public class NowPlayingMovieListModel {


    public static NowPlayingMovieListModel INSTANCE;

    public static NowPlayingMovieListModel getInstance(){


        if (INSTANCE == null){

            INSTANCE = new NowPlayingMovieListModel();

        }

        return INSTANCE;

    }

    public void getNowPlayingMovieList(final PublishSubject<MovieListResponse> publishSubject){


        Service movielistService = RetrofitServiceFactory.createService(Service.class);
        movielistService.getNowPlayingMovieList("4ea44fa5e92d393794cd1d61c2fc2919",1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                            publishSubject.onNext(movieListResponse);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}
