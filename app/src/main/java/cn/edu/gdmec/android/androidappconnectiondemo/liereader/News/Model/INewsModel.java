package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model;

/**
 * Created by Jack on 2018/5/22.
 */

public interface INewsModel {
    void loadNews(String hostType, int startPage, String id, IOnLoadListener iOnLoadListener);
}
