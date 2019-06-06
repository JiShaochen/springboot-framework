package com.shaochen.mapper.httplog;

import com.shaochen.entity.po.httplog.HttpLogOutPO;
import org.apache.ibatis.annotations.Insert;

/**
 * @author zhongjf
 * @date 2018/9/10
 * @desc 日志记录操作
 */
public interface HttpLogCUDMapper {

    @Insert("insert into tb_http_log_out(req_url,req_method,req_type,req_params,resp_code,resp_result,resp_time,create_time,update_time,stat) " +
            "values(#{reqUrl},#{reqMethod},#{reqType},#{reqParams}, #{respCode},#{respResult},#{respTime},#{createTime},#{updateTime},#{stat})")
    void addHttpLogOut(HttpLogOutPO httpLogOutPO);
}
