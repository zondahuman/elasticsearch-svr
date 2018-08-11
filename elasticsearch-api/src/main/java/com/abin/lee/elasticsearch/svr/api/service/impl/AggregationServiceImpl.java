package com.abin.lee.elasticsearch.svr.api.service.impl;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 * Created by abin on 2018/8/11.
 * https://www.elastic.co/products/elasticsearch
 */
public class AggregationServiceImpl {


    public void test(){
//        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(
//                new HttpHost("localhost", 9200, "http")));
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.aggregation(AggregationBuilders.terms("top_10_states").field("state").size(10));
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("social-*");
//        searchRequest.source(searchSourceBuilder);
//        SearchResponse searchResponse = client.search(searchRequest);
    }




}
