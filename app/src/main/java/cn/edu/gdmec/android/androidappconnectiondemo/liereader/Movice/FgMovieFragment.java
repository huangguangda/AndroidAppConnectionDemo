package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.android.androidappconnectiondemo.R;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.Presenter.MoviesPresenter;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.View.IMoviesView;

public class FgMovieFragment extends Fragment implements IMoviesView {

    private MoviesPresenter moviePresenter;
    private SwipeRefreshLayout srl_movie;
    private RecyclerView rv_movie_on;
    private ItemMovieOnAdapter movieOnAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fg_movie, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviePresenter = new MoviesPresenter(this);
        rv_movie_on = view.findViewById(R.id.rv_movie_on);
        movieOnAdapter = new ItemMovieOnAdapter(getActivity());
        srl_movie = view.findViewById(R.id.srl_movie);
        srl_movie.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        srl_movie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                moviePresenter.loadMovie("in_theaters");
            }
        });
    }

    @Override
    public void showMovie(MovieBean movieBean) {
        movieOnAdapter.setData(movieBean.getSubjects());
        rv_movie_on.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_movie_on.setAdapter(movieOnAdapter);
    }

    @Override
    public void hideDialog() {
        srl_movie.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movie.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(Throwable throwable) {
        Toast.makeText(getContext(),"加载出错：" + throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }
}