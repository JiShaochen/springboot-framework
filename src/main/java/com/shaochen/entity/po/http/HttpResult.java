package com.shaochen.entity.po.http;

import com.shaochen.entity.po.httplog.HttpLogOutPO;
import lombok.Data;

/**
 * @Auther: zhongjf
 * @Date: 2018/9/12 0012 00:31
 * @Description:
 */
@Data
public class HttpResult {

    //网络返回码
    private String statusCode;

    //返回内容
    private String Content;

    //记录日志集合
    private HttpLogOutPO httpLogOutPO;
}
