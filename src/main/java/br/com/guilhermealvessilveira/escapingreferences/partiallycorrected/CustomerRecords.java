package br.com.guilhermealvessilveira.escapingreferences.partiallycorrected;

import br.com.guilhermealvessilveira.escapingreferences.shared.CustomerReadOnly;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {

    private final Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        this.records.put(customer.getName(), customer);
    }

    public void addCustomers(Customer... customers) {
        for (final var customer : customers) {
            this.records.put(customer.getName(), customer);
        }
    }

    public CustomerReadOnly getCustomerByName(final String name) {
        return new Customer(this.records.get(name));
    }

    public Map<String, CustomerReadOnly> getCustomers() {
        return Collections.unmodifiableMap(this.records);
    }
}

