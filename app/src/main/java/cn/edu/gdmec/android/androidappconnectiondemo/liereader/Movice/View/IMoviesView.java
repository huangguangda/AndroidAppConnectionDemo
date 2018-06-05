package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.View;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;

/**
 * Created by Jack on 2018/6/5.
 */

public interface IMoviesView {
    void showMovie(MovieBean movieBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
