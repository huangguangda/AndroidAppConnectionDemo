package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.MovieBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.RetrofitHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MovieModel implements IMovieModel {
    @Override
    //final String hostType,
    public void loadMovies(final String hostType,final String type, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper = new RetrofitHelper(Api.MOVIES_HOST);
        retrofitHelper.getMovies(hostType,type)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MovieBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        iOnLoadListener.successMov(movieBean);
                    }
                });
    }
}
