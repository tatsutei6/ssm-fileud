package org.tei.ssmfileud.entity;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

/**
 * 商品を管理するEntityクラス。
 */
@Data
public class ItemEntity {

    @CsvBindByName(column = "商品ID", required = true)
    private String id;

    @CsvBindByName(column = "商品名", required = true)
    private String name;

    @CsvBindByName(column = "単価", required = true)
    private int price;

    @CsvBindByName(column = "数量", required = true)
    private int amount;
}