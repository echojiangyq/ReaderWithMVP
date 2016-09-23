package jyq.readerwithmvp.ui.base;

import android.content.Context;
import android.widget.Toast;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import jyq.readerwithmvp.R;

/**
 * 作者：EchoJ on 2016/9/23 11:36 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
public class BasePresenter<V> {
    protected Reference<V> mViewRef;
    protected Context mContext;
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
    protected void loadError(Throwable throwable) {
        throwable.printStackTrace();
        if(mContext!=null){
            Toast.makeText(mContext, R.string.load_error, Toast.LENGTH_SHORT).show();
        }
    }
}
