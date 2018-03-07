package com.abin.lee.elasticsearch.svr.api.vo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by abin on 2018/2/7 16:22.
 * elasticsearch-svr
 * com.abin.lee.elasticsearch.svr.api.model
 */
@Setter
@Getter
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"class"})
public class OrderRequest {

    private Integer id;
    private Integer teamId;
    private String orderName;
    private BigDecimal orderPrice;
    private String createTime;
    private String updateTime;
    private Integer version;


}
