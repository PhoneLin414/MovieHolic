package com.aceplussolutions.delegate;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by phonelin on 8/16/18.
 */

public interface MovieListDelegate {

    void onMovieTap(int id, ImageView img_movieImage,TextView txt_movieRating,String movieImage,String movieName,Double movieRating);

}
