package com.shaochen.service.httplog;


import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.shaochen.entity.po.httplog.HttpLogInPO;
import com.shaochen.entity.po.httplog.HttpLogOutPO;

/**
 * @author zhongjf
 * @date 2018/9/10
 * @desc 记录调用日志
 */
public interface HttpLogService {

    //添加日志-出记录
    void addHttpLogOut(HttpLogOutPO httpLogOutPO);

    //Http日志输出
    PageResult getHttpLogByPage(PageParam pageParam);
}
