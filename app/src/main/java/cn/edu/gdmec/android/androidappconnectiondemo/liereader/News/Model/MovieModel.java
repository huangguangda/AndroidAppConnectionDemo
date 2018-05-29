package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jack on 2018/5/22.
 */

public class MovieModel implements IMovieModel {
    @Override
    public void loadMovies(final String hostType,final String type, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.MOVIES_HOST);
        retrofitHelper.getMovies(type).enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                if (response.isSuccessful()){
                    iOnLoadListener.successMov(response.body());
                }else {
                    iOnLoadListener.fail("");
                }
            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {

                iOnLoadListener.fail(t.toString());
            }
        });
    }
}
