package com.alibou.ecommerce.customer;

import com.alibou.ecommerce.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    private final CustomerMapper mapper;
    public Long createCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(String.format(
                        "Cannot update customer:: No customer found with provided ID: s%", request.id())));
        // to avoid overwrite an existing value with a null value
        mergeCustomer(customer, request);
        repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())) {
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())) {
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomerToCustomerResponse)
                .collect(Collectors.toList());
    }

    public boolean existsById(Long customerId) {
        return repository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse findById(Long customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomerToCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with id:: %s", customerId)));
    }

    public void deleteCustomer(Long customerId) {
        repository.deleteById(customerId);
    }
}
