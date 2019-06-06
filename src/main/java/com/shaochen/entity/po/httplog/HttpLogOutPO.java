package com.shaochen.entity.po.httplog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhongjf
 * @date 2018/9/10
 * @desc 系统日志字段信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpLogOutPO {

    //日志编号
    private int id;

    //请求地址
    private String reqUrl;

    //请求方式
    private String reqMethod;

    //请求类型
    private String reqType;

    //请求参数
    private String reqParams;

    //报错系统级别的错误：0为没有，其他为异常
    private String respCode;

    //响应错误消息体
    private String respResult;

    //响应时间
    private long respTime;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;

    //状态值
    private String stat;

    public HttpLogOutPO(String reqUrl, String reqMethod, String reqType, String reqParams, String respCode, String respResult, long respTime, LocalDateTime createTime, LocalDateTime updateTime, String stat) {
        this.reqUrl = reqUrl;
        this.reqMethod = reqMethod;
        this.reqType = reqType;
        this.reqParams = reqParams;
        this.respCode = respCode;
        this.respResult = respResult;
        this.respTime = respTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.stat = stat;
    }

}
