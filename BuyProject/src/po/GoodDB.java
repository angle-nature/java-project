package po;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GoodDB {
    private static Map<String, Good> goods=new HashMap<String,Good>();
    static{
        goods.put("1", new Good("1","华为手机",5499,10000));
        goods.put("2", new Good("2","烤箱",1999,20000));
        goods.put("3", new Good("3","豆浆机",598,20000));
        goods.put("4", new Good("4","电脑",6789,5000));
        goods.put("5", new Good("5","台灯",69,30000));
    }
    //获得所有商品
    public static Collection<Good> getAll() {
        return goods.values();
    }
    //根据id获得商品
    public static Good getById(String id) {
        return goods.get(id);
    }

}
