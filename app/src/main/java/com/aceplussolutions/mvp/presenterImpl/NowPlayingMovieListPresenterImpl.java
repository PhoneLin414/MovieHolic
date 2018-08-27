package com.aceplussolutions.mvp.presenterImpl;

import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.delegate.MovieListDelegate;
import com.aceplussolutions.mvp.contract.NowPlayingMovieListContract;
import com.aceplussolutions.mvp.model.NowPlayingMovieListModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by phonelin on 8/15/18.
 */

public class NowPlayingMovieListPresenterImpl implements NowPlayingMovieListContract.NowPlayingMovieListPresenter {

    NowPlayingMovieListContract.NowPlayinMovieListView nowPlayinMovieListView;
    NowPlayingMovieListModel nowPlayingMovieListModel;
    PublishSubject<MovieListResponse> publishSubject;


    public NowPlayingMovieListPresenterImpl(NowPlayingMovieListContract.NowPlayinMovieListView nowPlayinMovieListView) {

        this.nowPlayinMovieListView = nowPlayinMovieListView;
        nowPlayingMovieListModel = NowPlayingMovieListModel.getInstance();
        publishSubject = PublishSubject.create();


    }

    @Override
    public void getNowPlayingMovieList() {


        nowPlayingMovieListModel.getNowPlayingMovieList(publishSubject);
        publishSubject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                        nowPlayinMovieListView.successMovieListLoading();
                        nowPlayinMovieListView.showMovieList(movieListResponse);
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
