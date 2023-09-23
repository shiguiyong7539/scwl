/**   
 * @Package com.sound.util 
 * @Description: 
 * @author xfwang
 * @email 2602781@qq.com
 * @date 2016年11月24日 上午3:41:17 
 * @version V1.0   
 */
package com.scwl.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * @ClassName: HttpRequestUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
public class HttpClientUtils {

    /**
     * 发送POST请求,普通参数格式
     * 
     * @param url
     * @param mapParam
     * @param noNeedResponse
     * @return JSONObject
     */
    public static JSONObject sentPostWithMapResultJson(HttpHeader header, String url, Map<String, String> mapParam) {
        // post请求返回结果
        CloseableHttpClient client = HttpClientBuilder.create().build();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            // 设置POST请求头
            method = setHeader(method, header);
            // 设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Entry<String, String>> iterator = mapParam.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
                method.setEntity(entity);
            }
            HttpResponse response = client.execute(method);
            int statusCode = response.getStatusLine().getStatusCode();
            /** 请求发送成功，并得到响应 **/
            if (HttpStatus.SC_OK == statusCode) {
                try {
                    /** 读取服务器返回过来的json字符串数据 **/
                    jsonResult = JSONObject.fromObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

    /**
     * 发送POST请求，Json格式参数
     * 
     * @param url
     * @param jsonParam
     * @param noNeedResponse
     * @return JSONObject
     */
    public static JSONObject sentPostWithJsonResultJson(HttpHeader header, String url, JSONObject jsonParam) {
        // post请求返回结果
        CloseableHttpClient client = HttpClientBuilder.create().build();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            // 设置POST请求头
            method = setHeader(method, header);
            // 建立一个NameValuePair数组，用于存储欲传送的参数
            method.addHeader("Content-type", "application/json; charset=utf-8");
            method.setHeader("Accept", "application/json");
            method.setEntity(new StringEntity(jsonParam.toString(), "UTF-8"));
            HttpResponse response = client.execute(method);
            /** 请求发送成功，并得到响应 **/
           // MyLogger.systemOut("statusCode:" + response.getStatusLine().getStatusCode());
            try {
                /** 把json字符串转换成json对象 **/
                jsonResult = JSONObject.fromObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
                /** 把json字符串转换成json对象 **/
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

    /**
     * 发送POST请求,普通参数格式
     * 
     * @param url
     * @param mapParam
     * @param noNeedResponse
     * @return JSONObject
     */
    public static String sentPostWithMapResultString(HttpHeader header, String url, Map<String, String> mapParam) {
        // post请求返回结果
        CloseableHttpClient client = HttpClientBuilder.create().build();
        String result = null;
        HttpPost method = new HttpPost(url);
        try {
            // 设置POST请求头
            method = setHeader(method, header);
            // 设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Entry<String, String>> iterator = mapParam.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
                method.setEntity(entity);
            }
            HttpResponse response = client.execute(method);
            int statusCode = response.getStatusLine().getStatusCode();
            /** 请求发送成功，并得到响应 **/
            if (HttpStatus.SC_OK == statusCode) {
                try {
                    /** 读取服务器返回过来的json字符串数据 **/
                    result = EntityUtils.toString(response.getEntity(), "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送POST请求，Json格式参数
     * 
     * @param url
     * @param jsonParam
     * @param noNeedResponse
     * @return JSONObject
     */
    public static String sentPostWithJsonResultString(HttpHeader header, String url, JSONObject jsonParam) {
        // post请求返回结果
        CloseableHttpClient client = HttpClientBuilder.create().build();
        String result = null;
        HttpPost method = new HttpPost(url);
        try {
            // 设置POST请求头
            method = setHeader(method, header);
            method.setEntity(new StringEntity(jsonParam.toString(), "UTF-8"));
            HttpResponse response = client.execute(method);
            int statusCode = response.getStatusLine().getStatusCode();
            /** 请求发送成功，并得到响应 **/
            if (HttpStatus.SC_OK == statusCode) {
                try {
                    /** 把json字符串转换成json对象 **/
                    result = EntityUtils.toString(response.getEntity(), "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送POST请求，一般字符串参数
     * 
     * @Title: httpPostBackString
     * @Author: xfwang
     * @param url
     * @param param
     * @return String
     */
    public static String sentPostWithStringResultString(HttpHeader header, String url, String param) {
        // post请求返回结果
        CloseableHttpClient client = HttpClientBuilder.create().build();
        String result = null;
        HttpPost method = new HttpPost(url);
        try {
            // 设置POST请求头
            method = setHeader(method, header);
            method.setEntity(new StringEntity(param.toString(), "UTF-8"));
            HttpResponse response = client.execute(method);
            int statusCode = response.getStatusLine().getStatusCode();
            /** 请求发送成功，并得到响应 **/
            if (HttpStatus.SC_OK == statusCode) {
                try {
                    /** 把json字符串转换成json对象 **/
                    result = EntityUtils.toString(response.getEntity(), "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送get请求
     * 
     * @param url 路径
     * @return
     */
    public static JSONObject httpGet(String url) {
        // get请求返回结果
        JSONObject jsonResult = null;
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            // 发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            /** 请求发送成功，并得到响应 **/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /** 读取服务器返回过来的json字符串数据 **/
                String strResult = EntityUtils.toString(response.getEntity());
                /** 把json字符串转换成json对象 **/
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                // logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            // logger.error("get请求提交失败:" + url, e);
        }
        return jsonResult;
    }

    /**
     * 设置POST请求头
     * 
     * @Title: setHeader
     * @Author: xfwang
     * @param header
     * @return HttpPost
     */
    private static HttpPost setHeader(HttpPost post, HttpHeader header) {
        if (header != null) {
           /* if (UtilString.isNotNull(header.getAuthorization())) {
            }*/
            post.addHeader("Authorization", header.getAuthorization());
        }
        return post;
    }

    public static void main(String[] args) throws IOException {

    }
    /*public static JSONObject CreateOrder(String key,String DATE,String SIGNATURE,HttpHeader header, String url, JSONObject jsonParam) {
        // post请求返回结果
        CloseableHttpClient client = HttpClientBuilder.create().build();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            // 设置POST请求头
            method = setHeader(method, header);
            // 建立一个NameValuePair数组，用于存储欲传送的参数
            method.addHeader("Content-type", "application/x-www-form-urlencoded");
            method.addHeader("DATE", DATE);
            method.addHeader("X-SIGNATURE", SIGNATURE);
            method.addHeader("APP-KEY", key);
            method.setHeader("Accept", "application/json");
            method.setEntity(new StringEntity(jsonParam.toString(), "UTF-8"));
            Header[] allHeaders = method.getAllHeaders();
            for (Header header2 : allHeaders) {
				System.out.println(header2);
			}
            HttpResponse response = client.execute(method);
            *//** 请求发送成功，并得到响应 **//*
           // MyLogger.systemOut("statusCode:" + response.getStatusLine().getStatusCode());
            try {
                *//** 把json字符串转换成json对象 **//*
                jsonResult = JSONObject.fromObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
                *//** 把json字符串转换成json对象 **//*
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }*/

    public static JSONObject CreateOrder(String key,String DATE,String SIGNATURE,HttpHeader header, String url, Map<String, String> mapParam) {
        // post请求返回结果
        CloseableHttpClient client = HttpClientBuilder.create().build();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            // 设置POST请求头
            method = setHeader(method, header);
            method.addHeader("Content-type", "application/x-www-form-urlencoded");
            method.addHeader("DATE", DATE);
            method.addHeader("X-SIGNATURE", SIGNATURE);
            method.addHeader("APP-KEY", key);
            // 设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Entry<String, String>> iterator = mapParam.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
                method.setEntity(entity);
            }
            HttpResponse response = client.execute(method);
            int statusCode = response.getStatusLine().getStatusCode();
            /** 请求发送成功，并得到响应 **/
            if (HttpStatus.SC_OK == statusCode) {
                try {
                    /** 读取服务器返回过来的json字符串数据 **/
                    jsonResult = JSONObject.fromObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }



}
