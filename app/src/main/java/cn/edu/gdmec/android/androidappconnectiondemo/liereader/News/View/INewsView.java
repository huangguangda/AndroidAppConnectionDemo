package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.View;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;

/**
 * Created by Jack on 2018/5/22.
 */

public interface INewsView {
    void showNews(NewsBean newsBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
