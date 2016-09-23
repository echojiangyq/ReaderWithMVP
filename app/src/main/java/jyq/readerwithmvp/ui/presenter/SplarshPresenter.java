package jyq.readerwithmvp.ui.presenter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jyq.readerwithmvp.bean.zhihu.SplarshImg;
import jyq.readerwithmvp.ui.base.BasePresenter;
import jyq.readerwithmvp.ui.view.ISplarshView;

/**
 * 作者：EchoJ on 2016/9/23 11:30 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
public class SplarshPresenter extends BasePresenter<ISplarshView> {
    

    protected void disPlayImage(SplarshImg splashImage, ImageView iv){
        Glide.with(mContext).load(splashImage.img).centerCrop().into(iv);
    }
    
}
