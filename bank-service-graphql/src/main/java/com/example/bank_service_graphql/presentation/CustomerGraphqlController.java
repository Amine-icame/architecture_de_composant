package com.example.bank_service_graphql.presentation;

import lombok.AllArgsConstructor;
import com.example.bank_service_graphql.dtos.customer.*;
import com.example.bank_service_graphql.service.ICustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphqlController {
    private final ICustomerService customerService;

    @QueryMapping // Doit matcher le nom dans type Query du schéma
    public List<CustomerDto> customers() {
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public CustomerDto customerByIdentity(@Argument String identity) {
        return customerService.getCustomByIdentity(identity);
    }

    @MutationMapping // Doit matcher le nom dans type Mutation
    public AddCustomerResponse createCustomer(@Argument("dto") AddCustomerRequest dto) {
        return customerService.createCustomer(dto);
    }
}
