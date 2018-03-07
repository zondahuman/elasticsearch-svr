package com.abin.lee.elasticsearch.svr.api.controller;

import com.abin.lee.elasticsearch.svr.api.model.OrderInfo;
import com.abin.lee.elasticsearch.svr.api.service.TeamSearchService;
import com.abin.lee.elasticsearch.svr.api.vo.request.OrderRequest;
import com.abin.lee.elasticsearch.svr.api.vo.request.SearchListVo;
import com.abin.lee.elasticsearch.svr.api.vo.request.SearchVo;
import com.abin.lee.elasticsearch.svr.api.vo.request.TeamRequest;
import com.abin.lee.elasticsearch.svr.common.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/1/23 19:12.
 * elasticsearch-svr
 * com.abin.lee.elasticsearch.svr.api.controller
 * elasticsearch 两个表冗余
 * http://blog.csdn.net/sanzhongguren/article/details/76092596
 */
@Slf4j
@RestController
@RequestMapping("team")
public class TeamSearchController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeamSearchService teamSearchService;


    @RequestMapping(value = "/indexMap", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Boolean indexMap(@ModelAttribute("teamRequest") TeamRequest teamRequest) {
        boolean flag = Boolean.FALSE;
        try {
            OrderRequest orderRequest = JsonUtil.decodeJson(teamRequest.getOrderInfo(), new TypeReference<OrderRequest>() {
            });
            flag = this.teamSearchService.createMap(teamRequest, orderRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "/indexObject", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Boolean indexObject(@ModelAttribute("teamRequest") TeamRequest teamRequest) {
        boolean flag = Boolean.FALSE;
        try {
             OrderRequest orderRequest = JsonUtil.decodeJson(teamRequest.getOrderInfo(), new TypeReference<OrderRequest>() {
            });
            flag = this.teamSearchService.createObject(teamRequest, orderRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "/indexJson", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Boolean indexJson(@ModelAttribute("teamRequest") TeamRequest teamRequest) {
        boolean flag = Boolean.FALSE;
        try {
            OrderRequest orderRequest = JsonUtil.decodeJson(teamRequest.getOrderInfo(), new TypeReference<OrderRequest>() {
            });
            flag = this.teamSearchService.createJson(teamRequest, orderRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "/searchByKey", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Map<String, Object>> searchByKey(@ModelAttribute("searchVo") SearchVo searchVo) {
        List<Map<String, Object>> result = null;
        try {
            result = this.teamSearchService.searchByKey(searchVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/searchPageByKey", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Map<String, Object>> searchPageByKey(String key, String value, Integer pageSize, Integer pageNum) {
        List<Map<String, Object>> result = null;
        try {
            SearchVo searchVo = new SearchVo();
            searchVo.setKey(key);
            searchVo.setValue(value);
            result = this.teamSearchService.searchByKey(searchVo, pageSize, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/searchScollByKey", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Map<String, Object>> searchScollByKey(String key, String value, Integer pageSize, Integer pageNum) {
        List<Map<String, Object>> result = null;
        try {
            SearchVo searchVo = new SearchVo();
            searchVo.setKey(key);
            searchVo.setValue(value);
            result = this.teamSearchService.searchScollByKey(searchVo, pageSize, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/searchByKeyList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Map<String, Object>> searchByKeyList(@ModelAttribute("searchListVoe") SearchListVo searchListVoe) {
        List<Map<String, Object>> result = null;
        try {
            result = this.teamSearchService.searchByKeyList(searchListVoe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/searchAll", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Map<String, Object>> searchAll() {
        List<Map<String, Object>> result = null;
        try {
            result = this.teamSearchService.searchAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
