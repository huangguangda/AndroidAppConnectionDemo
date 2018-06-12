package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.TodayBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.VideoUrlBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Jack on 2018/5/22.
 */

public interface RetrofitService {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<NewsBean> getNews(@Path("type") String type,
                                 @Path("id") String id,
                                 @Path("startPage") int startPage);

    @GET ("v2/movie/{type}")
    Observable<MovieBean> getMovies(@Path("type") String type);

    @GET("news/feed/v51/")
    Observable<TodayBean> getToday(@Query("category") String category);

    @GET
    Observable<VideoUrlBean> getVideoUrl(@Url String url);
}
