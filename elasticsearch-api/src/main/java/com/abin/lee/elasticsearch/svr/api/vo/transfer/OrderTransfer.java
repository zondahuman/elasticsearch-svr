package com.abin.lee.elasticsearch.svr.api.vo.transfer;

import com.abin.lee.elasticsearch.svr.api.model.OrderInfo;
import com.abin.lee.elasticsearch.svr.api.vo.request.OrderRequest;
import com.abin.lee.elasticsearch.svr.common.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by abin on 2018/2/7 16:22.
 * elasticsearch-svr
 * com.abin.lee.elasticsearch.svr.api.model
 */

public class OrderTransfer {


    public static OrderInfo transfer(OrderRequest orderRequest){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderRequest.getId());
        orderInfo.setUpdateTime(DateUtil.getYMDHMSTime(orderRequest.getUpdateTime()));
        orderInfo.setCreateTime(DateUtil.getYMDHMSTime(orderRequest.getCreateTime()));
        orderInfo.setOrderName(orderRequest.getOrderName());
        orderInfo.setOrderPrice(orderRequest.getOrderPrice());
        orderInfo.setTeamId(orderRequest.getTeamId());
        orderInfo.setVersion(orderRequest.getVersion());
        return orderInfo;
    }






}
