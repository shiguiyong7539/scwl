package com.scwl;





import com.alibaba.fastjson.JSONPath;
import com.google.gson.Gson;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

public class demo {

    public static void main(String[] args) {
       // System.out.println(UUID.randomUUID().toString().replace("-",""));
       // String str='{"key": 0, "name": "MACアドレス", "type": "text", "definition": {}, "expression": "$.mac", "code": "mac"}, {"key": 1, "code": "read_time", "name": "読み込みタイム", "type": "text", "definition": {}, "expression": "$.t"}';
//        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//        LinkedHashMap<String, Object> map2 = new LinkedHashMap<>();
//        JsonObject json = new JsonObject();
//        json.addProperty("key",0);
//        json.addProperty("name","MACアドレス");
//        json.addProperty("type","text");
//        json.addProperty("definition","text");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("key",0);
//        jsonObject.put("name","MACアドレス");
//        jsonObject.put("type","text");
//        map.put("conf","12345");
//        map2.put("conf","12345");
//        map.put("obj",map2);
//        jsonObject.put("definition",map);
//        System.out.println(jsonObject.toString());
//        System.out.println(json.toString());
//        System.out.println(new Gson().toJson(map));
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        System.out.println(Instant.now().toEpochMilli());
//        HashMap<String, Object> map = new HashMap<>();
//        HashMap<String, Object> map2 = new HashMap<>();
//        map.put("t", 12131313);
//        map.put("mac", "1122333");
//        map2.put("cmd",0);
//        map2.put("session","0");
//        map.put("2222",map2);
//        String s1 = new Gson().toJson(map).toString();
//        System.out.println(s1);
//           System.out.println(JSONPath.read(s1,"$.t").toString());
//           System.out.println(JSONPath.read(s1,"$.2222.session").toString());
//           System.out.println(JSONPath.read(s1,"$.2222.cmd").toString());
//           System.out.println(JSONPath.read(s1,"$.mac").toString());
//           System.out.println(LocalDateTime.now());
//            JSONObject jsonObject = new JSONObject(s1);
//            String t = jsonObject.get("t").toString();
//            System.out.println(t);

        String str = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
        System.out.println(str);




    }
}
