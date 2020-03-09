package com.springframework.msscbeerbreweryclient.web.client;

import com.springframework.msscbeerbreweryclient.web.model.BeerDTO;
import com.springframework.msscbeerbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired              //inject dependencies (Rest Template builder)
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDTO dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSavingBeer(){
        // given object
        BeerDTO beerDTO = BeerDTO.builder().beerName("New Beer").build();
        //URI
        URI uri = client.saveNewBeer(beerDTO);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer(){
        // given object
        BeerDTO beerDTO = BeerDTO.builder().beerName("The new Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById(){
        CustomerDTO customerDTO= client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }

    @Test
    void saveNewCustomer() {
        // given object
        CustomerDTO customerDTO = CustomerDTO.builder().name("New Customer").build();
        //URI
        URI uri = client.saveNewCustomer(customerDTO);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateCustomer() {
        // given object
        CustomerDTO customerDTO = CustomerDTO.builder().name("The new Customer").build();
        //URI
        client.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void deleteCustomer() { client.deleteCustomer(UUID.randomUUID()); }
}