package com.aceplussolutions.mvp.contract;

import com.aceplussolutions.Data.MovieListResponse;

/**
 * Created by phonelin on 8/15/18.
 */

public class NowPlayingMovieListContract {


   public interface NowPlayingMovieListPresenter{


      void getNowPlayingMovieList();


    }

    public interface NowPlayinMovieListView{


       void successMovieListLoading();

       void showMovieList(MovieListResponse movieListResponse);


    }


}
