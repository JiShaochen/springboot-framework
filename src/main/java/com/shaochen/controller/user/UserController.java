package com.shaochen.controller.user;

import com.beyondli.common.utils.apiresult.AbstractApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiShaochen
 * @date 2019/6/6 15:55
 * @desc 用户功能操作
 */
@Api(value = "user", tags = {"用户模块controller"})
@RestController(value = "/user")
public class UserController {

    @GetMapping(value = "/hello")
    @ApiModelProperty("测试接口")
    public AbstractApiResult userTest() {
        return AbstractApiResult.success("hello world");
    }

}