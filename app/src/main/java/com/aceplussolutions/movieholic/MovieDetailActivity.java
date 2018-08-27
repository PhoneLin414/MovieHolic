package com.aceplussolutions.movieholic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aceplussolutions.Data.MovieDetailResponse;
import com.aceplussolutions.mvp.contract.MovieDetailContract;
import com.aceplussolutions.mvp.presenterImpl.MovieDetailPresenterImpl;
import com.aceplussolutions.mvp.presenterImpl.NowPlayingMovieListPresenterImpl;
import com.aceplussolutions.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailContract.MovieDetailView {


    @BindView(R.id.img_moviedetail_image)
    ImageView img_moviedetail_image;

    @BindView(R.id.txt_moviedetail_name)
    TextView txt_moviedetail_name;

    @BindView(R.id.txt_moviedetail_rating)
    TextView txt_moviedetail_reating;

    @BindView(R.id.txt_moviedetail_originalTitle)
    TextView txt_moviedetail_originalTitle;

    @BindView(R.id.txt_moviedetail_releasedate)
    TextView txt_moviedetail_releasedate;

    @BindView(R.id.txt_moviedetail_revenue)
    TextView txt_moviedetail_revenue;

    @BindView(R.id.txt_moviedetail_voteCount)
    TextView txt_moviedetail_voteCount;

    @BindView(R.id.txt_moviedetail_overView)
    TextView txt_moviedetail_overView;




    MovieDetailContract.MovieDetailPresenter movieDetailPresenter;

    int movieId = 0;
    String movieName = "";
    String movieImage = "";
    Double movieRating = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ButterKnife.bind(this);

        Intent i = getIntent();
        movieId = i.getIntExtra("MovieId", 0);
        movieName = i.getStringExtra("MovieName");
        movieImage = i.getStringExtra("MovieImage");
        movieRating = i.getDoubleExtra("MovieRating", 0.0);


        txt_moviedetail_name.setText(movieName);

        Utils.imageToGlide(movieImage, img_moviedetail_image, this);

        txt_moviedetail_reating.setText(movieRating + "");

        movieDetailPresenter = new MovieDetailPresenterImpl(this);

        movieDetailPresenter.getMovieDetail(movieId);

    }

    @Override
    public void successMovieDetailLoading() {

    }

    @Override
    public void showMovieMovieDetail(MovieDetailResponse movieDetailResponse) {


        txt_moviedetail_originalTitle.setText(movieDetailResponse.getOriginalTitle());
        txt_moviedetail_releasedate.setText(movieDetailResponse.getReleaseDate());
        txt_moviedetail_revenue.setText(movieDetailResponse.getRevenue()+"");
        txt_moviedetail_voteCount.setText(movieDetailResponse.getVoteCount()+"");
        txt_moviedetail_overView.setText(movieDetailResponse.getOverview());


    }
}
