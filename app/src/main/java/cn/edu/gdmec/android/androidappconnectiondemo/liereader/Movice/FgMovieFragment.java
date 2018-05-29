package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import cn.edu.gdmec.android.androidappconnectiondemo.R;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Presenter.MoviesPresenter;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.View.IMovieView;


public class FgMovieFragment extends Fragment implements IMovieView {
    private TextView tv_movies;
    private SwipeRefreshLayout srl_movies;
    private MoviesPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_movies = (TextView)view.findViewById(R.id.tv_movies);
        srl_movies = view.findViewById(R.id.srl_movies);
        srl_movies.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        presenter = new MoviesPresenter(this);
        srl_movies.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadMovies();
            }
        });

    }

    @Override
    public void showViews(MovieBean moviesBean) {
        tv_movies.setText(moviesBean.getSubjects().get(0).getTitle()+""+moviesBean.getSubjects().get(0).getDirectors());
    }

    @Override
    public void hideDialog() {
        srl_movies.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movies.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(String error) {
        tv_movies.setText("加载错误");
    }
}
