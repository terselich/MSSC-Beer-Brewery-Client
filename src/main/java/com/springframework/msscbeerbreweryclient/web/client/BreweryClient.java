package com.springframework.msscbeerbreweryclient.web.client;

import com.springframework.msscbeerbreweryclient.web.model.BeerDTO;
import com.springframework.msscbeerbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    /*
     *      DATA MEMBERS
     */
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
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

    //  ----->   BEER

    public BeerDTO getBeerById(UUID uuid){
        return restTemplate.getForObject(
                //building the URL
                apihost + BEER_PATH_V1 + uuid.toString(),
                BeerDTO.class
        );
    }

    public URI saveNewBeer(BeerDTO beerDTO){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDTO);
    }

    public void updateBeer(UUID uuid, BeerDTO beerDTO){
        restTemplate.put(apihost + BEER_PATH_V1 + uuid.toString(), beerDTO);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH_V1 + uuid.toString());
    }

    //  ----->   CUSTOMER

    public CustomerDTO getCustomerById(UUID uuid){
        return restTemplate.getForObject(
                // build from the URI
                apihost + CUSTOMER_PATH_V1 + uuid.toString(),
                CustomerDTO.class
        );
    }

    public URI saveNewCustomer(CustomerDTO customerDTO){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDTO);
    }

    public void updateCustomer(UUID uuid, CustomerDTO customerDTO){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid.toString(), customerDTO);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + uuid.toString());
    }

    public void setApiHost(String apihost) { this.apihost = apihost; }
}
