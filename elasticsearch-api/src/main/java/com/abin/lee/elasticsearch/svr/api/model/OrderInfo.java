package com.abin.lee.elasticsearch.svr.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by abin on 2018/2/7 16:22.
 * elasticsearch-svr
 * com.abin.lee.elasticsearch.svr.api.model
 */
@Setter
@Getter
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIgnoreProperties(value = {"class"})
public class OrderInfo {

    private Integer id;
    private Integer teamId;
    private String orderName;
    private BigDecimal orderPrice;
    private Date createTime;
    private Date updateTime;
    private Integer version;



}
