package com.aceplussolutions.movieholic;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aceplussolutions.movielist_fragments.NowPlayingMovieListFragment;
import com.aceplussolutions.movielist_fragments.PopularMovieListFragment;
import com.aceplussolutions.movielist_fragments.UpComingMovieListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {


    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        ButterKnife.bind(this);

        loadFragments(new NowPlayingMovieListFragment());


    }

    @OnClick(R.id.btn1)
    void btnNowPlaying(View v) {
        changeBtnBg(1);
        buttonChoose(1);
    }

    @OnClick(R.id.btn2)
    void btnPolular(View v) {
        changeBtnBg(2);
        buttonChoose(2);
    }

    @OnClick(R.id.btn3)
    void btnUpComing(View v) {
        changeBtnBg(3);
        buttonChoose(3);
    }


    private void changeBtnBg(int btn_No) {


        switch (btn_No) {

            case 1:
                btn1.setBackground(getResources().getDrawable(R.drawable.homepage_button_sel_bg));
                btn2.setBackground(getResources().getDrawable(R.drawable.homepage_button_unsel_bg));
                btn3.setBackground(getResources().getDrawable(R.drawable.homepage_button_unsel_bg));
                break;

            case 2:
                btn2.setBackground(getResources().getDrawable(R.drawable.homepage_button_sel_bg));
                btn1.setBackground(getResources().getDrawable(R.drawable.homepage_button_unsel_bg));
                btn3.setBackground(getResources().getDrawable(R.drawable.homepage_button_unsel_bg));
                break;

            case 3:
                btn3.setBackground(getResources().getDrawable(R.drawable.homepage_button_sel_bg));
                btn1.setBackground(getResources().getDrawable(R.drawable.homepage_button_unsel_bg));
                btn2.setBackground(getResources().getDrawable(R.drawable.homepage_button_unsel_bg));
                break;

        }


    }

    private boolean buttonChoose(int id) {


        Fragment fragment = null;

        switch (id) {
            case 1:
                fragment = new NowPlayingMovieListFragment();
                break;
            case 2:
                fragment = new PopularMovieListFragment();
                break;
            case 3:
                fragment = new UpComingMovieListFragment();
                break;
        }
        return loadFragments(fragment);


    }

    private boolean loadFragments(Fragment fragment) {

        if (fragment != null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();

            return true;
        }


        return false;
    }


}
