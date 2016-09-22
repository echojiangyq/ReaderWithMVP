package jyq.readerwithmvp.helper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jyq.readerwithmvp.mApp;
import jyq.readerwithmvp.util.BuildTypeUtil;
import jyq.readerwithmvp.util.NetUtils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：EchoJ on 2016/9/22 19:41 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：Retrofit 封装类
 */
public class MyRetrofitHelper {

    static volatile MyRetrofitHelper instance;
     MyRetrofitHelper() {
         
    }

    public static final MyRetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (MyRetrofitHelper.class) {
                if (instance == null) {
                    instance = new MyRetrofitHelper();
                }
            }
        }
        return instance;
    }
    
    public Retrofit build(String baseUrl){
        final Retrofit build = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(buildOKHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return build;
    }
    
    
    /**
     * 构建OkHttpClient
     * @return OkHttpClient
     */
     OkHttpClient buildOKHttpClient(){
        // 添加日志拦截器，非debug模式不打印任何日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildTypeUtil.isApkDebugable(mApp.mContext) ? HttpLoggingInterceptor.Level.HEADERS : HttpLoggingInterceptor.Level.NONE) ;

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)                       // 添加日志拦截器
                .addNetworkInterceptor(buildCacheInterceptor())           // 添加网络缓存拦截器
                .cache(getCache())                                        // 设置缓存文件
                .retryOnConnectionFailure(true)                           // 自动重连
                .connectTimeout(15, TimeUnit.SECONDS)                     // 15秒连接超时
                .readTimeout(20, TimeUnit.SECONDS)                        // 20秒读取超时
                .writeTimeout(20, TimeUnit.SECONDS)                       // 20秒写入超时
                .build();
    }

    /**
     * 获取缓存对象
     * @return Cache
     */
     Cache getCache(){
        // 获取缓存目标,SD卡
        File cacheFile = new File(mApp.mContext.getCacheDir(), "cache");
        // 创建缓存对象,最大缓存50m
        return new Cache(cacheFile, 1024*1024*20);
    }

    /**
     * 构建缓存拦截器
     * @return Interceptor
     */
     Interceptor buildCacheInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                // 无网络连接时请求从缓存中读取
                if (!NetUtils.isNetworkAvailable(mApp.mContext)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }

                // 响应内容处理
                // 在线时缓存5分钟
                // 离线时缓存4周
                Response response = chain.proceed(request);
                if (NetUtils.isNetworkAvailable(mApp.mContext)) {
                    int maxAge = 300;
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                }else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
    }

   
}
