package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Video.Model;

import java.util.List;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.TodayContentBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.VideoUrlBean;

/**
 * Created by Jack on 2018/6/12.
 */

public interface IVideoLoadListener {
    void videoUrlSuccess(List<VideoUrlBean> videoUrlBeans,List<TodayContentBean> contentBeans);
    void fail(Throwable throwable);
}
