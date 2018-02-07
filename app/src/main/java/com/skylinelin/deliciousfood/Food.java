package com.skylinelin.deliciousfood;

/**
 * @author skylinelin
 * @date 2018/2/7
 */

public class Food {
    public static final int CHINESE_FOOD = 1;
    public static final int FAST_FOOD = 2;
    public static final int DESSERT_FOOD = 3;
    /**
     * 名称
     */
    private String name;

    /**
     * 图片
     */
    private int imgResld;

    /**
     * 价格
     */
    private int price;
    /**
     * 类型，美食类型：
     * CHINESE_FOOD
     * FAST_FOOD
     * DESSERT_FOOD
     */
    private int type;

    /**
     * 评分
     */
    private float rating;

    /**
     * 简介
     */
    private String description;

    /**
     * 是否辣
     */
    private boolean isSpicy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgResld() {
        return imgResld;
    }

    public void setImgResld(int imgResld) {
        this.imgResld = imgResld;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public Food(String name, int imgResld, int price, int type, boolean rating, float description, String isSpicy) {

        this.name = name;
        this.imgResld = imgResld;
        this.price = price;
        this.type = type;
        this.rating = rating;
        this.description = description;
        this.isSpicy = isSpicy;
    }
}
