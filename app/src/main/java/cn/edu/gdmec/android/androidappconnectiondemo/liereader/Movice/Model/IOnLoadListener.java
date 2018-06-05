package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.Model;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;

/**
 * Created by Jack on 2018/6/5.
 */

public interface IOnLoadListener {
    void success(MovieBean movieBean);
    void fail(Throwable throwable);
}
