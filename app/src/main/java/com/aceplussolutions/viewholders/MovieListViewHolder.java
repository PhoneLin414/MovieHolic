package com.aceplussolutions.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceplussolutions.Data.MovieDataResult;
import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.delegate.MovieListDelegate;
import com.aceplussolutions.movieholic.R;
import com.aceplussolutions.util.Utils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by phonelin on 8/16/18.
 */

public class MovieListViewHolder extends BaseViewHolder<MovieDataResult> {


    @BindView(R.id.movieName)
    TextView txt_movieName;

    @BindView(R.id.releaseDate)
    TextView releaseDate;

    @BindView(R.id.overView)
    TextView overView;

    @BindView(R.id.movieImage)
    ImageView img_movieImage;


    @BindView(R.id.movieRating)
    TextView txt_movieRating;

    Context context;

    int movieId = 0;
    double movieRating = 0;
    String movieName = "";
    String movieImage = "";

    private MovieListDelegate movieListDelegate;

    public MovieListViewHolder(Context context, View itemView, MovieListDelegate movieListDelegate) {
        super(itemView);
        this.movieListDelegate = movieListDelegate;
        this.context = context;
    }

    @Override
    public void setData(MovieDataResult data) {

        movieId = data.getId();

        movieName = data.getOriginalTitle();

        movieImage = data.getPosterPath();

        movieRating = data.getVoteAverage();



        txt_movieName.setText(movieName);

        releaseDate.setText(data.getReleaseDate());

        overView.setText(data.getOverview());

        txt_movieRating.setText(movieRating + "");

        Utils.imageToGlide(data.getPosterPath(), img_movieImage, itemView.getContext());


    }

    @OnClick(R.id.movieItemView)
    void onClickMovieItem(View view) {

        movieListDelegate.onMovieTap(movieId,img_movieImage,txt_movieRating,movieImage,movieName,movieRating);


    }

}
