package com.example.mapper;

import com.example.entity.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeMapper {

    /**
     * 新增
     */
    int insert(Type type);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Type type);

    /**
     * 根据ID查询
     */
    Type selectById(Integer id);

    /**
     * 查询所有
     */
    List<Type> selectAll(Type type);

    /**
     * 分页查询
     */
    PageInfo<Type> selectPage(Type type, Integer pageNum, Integer pageSize);

}