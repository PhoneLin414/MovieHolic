package com.aceplussolutions.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.aceplussolutions.Data.MovieDataResult;
import com.aceplussolutions.Data.MovieListResponse;
import com.aceplussolutions.delegate.MovieListDelegate;
import com.aceplussolutions.movieholic.R;
import com.aceplussolutions.viewholders.BaseViewHolder;
import com.aceplussolutions.viewholders.MovieListViewHolder;

/**
 * Created by phonelin on 8/16/18.
 */

public class MovieListAdapter extends BaseRecyclerAdapter<BaseViewHolder, MovieDataResult> {

    MovieListDelegate movieListDelegate;
    Context context;

    public MovieListAdapter(Context context,MovieListDelegate movieListDelegate) {
        super(context);
        this.movieListDelegate = movieListDelegate;
        this.context = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflator.inflate(R.layout.movie_item_view,parent,false);

        return new MovieListViewHolder(context,view,movieListDelegate);
    }
}
