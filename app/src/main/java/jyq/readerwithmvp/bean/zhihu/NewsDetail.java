package jyq.readerwithmvp.bean.zhihu;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：EchoJ on 2016/9/23 11:19 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
public class NewsDetail implements Serializable {
    /**
     * image_source : 《人再囧途之泰囧》
     * title : 知乎好问题 Plus · 国庆怎么玩，加量不加价
     * image : http://pic3.zhimg.com/b312b41ef51be11f3aee446dbe5b67a2.jpg
     * share_url : http://daily.zhihu.com/story/8812568
     * js : []
     * ga_prefix : 092117
     * section : {"thumbnail":"http://pic3.zhimg.com/89c74f22b51530f1870c2ed0fe6f13ce.jpg","id":38,"name":"知乎好问题"}
     * images : ["http://pic1.zhimg.com/7b34da249c7f5cf1495315fc868bbf60.jpg"]
     * type : 0
     * id : 8812568
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    public String body;
    public String image_source;
    public String title;
    public String image;
    public String share_url;
    public String ga_prefix;

    public SectionBean section;
    public int type;
    public int id;
    public List<?> js;
    public List<String> images;
    public List<String> css;
    
    
    /**
     * thumbnail : http://pic3.zhimg.com/89c74f22b51530f1870c2ed0fe6f13ce.jpg
     * id : 38
     * name : 知乎好问题
     */

    public static class SectionBean {
        public String thumbnail;
        public int id;
        public String name;
    }
}
