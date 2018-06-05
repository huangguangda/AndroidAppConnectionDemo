package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.Presenter;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.Model.IMoviesModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.Model.IOnLoadListener;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.Model.MoviesModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.View.IMoviesView;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.IMovieModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.MovieModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.View.IMovieView;

/**
 * Created by Jack on 2018/6/5.
 */

public class MoviesPresenter implements IMoviesPresenter,IOnLoadListener {

    private IMoviesModel iMoviesModel;
    private IMoviesView iMoviesView;

    public MoviesPresenter(IMoviesView iMoviesView){
        this.iMoviesView = iMoviesView;
        this.iMoviesModel = new MoviesModel();
    }

    @Override
    public void success(MovieBean movieBean) {
        iMoviesView.hideDialog();
        if (movieBean != null){
            iMoviesView.showMovie(movieBean);
        }
    }

    @Override
    public void fail(Throwable throwable) {
        iMoviesView.hideDialog();
        iMoviesView.showErrorMsg(throwable);
    }

    @Override
    public void loadMovie(String type) {
        iMoviesView.showDialog();
        iMoviesModel.loadMovie(type,this);
    }
}
