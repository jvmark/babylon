package com.onmysky.babylon.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.*;
import com.taobao.api.request.*;
import com.taobao.api.response.*;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mark on 15/11/3.
 */
public class TaobaoApiUtil {

    protected static String url = "https://eco.taobao.com/router/rest";
    private final static String appKey_taobaoke = "21169118";
    private final static String appSecret_taobaoke = "d93a05a2515653d8d04a0ce5149c49fd";
    private final static String appKey_baichuan = "23106413";
    private final static String appSecret_baichuan = "2d05fe0a2d01a165759981f5862227dc";

    private static Logger logger = Logger.getLogger("shoppingApi");
    private TaobaoClient client_taobaoke;
    private TaobaoClient client_baichuan;

    public TaobaoApiUtil() {
        client_taobaoke = new DefaultTaobaoClient(url, appKey_taobaoke, appSecret_taobaoke);
        client_baichuan = new DefaultTaobaoClient(url, appKey_baichuan, appSecret_baichuan);
    }

    public List<TaobaokeItemDetail> getTaobaokeItemsList(String itemIds) {
        TaobaokeItemsDetailGetRequest req = new TaobaokeItemsDetailGetRequest();
        req.setFields("num_iid,detail_url,seller_id,cid,nick,title,price,volume,pic_url,item_url,shop_url");
        req.setNumIids(itemIds);
        TaobaokeItemsDetailGetResponse resp = null;
        try {
            resp = client_taobaoke.execute(req);
        } catch (ApiException e) {
            logger.info("getTaobaokeItemsList error : " + e);
            return null;
        }
        if (resp != null)
            return resp.getTaobaokeItemDetails();
        return null;
    }

    public void testTB() {
        TbkItemConvertRequest req = new TbkItemConvertRequest();
        req.setNumIids("520984378667");
        req.setAdzoneId(0L);
        req.setPlatform(2L);
        req.setFields("num_iid,click_url");
        TbkItemConvertResponse resp = null;
        try {
            resp = client_taobaoke.execute(req);
        } catch (Exception e) {

        }
    }
}
