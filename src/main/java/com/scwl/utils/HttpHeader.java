/**   
 * @Package com.akaiche.framework.util.http.header 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xfwang(2602781@qq.com)   
 * @date 2017年8月17日 下午4:45:05 
 * @version V1.0   
 */
package com.scwl.utils;

/**
 * HTTP-HEADER报名头常见属性
 * 
 * @ClassName: HttpHeader
 * @Description: 顾名思义，请求头部字段当然是在请求头中才使用的字段。该字段用于补充请求的附加信息，客户端信息等<br>
 *               本类给出常用而且比较重要的几个请求头部字段。
 * @author xfwang(2602781@qq.com)
 * @date 2017年8月17日 下午4:45:05
 */
public class HttpHeader {

    /**
     * 该字段可通知服务器用户代理能够处理的媒体类型以及该媒体类型对应的优先级。<br>
     * 媒体类型可使用“type/subtype”这种形式来指定，分号后边紧跟着的是该类型的优先级。
     */
    private String accept;

    /**
     * 该字段用来告知服务器，客户端这边可支持的内容编码以及相应内容编码的优先级<BR>
     * gzip表示由文件压缩程序gzip(GNU zip)生成的编码格式。<BR>
     * compress表示UNIX文件压缩程序compress生成的编码格式。<BR>
     * deflate表示组合使用zlib格式以及有deflate压缩算法生成的编码格式。<BR>
     * identity表示不执行压缩或者使用一致的默认编码格式
     */
    private String acceptEncoding;

    /**
     * 该字段用来告知服务器，客户端可处理的自然语言集
     */
    private String acceptLanguage;

    /**
     * 用来告知服务器用户端的认证信息，下方就是连接公司内部SVN系统时需要认证时的请求头部信息
     */
    private String authorization;

    /**
     * @return the accept
     */
    public String getAccept() {
        return accept;
    }

    /**
     * @return the acceptEncoding
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    /**
     * @return the acceptLanguage
     */
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    /**
     * @return the authorization
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * @param accept the accept to set
     */
    public void setAccept(String accept) {
        this.accept = accept;
    }

    /**
     * @param acceptEncoding the acceptEncoding to set
     */
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    /**
     * @param acceptLanguage the acceptLanguage to set
     */
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    /**
     * @param authorization the authorization to set
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

}
