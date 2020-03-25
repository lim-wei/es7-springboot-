package com.liaoyuan.dianping.dal;

import com.liaoyuan.dianping.model.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun Mar 08 23:13:09 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun Mar 08 23:13:09 CST 2020
     */
    int insert(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun Mar 08 23:13:09 CST 2020
     */
    int insertSelective(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun Mar 08 23:13:09 CST 2020
     */
    UserModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun Mar 08 23:13:09 CST 2020
     */
    int updateByPrimaryKeySelective(UserModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Sun Mar 08 23:13:09 CST 2020
     */
    int updateByPrimaryKey(UserModel record);

    // 同时使用telphone和password进行chaxun
    UserModel selectByTelphoneAndPassword(@Param("telphone") String telphone, @Param("password") String password);

    // 获取所有用户数
    Integer countAllUser();
}