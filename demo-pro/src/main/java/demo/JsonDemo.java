package demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoupanchn on 2019/9/3.
 */
public class JsonDemo {
    private static JSONObject getJson() {
        JSONObject      jsonObject    = new JSONObject();
        List<GoodsDemo> goodsDemoList = new ArrayList<>();
        for (int i = 0; i <= 0; i++) {
            GoodsDemo goodsDemo = new GoodsDemo();
            goodsDemo.setGoodsCode("AAA" + i);
            goodsDemo.setChannelGoodsCode("BBB" + i);
            goodsDemo.setSource(i);
            goodsDemoList.add(goodsDemo);
        }
        jsonObject.put("goods", JSONArray.parseArray(JSON.toJSONString(goodsDemoList)));
        jsonObject.put("type", 1);
        //System.out.println(jsonObject);
        return jsonObject;
    }

    public static void main(String[] args) {
        /*JSONObject json       = getJson();
        JSONArray  goods      = json.getJSONArray("goods");
        System.out.println(goods);*/
        //System.out.println(json);
        //JSONObject jsonObject = JSONArray.parseArray(json.getString("goods")).getJSONObject(0);
        //System.out.println(jsonObject);
        //String goodsCode = jsonObject.getString("goodsCode");
        /*Byte i = 1;
        if (i.toString().equals("1")) {
            System.out.println(i.toString());
        }*/

        List<GoodsDemo> goodsDemoList = new ArrayList<>();
        for (int i = 0; i <= 0; i++) {
            GoodsDemo goodsDemo = new GoodsDemo();
            goodsDemo.setGoodsCode("AAA" + i);
            goodsDemo.setChannelGoodsCode("BBB" + i);
            goodsDemo.setSource(i);
            goodsDemoList.add(goodsDemo);
        }
        String jsonString = JSONObject.toJSONString(goodsDemoList);
        System.out.println(jsonString);
        List<GoodsDemo> objects = JSONObject.parseArray(jsonString, GoodsDemo.class);
        for(GoodsDemo g:objects){
            System.out.println(g.getGoodsCode());
        }
    }
}