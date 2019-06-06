package com.shaochen.service.http;


import java.util.Map;

/**
 * @author zhongjf
 * @date 2018/9/10
 * @desc http请求Service层
 */
public interface HttpService {

    <T> T executeGet(String url, Class<T> clazz);

    /**
    <T> ThirdPartyVO executePostReturnWithHeader(Object requestObj, Class<T> clazz, String url, Map<String, String> headerMaps);

    <T> ThirdPartyVO executePostReturnWithHeader(Class<T> tClass, String url, Map<String, String> headerMaps);
    */
    <T> T executePostWithForm(String url, Map param, Class<T> clazz);

    <T> T executePostWithBasic(String url, String param, String userName, String password, Class<T> clazz);

    <T> T executePost(String url, String param, Class<T> clazz);

    <T> T executePost(String url, String param, Map<String, String> headerMaps, Class<T> clazz);

    <T> T executePut(String url, String param, Class<T> clazz);

    <T> T executePut(String url, String param, Map<String, String> headerMap, Class<T> clazz);



}
