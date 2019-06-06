package com.shaochen.entity.enums.common;

/**
 * @author JiShaochen
 * @date 2018/7/4 16:35
 * @desc 用户是否有效的状态.
 */
public enum ValidEnum {
    VALID("有效"), INVALID("失效的");
    private String name;
    ValidEnum(String name) {
        this.name = name;
    }
}