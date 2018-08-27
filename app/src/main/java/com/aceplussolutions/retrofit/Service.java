package com.aceplussolutions.retrofit;

import com.aceplussolutions.Data.MovieDetailResponse;
import com.aceplussolutions.Data.MovieListResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by phonelin on 8/16/18.
 */

public interface Service {


    @GET("movie/now_playing")
    Observable<MovieListResponse> getNowPlayingMovieList(@Query("api_key") String API_KEY, @Query("page") int PAGE);

    @GET("movie/popular")
    Observable<MovieListResponse> getPopularMovieList(@Query("api_key") String API_KEY, @Query("page") int PAGE);

    @GET("movie/upcoming")
    Observable<MovieListResponse> getUpComingMovieList(@Query("api_key") String API_KEY, @Query("page") int PAGE);


    @GET("movie/{movie_id}")
    Observable<MovieDetailResponse> getMovieDetail(@Path("movie_id") int id, @Query("api_key") String API_KEY);


}
