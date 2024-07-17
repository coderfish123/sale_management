package com.example.controller;

import com.example.common.Result;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Goods;
import com.example.service.GoodsService;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Goods goods) {
        //显示商品所属商家
        Account currentUser = TokenUtils.getCurrentUser();
        if(RoleEnum.BUSINESS.equals(currentUser.getRole())){
            goods.setBusinessId(currentUser.getId());
        }
        goodsService.add(goods);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        goodsService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        goodsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Goods goods) {
        goodsService.updateById(goods);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById")
    public Result selectById(@RequestParam Integer id) {
        Goods goods = goodsService.selectById(id);
        return Result.success(goods);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Goods goods ) {
        List<Goods> list = goodsService.selectAll(goods);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Goods goods,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Goods> page = goodsService.selectPage(goods, pageNum, pageSize);
        return Result.success(page);
    }

//    热卖商品
    @GetMapping("/selectTop15")
    public Result selectTop15(){
        List<Goods> list = goodsService.selectTop15();
        return Result.success(list);
    }

//    根据分类id查询所有商品
    @GetMapping("/selectByTypeId")
    public Result selectByTypeId(@RequestParam Integer id) {
        List<Goods> list = goodsService.selectByTypeId(id);
        return Result.success(list);
    }

    @GetMapping("/selectByBusinessId")
    public Result selectByBusinessId(@RequestParam Integer id) {
        List<Goods> list = goodsService.selectByBusinessId(id);
        return Result.success(list);
    }

    @GetMapping("/selectByName")
    public Result selectByName(@RequestParam String name) {
        List<Goods> list = goodsService.selectByName(name);
        return Result.success(list);
    }

    @GetMapping("/recommend")
    public Result recommend() {
        List<Goods> list = goodsService.recommend();
        return Result.success(list);
    }



}