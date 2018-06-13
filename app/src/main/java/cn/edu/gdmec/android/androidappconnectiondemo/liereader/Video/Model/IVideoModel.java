package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Video.Model;

/**
 * Created by Jack on 2018/6/12.
 */

public interface IVideoModel {
    void loadVideo(String category, IVideoLoadListener iVideoLoadListener);
    void loadWeather();
}
