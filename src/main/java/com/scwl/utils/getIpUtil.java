package com.scwl.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class getIpUtil {
    public static String getIp2(HttpServletRequest request) {
                    String ip = request.getHeader("X-Forwarded-For");
                    if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
                            //多次反向代理后会有多个ip值，第一个ip才是真实ip
                            int index = ip.indexOf(",");
                            if(index != -1){
                                    return ip.substring(0,index);
                                }else{
                                    return ip;
                                }
                        }
                    ip = request.getHeader("X-Real-IP");
                    if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
                            return ip;
                       }
                   return request.getRemoteAddr();
                }


    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (!checkIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    private static boolean checkIP(String ip) {
        if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)
                || ip.split(".").length != 4) {
            return false;
        }
        return true;
    }
}
