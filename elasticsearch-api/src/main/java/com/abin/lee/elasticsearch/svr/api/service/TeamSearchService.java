package com.abin.lee.elasticsearch.svr.api.service;

import com.abin.lee.elasticsearch.svr.api.model.OrderInfo;
import com.abin.lee.elasticsearch.svr.api.model.TeamInfo;
import com.abin.lee.elasticsearch.svr.api.vo.request.OrderRequest;
import com.abin.lee.elasticsearch.svr.api.vo.request.SearchListVo;
import com.abin.lee.elasticsearch.svr.api.vo.request.SearchVo;
import com.abin.lee.elasticsearch.svr.api.vo.request.TeamRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/1/24 15:14.
 * elasticsearch-svr
 * com.abin.lee.elasticsearch.svr.api.service
 */
public interface TeamSearchService {


    Boolean createMap(TeamRequest teamRequest, OrderRequest orderRequest);

    Boolean createObject(TeamRequest teamRequest, OrderRequest orderRequest) throws Exception;

    Boolean createJson(TeamRequest teamRequest, OrderRequest orderRequest) throws Exception;

    List<Map<String, Object>> searchByKey(SearchVo searchVo);
    List<Map<String, Object>> searchByKeyList(SearchListVo searchListVo);
    List<Map<String, Object>> searchAll();

    List<Map<String, Object>> searchByKey(SearchVo searchVo, Integer pageSize, Integer pageNum);
    List<Map<String, Object>> searchScollByKey(SearchVo searchVo, Integer pageSize, Integer pageNum);



}
