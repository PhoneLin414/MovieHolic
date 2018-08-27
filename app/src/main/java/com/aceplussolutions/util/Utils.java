package com.aceplussolutions.util;

import android.content.Context;
import android.widget.ImageView;

import com.aceplussolutions.movieholic.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by phonelin on 8/16/18.
 */

public class Utils {


    public static void imageToGlide(String url, ImageView imageView, Context context){

        Glide.with(context).load(Constant.IMAGE_URL + url)
                .apply(new RequestOptions().placeholder(R.drawable.loading_film))
                .into(imageView);


    }


}
