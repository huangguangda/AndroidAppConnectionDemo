package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Presenter;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.IMovieModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.IOnLoadListener;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.MovieModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.View.IMovieView;

/**
 * Created by Jack on 2018/5/22.
 */

public class MoviesPresenter implements IMoviePresenter,IOnLoadListener {
    private IMovieModel iMovieModel;
    private IMovieView iMovieView;

    public MoviesPresenter(IMovieView iMovieView){
        this.iMovieView = iMovieView;
        this.iMovieModel = new MovieModel();
    }


    @Override
    public void loadMovies() {
        iMovieView.showDialog();
        iMovieModel.loadMovies("headline", Api.MOVIE_ID,this);
    }

    @Override
    public void success(NewsBean newsBean) {


    }

    @Override
    public void successMov(MovieBean moviesBean) {

        iMovieView.hideDialog();
        if (moviesBean != null){
            iMovieView.showViews(moviesBean);
        }
    }

    @Override
    public void fail(String throwable) {

        iMovieView.hideDialog();
        iMovieView.showErrorMsg(throwable);
    }
}
