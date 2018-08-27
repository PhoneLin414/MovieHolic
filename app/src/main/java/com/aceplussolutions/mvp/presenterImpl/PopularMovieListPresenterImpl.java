package com.aceplussolutions.mvp.presenterImpl;

import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.mvp.contract.NowPlayingMovieListContract;
import com.aceplussolutions.mvp.contract.PopularMovieListContract;
import com.aceplussolutions.mvp.model.NowPlayingMovieListModel;
import com.aceplussolutions.mvp.model.PopularMovieListModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by phonelin on 8/16/18.
 */

public class PopularMovieListPresenterImpl implements PopularMovieListContract.PopularMovieListPresenter {

    PopularMovieListContract.PopularMovieListView popularMovieListView;
    PopularMovieListModel popularMovieListModel;
    PublishSubject<MovieListResponse> publishSubject;


    public PopularMovieListPresenterImpl(PopularMovieListContract.PopularMovieListView popularMovieListView) {

        this.popularMovieListView = popularMovieListView;
        popularMovieListModel = PopularMovieListModel.getInstance();
        publishSubject = PublishSubject.create();


    }

    @Override
    public void getPopularMovieList() {

        popularMovieListModel.getPopularMovieList(publishSubject);
        publishSubject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                        popularMovieListView.successMovieListLoading();
                        popularMovieListView.showMovieList(movieListResponse);
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
