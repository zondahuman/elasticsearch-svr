package com.abin.lee.elasticsearch.svr.api.search;

import com.google.common.collect.Maps;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/6.
 */
@Component
public class ElasticTransportClient {

    private static final Logger logger = LoggerFactory.getLogger(ElasticTransportClient.class);



    private TransportClient client;

    @Value("${elasticsearch.host}")
    private String elasticSearchHost;

    @Value("${elasticsearch.port}")
    private int elasticSearchPort;


    public TransportClient getClient(){
        return this.client;
    }


    @PostConstruct
    private void init()  {
        if (elasticSearchHost == null || "".equals(elasticSearchHost)){
            throw new IllegalArgumentException(" elasticsearch host ["+elasticSearchHost+"] error");
        }


        try {
//           client = new PreBuiltTransportClient(Settings.EMPTY)
            Settings settings = Settings.builder()
                    .put("cluster.name", "elasticsearch")
                    .put("client.transport.sniff", true)
                    .build();
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticSearchHost), elasticSearchPort));
        } catch (UnknownHostException e) {
            logger.error("elasticsearch connect error!",e);
            System.exit(-1);
        }
    }

    @PreDestroy
    private void destroy(){
        if (client!=null){
            client.close();
        }
    }

    public String getElasticSearchHost() {
        return elasticSearchHost;
    }

    public void setElasticSearchHost(String elasticSearchHost) {
        this.elasticSearchHost = elasticSearchHost;
    }

    public int getElasticSearchPort() {
        return elasticSearchPort;
    }

    public void setElasticSearchPort(int elasticSearchPort) {
        this.elasticSearchPort = elasticSearchPort;
    }
}
