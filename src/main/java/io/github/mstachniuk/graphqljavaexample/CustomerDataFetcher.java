package io.github.mstachniuk.graphqljavaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.FieldDataFetcher;
import io.github.mstachniuk.graphqljavaexample.customer.CustomerService;

@Component
public class CustomerDataFetcher extends FieldDataFetcher {

    @Autowired
    private CustomerService customerService;

    public CustomerDataFetcher() {
        super("customers");
    }

    @Override
    public Object get(DataFetchingEnvironment environment) {
        String id = environment.getArgument("id");
        return customerService.getCustomerById(id);
    }
}
