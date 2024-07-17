package com.example.mapper;

import com.example.entity.Goods;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    /**
     * 新增
     */
    int insert(Goods goods);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Goods goods);

    /**
     * 根据ID查询
     * @return
     */
    Goods selectById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Goods> selectAll(Goods goods);

    //    查询销量前15的商品
    @Select("select * from goods order by count desc limit 15")
    List<Goods> selectTop15();
    //按分类查询
    @Select("select * from goods where type_id = #{id}")
    List<Goods> selectByTypeId(Integer id);
    //按商家查询
    @Select("select * from goods where business_id = #{id}")
    List<Goods> selectByBusinessId(Integer id);

    //前端搜索框查询
    @Select("select * from goods where name like concat('%', #{name}, '%')")
    List<Goods> selectByName(String name);

}
