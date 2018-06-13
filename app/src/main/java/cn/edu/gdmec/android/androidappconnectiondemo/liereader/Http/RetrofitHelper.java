package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http;

import android.content.Intent;

import java.util.concurrent.TimeUnit;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.TodayBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.VideoUrlBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.WeatherBean;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Jack on 2018/5/22.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private RetrofitService retrofitService;

    public RetrofitHelper(String host){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }
    public Observable<NewsBean> getNews(String type, String id, int startPage){
        return retrofitService.getNews(type, id, startPage);
    }
    public OkHttpClient getOkHttpClient(){
        if (okHttpClient==null){
            okHttpClient = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
//String hostType,
    public Observable<MovieBean> getMovies(String type){
        return retrofitService.getMovies(type);
    }
    public Observable<MovieBean> getMovies(String hostType,String type){
        return retrofitService.getMovies(type);
    }

    //6.12
    public Observable<TodayBean> getToday(String category){
        return retrofitService.getToday(category);
    }
    public Observable<VideoUrlBean> getVideoUrl(String api){
        return retrofitService.getVideoUrl(api);
    }
    //
    public Observable<WeatherBean> getWeather(int citykey){
        return  retrofitService.getWeather(citykey);
    }

}
