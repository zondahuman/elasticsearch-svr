package com.abin.lee.elasticsearch.svr.api.search;

import com.abin.lee.elasticsearch.svr.api.vo.request.OrderRequest;
import com.abin.lee.elasticsearch.svr.api.vo.request.TeamRequest;
import com.abin.lee.elasticsearch.svr.api.vo.transfer.OrderTransfer;
import com.abin.lee.elasticsearch.svr.common.util.DateUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * http://blog.csdn.net/napoay/article/details/51707023
 */
@Slf4j
public final class TeamSearchUtil {


    public static Map<String, Object> generateIndexMap(TeamRequest teamRequest, OrderRequest orderRequest) {
        Map<String, Object> json = new HashMap<>();

        json.put("id", teamRequest.getId());
        json.put("teamName", teamRequest.getTeamName());
        json.put("teamPrice", teamRequest.getTeamPrice());
        json.put("field1", teamRequest.getField1());
        json.put("field2", teamRequest.getField2());
        json.put("createTime", DateUtil.getYMDHMSTime(teamRequest.getCreateTime()));
        json.put("updateTime", DateUtil.getYMDHMSTime(teamRequest.getUpdateTime()));
        json.put("version", teamRequest.getVersion());
        try {
            json.put("orderInfo", BeanUtils.describe(OrderTransfer.transfer(orderRequest)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("json:{}", JSON.toJSON(json));

        return json;
    }


    public static XContentBuilder createIndexObject(TeamRequest teamRequest, OrderRequest orderRequest) throws Exception {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("id", teamRequest.getId())
                .field("teamName", teamRequest.getTeamName())
                .field("teamPrice", teamRequest.getTeamPrice())
                .field("field1", teamRequest.getField1())
                .field("field2", teamRequest.getField2())
                .field("createTime", DateUtil.getYMDHMSTime(teamRequest.getCreateTime()))
                .field("updateTime", DateUtil.getYMDHMSTime(teamRequest.getUpdateTime()))
                .field("version", teamRequest.getVersion())
//                .field("orderInfo", BeanUtils.describe(OrderTransfer.transfer(orderRequest)))
                .field("orderInfo", BeanUtils.describe(orderRequest))
                .endObject();
//                .latlon("location", businessRequest.getLatitude(), businessRequest.getLongitude())
//                .endObject();
//                .startObject("_all").field("analyzer","ik").field("search_analyzer","ik").endObject();
        return builder;
    }


    public static String createIndexJson(TeamRequest teamRequest, OrderRequest orderRequest) throws Exception {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("id", teamRequest.getId())
                .field("teamName", teamRequest.getTeamName())
                .field("teamPrice", teamRequest.getTeamPrice())
                .field("field1", teamRequest.getField1())
                .field("field2", teamRequest.getField2())
                .field("createTime", DateUtil.getYMDHMSTime(teamRequest.getCreateTime()))
                .field("updateTime", DateUtil.getYMDHMSTime(teamRequest.getUpdateTime()))
                .field("version", teamRequest.getVersion())
//                .field("orderInfo", BeanUtils.describe(OrderTransfer.transfer(orderRequest)))
                .field("orderInfo", BeanUtils.describe(orderRequest))
                .endObject();
//                .startObject("_all").field("analyzer","ik").field("search_analyzer","ik").endObject();

        return builder.toString();
    }
}
