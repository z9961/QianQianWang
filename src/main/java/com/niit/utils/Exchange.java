package com.niit.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//传入数值和货币类型,输出美元

@Component
public class Exchange {
    @Autowired
    JuheDemo juhe;

    public BigDecimal getValue(BigDecimal coin, int type) {

        //json

        JSONObject jsonObject = juhe.getRequest1();
        JSONArray data = jsonObject.getJSONArray("result");
        JSONObject job = data.getJSONObject(0);

        System.out.println("jsonObject = " + jsonObject);
        System.out.println("data = " + data);
        System.out.println("job = " + job);
        
        String key;
        JSONObject value;

        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();

        //map存放数据map = {英镑=856.64, 欧元=752.02,日元=5.7459, 美元=637.99}
        Iterator iterator = job.keys();
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = job.getJSONObject(key);
            String name = value.getString("name");
            double bcp = value.getDouble("bankConversionPri");
            map.put(name, BigDecimal.valueOf(bcp));
        }

        String typestr = "美元";
        switch (type) {
            case 1:
                typestr = "人民币";
                break;
            case 3:
                typestr = "欧元";
                break;
            case 4:
                typestr = "日元";
                break;
            case 5:
                typestr = "英镑";
                break;
        }
        BigDecimal coinvalue = map.get(typestr);
        BigDecimal coinDvalue = map.get("美元");

        System.out.println("coinvalue = " + coinvalue);
        System.out.println("coinDvalue = " + coinDvalue);
        System.out.println("coin = " + coin);
        System.out.println("type = " + type);
        System.out.println("typestr = " + typestr);

        if (type == 2)
            return coin;
        else if (type == 1)
            //保留小数精度2位,四舍五入
            return coin.divide(coinDvalue, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        else
            return coin.multiply(coinvalue).divide(coinDvalue, 2, RoundingMode.HALF_UP);
    }

}
