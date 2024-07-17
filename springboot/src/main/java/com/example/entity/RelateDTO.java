package com.example.entity;

public class RelateDTO{
    private Integer useId;
    private Integer goodsId;
    private Integer index;

    public RelateDTO(Integer useId, Integer goodsId, Integer index) {
        this.setUseId(useId);
        this.setGoodsId(goodsId);
        this.setIndex(index);
    }

    /** 用户id */
    public Integer getUseId() {
        return useId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    /** 商品id */
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /** 指数 */
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
