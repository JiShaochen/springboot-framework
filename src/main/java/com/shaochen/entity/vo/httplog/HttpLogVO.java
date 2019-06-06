package com.shaochen.entity.vo.httplog;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author qianye
 * @date 2018/9/14
 * @desc Http日志输出返回体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpLogVO {

    //日志编号
    private Integer id;

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
    private Long respTime;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //状态值
    private String stat;
}
