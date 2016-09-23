package jyq.readerwithmvp.api.retrofit;


import jyq.readerwithmvp.bean.zhihu.NewsBefore;
import jyq.readerwithmvp.bean.zhihu.NewsDetail;
import jyq.readerwithmvp.bean.zhihu.NewsLatest;
import jyq.readerwithmvp.bean.zhihu.SplarshImg;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 作者：EchoJ on 2016/9/23 10:35 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：知乎api
 */
public interface ZhihuApi {
    @GET("start-image/1080*1920")
    Observable<SplarshImg> getSplashImg();

    @GET("news/latest")
    Observable<NewsLatest> getLastestNews();

    @GET("news/before/{time}")
    Observable<NewsBefore> getBeforetNews(@Path("time") String time);

    @GET("news/{id}")
    Observable<NewsDetail> getDetailNews(@Path("id") String id);
}
