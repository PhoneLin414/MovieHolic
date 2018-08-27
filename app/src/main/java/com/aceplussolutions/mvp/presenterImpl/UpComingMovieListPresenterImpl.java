package com.aceplussolutions.mvp.presenterImpl;

import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.mvp.contract.PopularMovieListContract;
import com.aceplussolutions.mvp.contract.UpComingMovieListContract;
import com.aceplussolutions.mvp.model.PopularMovieListModel;
import com.aceplussolutions.mvp.model.UpComingMovieListModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by phonelin on 8/16/18.
 */

public class UpComingMovieListPresenterImpl implements UpComingMovieListContract.UpComingMovieListPresenter {

    UpComingMovieListContract.UpComingMovieListView upComingMovieListView;
    UpComingMovieListModel upComingMovieListModel;
    PublishSubject<MovieListResponse> publishSubject;


    public UpComingMovieListPresenterImpl(UpComingMovieListContract.UpComingMovieListView upComingMovieListView) {

        this.upComingMovieListView = upComingMovieListView;
        upComingMovieListModel = UpComingMovieListModel.getInstance();
        publishSubject = PublishSubject.create();


    }

    @Override
    public void getUpComingMovieList() {

        upComingMovieListModel.getUpComingMovieList(publishSubject);
        publishSubject.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieListResponse movieListResponse) {
                        upComingMovieListView.successMovieListLoading();
                        upComingMovieListView.showMovieList(movieListResponse);
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
