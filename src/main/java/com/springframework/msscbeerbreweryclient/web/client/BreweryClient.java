package com.springframework.msscbeerbreweryclient.web.client;

import com.springframework.msscbeerbreweryclient.web.model.BeerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    /*
     *      DATA MEMBERS
     */
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;
    private final RestTemplate restTemplate;

    /*
     *      CONSTRUCTOR
     */
    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /*
     *      METHODS
     */
    public BeerDTO getBeerById(UUID uuid){
        return restTemplate.getForObject(
                //building the URL
                apihost + BEER_PATH_V1 + uuid.toString(),
                BeerDTO.class
        );
    }

    public void setApiHost(String apihost) { this.apihost = apihost; }
}
