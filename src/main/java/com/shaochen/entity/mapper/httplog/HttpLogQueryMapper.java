package com.shaochen.entity.mapper.httplog;

import com.shaochen.entity.vo.httplog.HttpLogVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HttpLogQueryMapper {

    //Http日志输出
    @Select("select * from tb_http_log_out ORDER BY create_time desc")
    List<HttpLogVO> getHttpLogList();
}
