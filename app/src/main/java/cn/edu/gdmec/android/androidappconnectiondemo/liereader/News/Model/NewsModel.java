package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.RetrofitHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static rx.schedulers.Schedulers.io;

public class NewsModel implements INewsModel{
    @Override
    public void loadNews(final String hostType,final int startPage,final String id,final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e.getMessage());
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        iOnLoadListener.success(newsBean);
                    }
                });
    }
}
