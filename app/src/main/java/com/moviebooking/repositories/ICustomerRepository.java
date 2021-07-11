package com.moviebooking.repositories;

import com.moviebooking.entities.Customer;

public interface ICustomerRepository {
    Customer getCustomerById(String id);
    void saveCustomer(Customer customer);
}
