package com.moviebooking.repositories;

import com.moviebooking.entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@DisplayName("CustomerRepositoryTest")
public class CustomerRepositoryTest {

    private CustomerRepository customerRepository;

    @BeforeEach
    void setup(){
        Map<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1",new Customer("1","CustomerA","customerA@gmail.com"));
        customerMap.put("2",new Customer("2","CustomerB","customerB@gmail.com"));
        customerMap.put("3",new Customer("3","CustomerC","customerC@gmail.com"));
        customerRepository = new CustomerRepository(customerMap);
    }

    @Test
    @DisplayName("getCustomerById method Should Return Customer Given Customer Id")
    public void getCustomerById_GivenCustomerId_ShouldReturnCustomer(){
        //Arrange
        Customer expectedCustomer = new Customer("3","CinemaC","customerC@gmail.com");
        //Act
        Customer actualCustomer = customerRepository.getCustomerById("3");
        //Assert
        Assertions.assertEquals(expectedCustomer,actualCustomer);
    }

    @Test
    @DisplayName("getCustomerById  method Should Return null Given Customer Id If Customer not found")
    public void getCustomerById_GivenCustomerId_ShouldReturnNull(){
        //Arrange
        String customerId = "4";
        //Act
        Customer actualCustomer = customerRepository.getCustomerById(customerId);
        //Assert
        Assertions.assertNull(actualCustomer);
    }

    @Test
    @DisplayName("saveCustomer method Should Save Customer")
    public void saveCustomer_ShouldSaveCustomer(){
        //Arrange
        Customer expectedCustomer = new Customer("4","CustomerD","customerD@gmail.com");
        //Act
        customerRepository.saveCustomer(expectedCustomer);

        //Assert
        Assertions.assertEquals(expectedCustomer,customerRepository.getCustomerById("4"));
    }

}
