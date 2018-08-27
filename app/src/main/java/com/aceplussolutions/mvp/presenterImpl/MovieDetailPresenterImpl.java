package com.aceplussolutions.mvp.presenterImpl;

import com.aceplussolutions.Data.MovieDetailResponse;
import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.mvp.contract.MovieDetailContract;
import com.aceplussolutions.mvp.contract.PopularMovieListContract;
import com.aceplussolutions.mvp.model.MovieDetailModel;
import com.aceplussolutions.mvp.model.NowPlayingMovieListModel;
import com.aceplussolutions.mvp.model.PopularMovieListModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by phonelin on 8/17/18.
 */

public class MovieDetailPresenterImpl implements MovieDetailContract.MovieDetailPresenter {


    MovieDetailContract.MovieDetailView movieDetailView;
    MovieDetailModel movieDetailModel;
    PublishSubject<MovieDetailResponse> publishSubject;

    public MovieDetailPresenterImpl(MovieDetailContract.MovieDetailView movieDetailView) {
        this.movieDetailView = movieDetailView;
        movieDetailModel = MovieDetailModel.getInstance();
        publishSubject = PublishSubject.create();
    }

    @Override
    public void getMovieDetail(int movieId) {

        movieDetailModel.getMovieDetail(publishSubject,movieId);
        publishSubject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDetailResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDetailResponse movieDetailResponse) {
                        movieDetailView.successMovieDetailLoading();
                        movieDetailView.showMovieMovieDetail(movieDetailResponse);
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
