package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;

/**
 * Created by Jack on 2018/5/22.
 */

public interface IOnLoadListener {
    void success(NewsBean newsBean);
    void fail(String error);
}
