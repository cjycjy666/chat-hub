package com.cjy.chathubbackend.service;

import com.cjy.chathubbackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * @author chenjiangyu
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2024-04-07 11:18:03
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount   用户名
     * @param userPassword  密码
     * @param checkPassword 校验码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登陆
     *
     * @param userAccount  用户名
     * @param userPassword 密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户信息脱敏
     * @param originUser 原始用户信息
     * @return 脱敏用户信息
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     * @param request HttpServletRequest
     * @return 标识码
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);
}
