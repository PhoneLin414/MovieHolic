package com.aceplussolutions.mvp.contract;

import com.aceplussolutions.Data.MovieListResponse;

/**
 * Created by phonelin on 8/16/18.
 */

public class PopularMovieListContract {

    public interface PopularMovieListPresenter{


        void getPopularMovieList();


    }

    public interface PopularMovieListView{


        void successMovieListLoading();

        void showMovieList(MovieListResponse movieListResponse);


    }

}
