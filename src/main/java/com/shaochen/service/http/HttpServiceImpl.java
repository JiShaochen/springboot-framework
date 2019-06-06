package com.shaochen.service.http;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.shaochen.common.tools.exception.ExceptionManager;
import com.shaochen.common.utils.httpclient.NewRequestUtils;
import com.shaochen.entity.po.http.HttpResult;
import com.shaochen.service.httplog.HttpLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Auther: zhongjf
 * @Date: 2018/9/11 0011 10:02
 * @Description: 日志记录service层
 */
@Service
public class HttpServiceImpl implements HttpService {

    @Resource
    HttpLogService httpLogService;

    @Resource
    ExceptionManager exceptionManager;

    @Override
    public <T> T executeGet(String url, Class<T> clazz) {
        HttpResult httpResult = NewRequestUtils.doGet(url); //网络请求
        return this.addHttpLogOut(httpResult, clazz);
    }

    /**
     @Override
     public <T> ThirdPartyVO executePostReturnWithHeader(Object requestObj, Class<T> clazz, String url, Map<String, String> headerMaps) {

     ThirdPartyVO<T> thirdPartyVO = new ThirdPartyVO();
     String requestJson = JSONObject.toJSONString(requestObj);
     thirdPartyVO = this.executePost(url, requestJson, headerMaps, thirdPartyVO.getClass());

     if (Objects.isNull(thirdPartyVO)) {
     return new ThirdPartyVO();
     }
     List<T> dataList = thirdPartyVO.getData();
     List<T> data = MapperUtils.mapperList(dataList, clazz);
     thirdPartyVO.setData(data);
     if (Objects.isNull(data)) {
     data = Collections.EMPTY_LIST;
     List<T> newT = JSONArray.parseArray(data.toString(), clazz);
     thirdPartyVO.setData(newT);
     }
     String dataString = data.toString();
     List<T> dataList = JsonUtils.jsonToList(dataString, clazz, null);
     thirdPartyVO.setData(dataList);
     return thirdPartyVO;
     }

     @Override
     public <T> ThirdPartyVO executePostReturnWithHeader(Class<T> tClass, String url, Map<String, String> headerMaps) {
     return executePostReturnWithHeader(null, tClass, url, headerMaps);
     }
     */

    @Override
    public <T> T executePostWithForm(String url, Map param, Class<T> clazz) {
        HttpResult httpResult = NewRequestUtils.doPostWithForm(url, param); //网络请求
        return this.addHttpLogOut(httpResult, clazz);
    }

    @Override
    public <T> T executePostWithBasic(String url, String param, String userName, String password, Class<T> clazz) {
        HttpResult httpResult = NewRequestUtils.doPostWithBasic(url, param, userName, password); //网络请求
        return this.addHttpLogOut(httpResult, clazz);
    }

    @Override
    public <T> T executePost(String url, String param, Class<T> clazz) {
        HttpResult httpResult = NewRequestUtils.doPost(url, param); //网络请求
        return this.addHttpLogOut(httpResult, clazz);
    }

    @Override
    public <T> T executePost(String url, String param, Map<String, String> headerMaps, Class<T> clazz) {
        HttpResult httpResult = NewRequestUtils.doPost(url, param, headerMaps); //网络请求
        return this.addHttpLogOut(httpResult, clazz);
    }

    /**
     * @Author: ShaoChen
     * @Description:   判断返回的状态码
     * @Date: 10:30 2018/9/26
     */
    private void checkoutResponseCode(String statusCode) {
        if (statusCode.contains("404") || statusCode.contains("504") || statusCode.contains("EXC")) {
            throw exceptionManager.createByCode("HTTP_0004");
        }
    }

    @Override
    public <T> T executePut(String url, String param, Class<T> clazz) {

        HttpResult httpResult = NewRequestUtils.doPut(url, param); //网络请求
        return this.addHttpLogOut(httpResult, clazz);
    }

    /**
     * @Author: ShaoChen
     * @Description:  处理http请求返回的数据
     * @Date: 14:16 2018/9/26
     */
    private <T> T addHttpLogOut(HttpResult httpResult, Class<T> clazz) {
        try {
            httpLogService.addHttpLogOut(httpResult.getHttpLogOutPO()); //添加http日志记录
            this.checkoutResponseCode(httpResult.getStatusCode());
            return JSONObject.parseObject(httpResult.getContent(), clazz);
        } catch (JSONException e) {
            e.printStackTrace();
            throw exceptionManager.createByCode("HTTP_0002");
        }
    }

    @Override
    public <T> T executePut(String url, String param, Map<String, String> headerMap, Class<T> clazz) {
        HttpResult httpResult = NewRequestUtils.doPut(url, param, headerMap); //网络请求
        return this.addHttpLogOut(httpResult, clazz);
    }

}
