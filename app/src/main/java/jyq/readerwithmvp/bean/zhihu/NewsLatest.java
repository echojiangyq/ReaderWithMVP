package jyq.readerwithmvp.bean.zhihu;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：EchoJ on 2016/9/23 10:50 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
public class NewsLatest implements Serializable{

    /**
     * date : 20160923
     * stories : [{"images":["http://pic3.zhimg.com/f70e8b401111659765a3b33f802e978a.jpg"],"type":0,"id":8817957,"ga_prefix":"092310","title":"视力差，不认路，记忆力减退？多玩玩游戏可能就好了"},
     * {"images":["http://pic3.zhimg.com/4987eeaa975baae80210bbce9305145a.jpg"],"type":0,"id":8819211,"ga_prefix":"092309","title":"先别笑，「没来上课的举个手」这事，人们干过好多回"},
     * {"images":["http://pic4.zhimg.com/204e5a7d4608b9c3c7337a1910e61f7b.jpg"],"type":0,"id":8821002,"ga_prefix":"092308","title":"这课和我的专业又没联系，为什么非要学？"},{"images":["http://pic4
     * .zhimg.com/9a5228762d1aff25475942e87d67e85f.jpg"],"type":0,"id":8820928,"ga_prefix":"092307","title":"创造产品，「做什么」可能比「怎么做」更重要"},{"images":["http://pic4.zhimg
     * .com/37646084f3a9450cf5f094b9fa936003.jpg"],"type":0,"id":8820559,"ga_prefix":"092307","title":"「好好在地球上不行么，为什么一定要去太空养细胞？」"},{"images":["http://pic3.zhimg
     * .com/9eb757e2565bc0ace531e6a01dd54e76.jpg"],"type":0,"id":8819545,"ga_prefix":"092307","title":"因为对人有危害，含有这两种物质的洗浴用品美国不让卖了"},{"images":["http://pic3.zhimg
     * .com/f5df27d899cd891acd6f25154e7738e6.jpg"],"type":0,"id":8820801,"ga_prefix":"092307","title":"读读日报 24 小时热门 TOP 5 · 来自上海的李朱莉和王皮特想离婚"},{"images":["http://pic1.zhimg
     * .com/8f29a762122d3b346237edc68ee39a7c.jpg"],"type":0,"id":8809297,"ga_prefix":"092306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/033419b0de8be09a2b0333fc073fef03.jpg","type":0,"id":8819545,"ga_prefix":"092307","title":"因为对人有危害，含有这两种物质的洗浴用品美国不让卖了"},
     * {"image":"http://pic4.zhimg.com/de6ba90ca510ec1eb0ac538dcd86947b.jpg","type":0,"id":8821002,"ga_prefix":"092308","title":"这课和我的专业又没联系，为什么非要学？"},{"image":"http://pic4
     * .zhimg.com/bee5667f58ff9244b5c799a68adfc77b.jpg","type":0,"id":8819211,"ga_prefix":"092309","title":"先别笑，「没来上课的举个手」这事，人们干过好多回"},{"image":"http://pic3.zhimg
     * .com/86a37ab69f243720b9ecf321d37b6546.jpg","type":0,"id":8820801,"ga_prefix":"092307","title":"读读日报 24 小时热门 TOP 5 · 来自上海的李朱莉和王皮特想离婚"},{"image":"http://pic2.zhimg
     * .com/ddbb1da08bb8dc40ae7e01693888d965.jpg","type":0,"id":8819507,"ga_prefix":"092217","title":"知乎好问题 · 怎样进行良好的情绪管理？"}]
     */

    public String date;
    /**
     * images : ["http://pic3.zhimg.com/f70e8b401111659765a3b33f802e978a.jpg"]
     * type : 0
     * id : 8817957
     * ga_prefix : 092310
     * title : 视力差，不认路，记忆力减退？多玩玩游戏可能就好了
     */

    public List<StoriesBean> stories;
    /**
     * image : http://pic4.zhimg.com/033419b0de8be09a2b0333fc073fef03.jpg
     * type : 0
     * id : 8819545
     * ga_prefix : 092307
     * title : 因为对人有危害，含有这两种物质的洗浴用品美国不让卖了
     */

    public List<TopStoriesBean> top_stories;

    public static class StoriesBean {
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public List<String> images;
    }

    public static class TopStoriesBean {
        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }
}
