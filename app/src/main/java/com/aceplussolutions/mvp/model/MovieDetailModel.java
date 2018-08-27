package com.aceplussolutions.mvp.model;

import com.aceplussolutions.Data.MovieDetailResponse;
import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.retrofit.RetrofitServiceFactory;
import com.aceplussolutions.retrofit.Service;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by phonelin on 8/17/18.
 */

public class MovieDetailModel {

    public static MovieDetailModel INSTANCE;

    public static MovieDetailModel getInstance(){


        if (INSTANCE == null){

            INSTANCE = new MovieDetailModel();

        }

        return INSTANCE;

    }

    public void getMovieDetail(final PublishSubject<MovieDetailResponse> publishSubject,int movieId){


        Service movieDetailService = RetrofitServiceFactory.createService(Service.class);
        movieDetailService.getMovieDetail(movieId,"4ea44fa5e92d393794cd1d61c2fc2919")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDetailResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDetailResponse movieDetailResponse) {
                        publishSubject.onNext(movieDetailResponse);
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
