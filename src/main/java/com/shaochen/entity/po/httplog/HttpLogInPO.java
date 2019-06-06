package com.shaochen.entity.po.httplog;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhongjf
 * @date 2018/9/10
 * @desc 系统日志字段信息
 */
@Data
public class HttpLogInPO {

    //日志编号
    private int id;

    //请求操作编号
    private String openId;

    //当前操作人ID
    private String userId;

    //日志来源地
    private String fromCode;

    //请求方IP
    private String reqIp;

    //请求地址部分
    private String reqPath;

    //请求方式
    private String reqMethod;

    //请求类型
    private String reqType;

    //请求参数
    private String reqParams;


    //是否报错系统级别的错误：0为没有，其他为自定义异常
    private String respCode;

    //响应错误消息体
    private String respErrorMsg;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;

    //状态值
    private String stat;

}
