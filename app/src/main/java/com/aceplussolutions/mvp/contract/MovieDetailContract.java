package com.aceplussolutions.mvp.contract;

import com.aceplussolutions.Data.MovieDetailResponse;
import com.aceplussolutions.Data.MovieListResponse;

/**
 * Created by phonelin on 8/17/18.
 */

public class MovieDetailContract {

    public interface MovieDetailPresenter{

        void getMovieDetail(int MovieId);

    }

    public interface MovieDetailView{

        void successMovieDetailLoading();

        void showMovieMovieDetail(MovieDetailResponse movieDetailResponse);

    }


}
