package jyq.readerwithmvp.api.retrofit;

import jyq.readerwithmvp.helper.MyRetrofitHelper;

/**
 * 作者：EchoJ on 2016/9/23 10:39 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
public class ApiFactory {
    static final String BASE_ZHIHU = "http://news-at.zhihu.com/api/4/";
    static final String BASE_GANK = "http://gank.io/api/";
    static final String BASE_DAILY = "http://app3.qdaily.com/app3/";
    
    static ZhihuApi mZhihuApiService = MyRetrofitHelper.getInstance().build(BASE_ZHIHU).create(ZhihuApi.class);

    public static ZhihuApi getZhihuApiService() {
        return mZhihuApiService;
    }
}
