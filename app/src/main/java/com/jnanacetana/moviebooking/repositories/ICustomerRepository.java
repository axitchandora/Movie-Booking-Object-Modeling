package com.jnanacetana.moviebooking.repositories;

import com.jnanacetana.moviebooking.entities.Customer;

public interface ICustomerRepository {
    Customer getCustomerById(String id);
    void saveCustomer(Customer customer);
}
