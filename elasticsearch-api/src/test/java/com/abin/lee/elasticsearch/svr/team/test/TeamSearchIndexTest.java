
package com.abin.lee.elasticsearch.svr.team.test;

import com.abin.lee.elasticsearch.svr.api.util.BusinessRandom;
import com.abin.lee.elasticsearch.svr.api.vo.request.OrderRequest;
import com.abin.lee.elasticsearch.svr.common.util.DateUtil;
import com.abin.lee.elasticsearch.svr.common.util.HttpClientUtil;
import com.abin.lee.elasticsearch.svr.common.util.JsonUtil;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2018/1/24 17:42.
 * elasticsearch-svr
 * com.abin.lee.elasticsearch.svr.api.test
 */
public class TeamSearchIndexTest {
    private static final String httpMapURL = "http://localhost:8080/team/indexMap";
    private static final String httpObjectURL = "http://localhost:8080/team/indexObject";
    private static final String httpJsonURL = "http://localhost:8080/team/indexJson";

    @Test
    public void testCreateIndex() {
        try {
            CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            String id = (int) (Math.random() * 1000000) + "";
            nvps.add(new BasicNameValuePair("id", id));
            nvps.add(new BasicNameValuePair("teamName", BusinessRandom.findBusiness(3)));
            nvps.add(new BasicNameValuePair("teamPrice", RandomUtils.nextDouble(1, 1000) + ""));
            nvps.add(new BasicNameValuePair("field1", "二狗"));
            nvps.add(new BasicNameValuePair("field2", "狗蛋"));
            nvps.add(new BasicNameValuePair("createTime", DateUtil.getYMDHMSTime()));
            nvps.add(new BasicNameValuePair("updateTime", DateUtil.getYMDHMSTime()));
            String version = (int) (Math.random() * 100) + "";
            nvps.add(new BasicNameValuePair("version", version));
            nvps.add(new BasicNameValuePair("orderInfo", JsonUtil.toJson(createOrderRequest())));

            HttpPost httpPost = new HttpPost(httpMapURL);
//            httpPost.setHeader("Cookie", getCookie());
//            httpPost.setHeader("Cookie", "JSESSIONID=7588C522A6900BFD581AA18FDA64D347");

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            System.out.println("Executing request: " + httpPost.getRequestLine());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void testCreateObject() {
        try {
            CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            String id = (int) (Math.random() * 1000000) + "";
            nvps.add(new BasicNameValuePair("id", id));
            nvps.add(new BasicNameValuePair("teamName", BusinessRandom.findBusiness(3)));
            nvps.add(new BasicNameValuePair("teamPrice", RandomUtils.nextDouble(1, 1000) + ""));
            nvps.add(new BasicNameValuePair("field1", "二狗"));
            nvps.add(new BasicNameValuePair("field2", "狗蛋"));
            nvps.add(new BasicNameValuePair("createTime", DateUtil.getYMDHMSTime()));
            nvps.add(new BasicNameValuePair("updateTime", DateUtil.getYMDHMSTime()));
            String version = (int) (Math.random() * 100) + "";
            nvps.add(new BasicNameValuePair("version", version));
            nvps.add(new BasicNameValuePair("orderInfo", JsonUtil.toJson(createOrderRequest())));

            HttpPost httpPost = new HttpPost(httpObjectURL);
//            httpPost.setHeader("Cookie", getCookie());
//            httpPost.setHeader("Cookie", "JSESSIONID=7588C522A6900BFD581AA18FDA64D347");

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            System.out.println("Executing request: " + httpPost.getRequestLine());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void testCreateObjectAll() {

        try {
            CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            String id = (int) (Math.random() * 1000000) + "";
            nvps.add(new BasicNameValuePair("id", id));
            nvps.add(new BasicNameValuePair("teamName", BusinessRandom.findBusiness(3)));
            nvps.add(new BasicNameValuePair("teamPrice", RandomUtils.nextDouble(1, 1000) + ""));
            nvps.add(new BasicNameValuePair("field1", "二狗"));
            nvps.add(new BasicNameValuePair("field2", "狗蛋"));
            nvps.add(new BasicNameValuePair("createTime", DateUtil.getYMDHMSTime()));
            nvps.add(new BasicNameValuePair("updateTime", DateUtil.getYMDHMSTime()));
            String version = (int) (Math.random() * 100) + "";
            nvps.add(new BasicNameValuePair("version", version));
            nvps.add(new BasicNameValuePair("orderInfo", JsonUtil.toJson(createOrderRequest())));
            HttpPost httpPost = new HttpPost(httpObjectURL);
//            httpPost.setHeader("Cookie", getCookie());
//            httpPost.setHeader("Cookie", "JSESSIONID=7588C522A6900BFD581AA18FDA64D347");

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            System.out.println("Executing request: " + httpPost.getRequestLine());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static OrderRequest createOrderRequest(){
        OrderRequest orderRequest = new OrderRequest();
        Integer id = (int) (Math.random() * 1000000);
        Integer teamId = (int) (Math.random() * 1000000) ;
        orderRequest.setId(id);
        orderRequest.setTeamId(teamId);
        orderRequest.setVersion(0);
        orderRequest.setOrderPrice(BigDecimal.valueOf(RandomUtils.nextDouble(1, 1000)));
        orderRequest.setOrderName(BusinessRandom.findBusiness(3));
        orderRequest.setCreateTime(DateUtil.getYMDHMSTime());
        orderRequest.setUpdateTime(DateUtil.getYMDHMSTime());
        return orderRequest;
    }


}
