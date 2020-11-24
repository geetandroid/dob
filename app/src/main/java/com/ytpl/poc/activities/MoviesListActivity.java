package com.ytpl.poc.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ytpl.poc.R;
import com.ytpl.poc.contract.MovieListContract;
import com.ytpl.poc.model.Movie;
import com.ytpl.poc.presenter.MoviePresenter;
import com.ytpl.poc.view.MovieListAdapter;

import java.util.ArrayList;
import java.util.List;

//

public class MoviesListActivity extends AppCompatActivity implements MovieListContract.View {

    private MoviePresenter moviePresenter;
    private RecyclerView rvMovieList;
    private List<Movie> movieList;
    private MovieListAdapter movieListAdapter;
    private ProgressBar pbLoading;
    private int pageNo = 1;

    private LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovieList = findViewById(R.id.rvMovieList);
        pbLoading = findViewById(R.id.pbLoading);

        movieList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        rvMovieList.setLayoutManager(layoutManager);
        rvMovieList.setHasFixedSize(true);

        moviePresenter = new MoviePresenter(this);
        moviePresenter.requestDataFromServer();

    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerview(List<Movie> movieListArray) {

        movieList.addAll(movieListArray);
        movieListAdapter = new MovieListAdapter(movieList, MoviesListActivity.this);
        rvMovieList.setAdapter(movieListAdapter);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

        Log.e("ERROR:", throwable.getMessage());
        Toast.makeText(MoviesListActivity.this, "Error in getting data", Toast.LENGTH_LONG).show();

    }
}
