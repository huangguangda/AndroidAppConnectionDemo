package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.View;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;

/**
 * Created by Jack on 2018/5/22.
 */

public interface IMovieView {
    void showViews(MovieBean moviesBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
