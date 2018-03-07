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
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamInfo {

    private Integer id;
    private String teamName;
    private BigDecimal teamPrice;
    private String field1;
    private String field2;
    private Date createTime;
    private Date updateTime;
    private Integer version;


}
