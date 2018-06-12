package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Video.View;

import java.util.List;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.TodayContentBean;

/**
 * Created by Jack on 2018/6/12.
 */

public interface IVideoView {
    void showVideo(List<TodayContentBean> todayContentBeans, List<String> videoList);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
