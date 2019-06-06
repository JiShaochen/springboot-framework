package com.shaochen.service.httplog;

import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.beyondli.common.utils.page.PageResultFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shaochen.common.tools.exception.ExceptionManager;
import com.shaochen.mapper.httplog.HttpLogCUDMapper;
import com.shaochen.mapper.httplog.HttpLogQueryMapper;
import com.shaochen.entity.po.httplog.HttpLogOutPO;
import com.shaochen.entity.vo.httplog.HttpLogVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: zhongjf
 * @Date: 2018/9/11 0011 10:02
 * @Description: 日志记录service层
 */
@Service
public class HttpLogServiceImpl implements HttpLogService {

    @Resource
    HttpLogCUDMapper httpLogCUDMapper;

    @Resource
    private HttpLogQueryMapper httpLogQueryMapper;

    @Resource
    private PageResultFactory pageResultFactory;

    @Resource
    private ExceptionManager exceptionManager;


    /**
     *
     * @param httpLogOutPO
     * @return void
     * @time 2018/9/11 0011
     * @description  添加日志-出 操作
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addHttpLogOut(HttpLogOutPO httpLogOutPO) {
        httpLogCUDMapper.addHttpLogOut(httpLogOutPO);
    }

    /**
     * @author qianye
     * @date 2018/9/14
     * @desc Http日志输出
     */
    @Override
    public PageResult getHttpLogByPage(PageParam pageParam) {
        PageHelper.startPage(pageParam.getP(), pageParam.getC());
        List<HttpLogVO> httpLogVOList = httpLogQueryMapper.getHttpLogList();
        if (Objects.isNull(httpLogVOList)) {
            throw exceptionManager.createByCode("HTTP_0003");
        }
        // 取分页信息
        int total = (int) new PageInfo(httpLogVOList).getTotal();
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, httpLogVOList);
        return pageResult;
    }

}
