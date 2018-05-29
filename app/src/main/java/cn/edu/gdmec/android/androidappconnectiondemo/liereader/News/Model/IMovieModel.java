package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model;

/**
 * Created by Jack on 2018/5/22.
 */

public interface IMovieModel {
    void loadMovies(String hostType,String type, IOnLoadListener iOnLoadListener);
}
