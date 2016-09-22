package jyq.readerwithmvp;

import android.app.Application;
import android.content.Context;

/**
 * 作者：EchoJ on 2016/9/22 17:40 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：Application
 */
public class mApp extends Application {
    public static Context mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
