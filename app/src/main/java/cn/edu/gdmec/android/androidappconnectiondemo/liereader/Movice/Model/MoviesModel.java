package cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.Model;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.RetrofitHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoviesModel implements IMoviesModel {

    @Override
    public void loadMovie(final String type, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.MOVIES_HOST);
        retrofitHelper.getMovies(type)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MovieBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        iOnLoadListener.success(movieBean);
                    }
                });
    }
}