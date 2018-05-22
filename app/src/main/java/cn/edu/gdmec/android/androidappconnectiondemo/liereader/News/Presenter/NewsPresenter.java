package cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Presenter;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.NewsBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.FgNewsFragment;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.INewsModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.IOnLoadListener;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.Model.NewsModel;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.View.INewsView;

/**
 * Created by Jack on 2018/5/22.
 */

public class NewsPresenter implements INewsPresenter, IOnLoadListener{
    private INewsModel iNewsModel;
    private INewsView iNewsView;

    public NewsPresenter(INewsView iNewsView){
        this.iNewsView = iNewsView;
        this.iNewsModel = new NewsModel();
    }

    @Override
    public void loadNews(int type, int startPage) {
        iNewsView.showDialog();
        switch (type){
            case FgNewsFragment.NEWS_TYPE_TOP:
                iNewsModel.loadNews("headline",startPage, Api.HEADLINE_ID,
                        this);
                case FgNewsFragment.NEWS_TYPE_NBA:
                    iNewsModel.loadNews("list",startPage,Api.NBA_ID,
                            this);
                    case FgNewsFragment.NEWS_TYPE_JOKES:
                        iNewsModel.loadNews("list");
        }
    }

    @Override
    public void success(NewsBean newsBean) {
        iNewsView.hideDialog();
        if (newsBean!=null){
            iNewsView.showNews(newsBean);
        }
    }

    @Override
    public void fail(String error) {
        iNewsView.hideDialog();
        iNewsView.showErrorMsg(error);
    }
}
