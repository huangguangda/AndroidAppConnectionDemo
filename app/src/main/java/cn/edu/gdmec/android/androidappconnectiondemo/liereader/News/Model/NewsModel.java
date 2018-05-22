package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model;

import com.sun.org.apache.regexp.internal.RE;

import javax.security.auth.callback.Callback;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Path;

/**
 * Created by Jack on 2018/5/22.
 */

public class NewsModel implements INewsModel{

    @Override
    public void loadNews(final String hostType,final int startPage,final String id,final IOnLoadListener iOnLoadListener) {
        RetrofitHelper.retrofitHelper = new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage).enqueue(new Callback<NewsBean>(){
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response){
                if (response.isSuccessful()){
                    iOnLoadListener.success(response.body());
                }else {
                    iOnLoadListener.fail("");
                }
            }
            @Override
            public void onFailure(Call<NewsBean> call, Throwable t){
                iOnLoadListener.fail(t.toString());
            }
        });
    }
}
