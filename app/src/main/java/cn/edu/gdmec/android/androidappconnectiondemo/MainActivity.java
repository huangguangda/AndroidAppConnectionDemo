package cn.edu.gdmec.android.androidappconnectiondemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Bean.WeatherBean;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.Api;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Http.RetrofitHelper;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Movice.FgMovieFragment;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.News.FgNewsFragment;
import cn.edu.gdmec.android.androidappconnectiondemo.liereader.Video.FgVideoFragment;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        ViewPager.OnPageChangeListener{
    Integer[] city={101280101,101280102,101280103,101280104,101280105, 101280201,101280202,101280203,101280204,101280205,101280206, 101280207,101280208,101280501};
    private View view_status;
    private ImageView iv_title_news;
    private ImageView iv_title_movie;
    private ImageView iv_title_video;
    private ViewPager vp_content;
    private Toolbar toolbars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.parseColor("#ffce3d3a"));
        }
        initView();
        initContentFragment();
        final RetrofitHelper retrofitHelper = new RetrofitHelper(Api.WEATHER_HOST);
        Observable.from(city)
                .flatMap(new Func1<Integer, Observable<WeatherBean>>() {
                    @Override
                    public Observable<WeatherBean> call(Integer integer) {
                        return retrofitHelper.getWeather(integer);
                    }
                })

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WeatherBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                       Log.i("oooooon:",e.getMessage());
                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        Log.i("onNext:",weatherBean.getData().getCity()+":"+weatherBean.getData().getGanmao());
                    }
                });
    }

    private void initContentFragment() {
        ArrayList<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new FgNewsFragment());
        mFragmentList.add(new FgMovieFragment());
        mFragmentList.add(new FgVideoFragment());

        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(),
                mFragmentList);
        vp_content.setAdapter(adapter);
        vp_content.setOffscreenPageLimit(2);
        vp_content.addOnPageChangeListener(this);

        setSupportActionBar(toolbars);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
        setCurrentItem(0);
    }


    /*private void setSupportActionBar(Toolbar toolbars) {
    }*/

    private void initView() {
        view_status = (View) findViewById(R.id.view_status);
        iv_title_news = findViewById(R.id.iv_title_news);
        iv_title_movie = findViewById(R.id.iv_title_movie);
        iv_title_video = findViewById(R.id.iv_title_video);
        vp_content = findViewById(R.id.vp_content);
        toolbars = (Toolbar) findViewById(R.id.toolbars);

        iv_title_news.setOnClickListener(this);
        iv_title_movie.setOnClickListener(this);
        iv_title_video.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_title_news:
                if (vp_content.getCurrentItem() != 0){
                    setCurrentItem(0);
                }
                break;
            case R.id.iv_title_movie:
                if (vp_content.getCurrentItem() != 1){
                    setCurrentItem(1);
                }
                break;
            case R.id.iv_title_video:
                if (vp_content.getCurrentItem() != 2){
                    setCurrentItem(2);
                }
                break;
        }
    }

    private void setCurrentItem(int i) {
        vp_content.setCurrentItem(i);
        iv_title_movie.setSelected(false);
        iv_title_video.setSelected(false);
        iv_title_news.setSelected(false);
        switch (i){
            case 0:
                iv_title_news.setSelected(true);
                break;
            case 1:
                iv_title_movie.setSelected(true);
                break;
            case 2:
                iv_title_video.setSelected(true);
                break;
        }
    }
}
