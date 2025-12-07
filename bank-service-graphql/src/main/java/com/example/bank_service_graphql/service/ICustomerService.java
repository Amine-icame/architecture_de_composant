package com.example.bank_service_graphql.service;

import com.example.bank_service_graphql.dtos.customer.*;
import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomByIdentity(String identity);
    AddCustomerResponse createCustomer(AddCustomerRequest addCustomerRequest);
    UpdateCustomerResponse updateCustomer(String identityRef, UpdateCustomerRequest updateCustomerRequest);
    String deleteCustomerByIdentityRef(String identityRef);
}