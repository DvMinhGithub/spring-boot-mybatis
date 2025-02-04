package com.mdv.mybatis.mapper;

import com.mdv.mybatis.model.dto.UserDTO;
import com.mdv.mybatis.model.request.UserCreateRequest;
import com.mdv.mybatis.model.request.UserLoginRequest;
import com.mdv.mybatis.model.request.UserUpdateRequest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void createUser(@Param("u") UserCreateRequest user);

    UserDTO login(@Param("u") UserLoginRequest user);

    List<UserDTO> findAll();

    UserDTO findById(@Param("id") Long id);

    UserDTO findByEmailOrPhone(@Param("email") String email, @Param("phone") String phone);

    void updateUser(@Param("id") Long id, @Param("u") UserUpdateRequest user);

    void updatePassword(@Param("id") Long id, @Param("password") String password);

    void deleteUser(@Param("id") Long id);

    void assignRoles(@Param("id") Long userId, @Param("roleIds") List<Long> roleIds);

    void deleteRolesByUserId(@Param("userId") Long userId);

    void insertRoles(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);
}
