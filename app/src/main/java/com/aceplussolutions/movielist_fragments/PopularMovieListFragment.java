package com.aceplussolutions.movielist_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aceplussolutions.Data.MovieDataResult;
import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.adapters.MovieListAdapter;
import com.aceplussolutions.delegate.MovieListDelegate;
import com.aceplussolutions.movieholic.MovieDetailActivity;
import com.aceplussolutions.movieholic.R;
import com.aceplussolutions.mvp.contract.NowPlayingMovieListContract;
import com.aceplussolutions.mvp.contract.PopularMovieListContract;
import com.aceplussolutions.mvp.presenterImpl.NowPlayingMovieListPresenterImpl;
import com.aceplussolutions.mvp.presenterImpl.PopularMovieListPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularMovieListFragment extends Fragment implements PopularMovieListContract.PopularMovieListView,MovieListDelegate {


    @BindView(R.id.progressbar)
    ProgressBar progressBar;


    @BindView(R.id.recyclerView_PopularMovie)
    RecyclerView recyclerView;

    MovieListAdapter movieListAdapter;

    PopularMovieListContract.PopularMovieListPresenter popularMovieListPresenter;


    public PopularMovieListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_popular_movie_list, container, false);

        ButterKnife.bind(this, view);

        popularMovieListPresenter = new PopularMovieListPresenterImpl(this);


        popularMovieListPresenter.getPopularMovieList();

        return view;
    }

    @Override
    public void successMovieListLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMovieList(MovieListResponse movieListResponse) {

        List<MovieDataResult> movieDataResultList = movieListResponse.getResults();

        if (getActivity() != null) {

            movieListAdapter = new MovieListAdapter(getActivity(), this);
            recyclerView.setAdapter(movieListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            movieListAdapter.setNewData(movieDataResultList);

        }


    }

    @Override
    public void onMovieTap(int id, ImageView img_movieImage, TextView txt_movieRating, String movieImage, String movieName, Double movieRating) {
        Intent i = new Intent(getActivity(),MovieDetailActivity.class);

        i.putExtra("MovieId",id);
        i.putExtra("MovieName",movieName);
        i.putExtra("MovieImage",movieImage);
        i.putExtra("MovieRating",movieRating);

        Pair<ImageView, String> pair1 = Pair.create(img_movieImage,"movieImage");
        Pair<TextView, String> pair2 = Pair.create(txt_movieRating,"movieRating");

        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), new Pair[]{pair1,pair2});

        startActivity(i,activityOptionsCompat.toBundle());
    }
}
