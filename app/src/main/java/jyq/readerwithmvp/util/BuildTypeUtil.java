package jyq.readerwithmvp.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * 作者：EchoJ on 2016/9/22 20:01 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
public class BuildTypeUtil {
    /**
     * 但是当我们没在AndroidManifest.xml中设置其debug属性时: 
     * 使用Eclipse运行这种方式打包时其debug属性为true,使用Eclipse导出这种方式打包时其debug属性为法false. 
     * 在使用ant打包时，其值就取决于ant的打包参数是release还是debug. 
     * 因此在AndroidMainifest.xml中最好不设置android:debuggable属性置，而是由打包方式来决定其值. 
     *
     * @param context
     * @return
     * @author SHANHY
     * @date   2015-8-7 
     */
    public static boolean isApkDebugable(Context context) {
        try {
            ApplicationInfo info= context.getApplicationInfo();
            return (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;
        } catch (Exception e) {

        }
        return false;
    }
}
