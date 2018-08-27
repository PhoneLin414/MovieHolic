package com.aceplussolutions.mvp.contract;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.adapters.MovieListAdapter;
import com.aceplussolutions.delegate.MovieListDelegate;
import com.aceplussolutions.movieholic.R;

import butterknife.BindView;

/**
 * Created by phonelin on 8/16/18.
 */

public class UpComingMovieListContract {


    public interface UpComingMovieListPresenter{


        void getUpComingMovieList();


    }

    public interface UpComingMovieListView{


        void successMovieListLoading();

        void showMovieList(MovieListResponse movieListResponse);


    }

}
