package com.example.bank_service_graphql.service;


import lombok.AllArgsConstructor;
import com.example.bank_service_graphql.dao.CustomerRepository;
import com.example.bank_service_graphql.dtos.customer.*;
import com.example.bank_service_graphql.service.exception.BusinessException;
import com.example.bank_service_graphql.service.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(c -> modelMapper.map(c, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomByIdentity(String identity) {
        return customerRepository.findByIdentityRef(identity)
                .map(c -> modelMapper.map(c, CustomerDto.class))
                .orElseThrow(() -> new BusinessException(String.format("No customer with identity %s found", identity)));
    }

    @Override
    public AddCustomerResponse createCustomer(AddCustomerRequest dto) {
        if (customerRepository.findByIdentityRef(dto.getIdentityRef()).isPresent()) {
            throw new BusinessException(String.format("Customer with identity %s already exists", dto.getIdentityRef()));
        }
        if (customerRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new BusinessException(String.format("Username %s already used", dto.getUsername()));
        }

        Customer customer = modelMapper.map(dto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);

        AddCustomerResponse response = modelMapper.map(savedCustomer, AddCustomerResponse.class);
        response.setMessage("Customer created successfully");
        return response;
    }

    @Override
    public UpdateCustomerResponse updateCustomer(String identityRef, UpdateCustomerRequest dto) {
        Customer customer = customerRepository.findByIdentityRef(identityRef)
                .orElseThrow(() -> new BusinessException(String.format("No customer with identity %s found", identityRef)));

        customer.setFirstname(dto.getFirstname());
        customer.setLastname(dto.getLastname());
        customer.setUsername(dto.getUsername());

        Customer saved = customerRepository.save(customer);
        UpdateCustomerResponse response = modelMapper.map(saved, UpdateCustomerResponse.class);
        response.setMessage("Customer updated successfully");
        return response;
    }

    @Override
    public String deleteCustomerByIdentityRef(String identityRef) {
        Customer customer = customerRepository.findByIdentityRef(identityRef)
                .orElseThrow(() -> new BusinessException(String.format("No customer with identity %s found", identityRef)));
        customerRepository.delete(customer);
        return String.format("Customer with identity %s deleted", identityRef);
    }
}
