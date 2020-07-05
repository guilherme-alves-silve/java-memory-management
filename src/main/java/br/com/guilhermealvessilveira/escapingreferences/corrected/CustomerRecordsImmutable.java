package br.com.guilhermealvessilveira.escapingreferences.corrected;

import br.com.guilhermealvessilveira.escapingreferences.shared.CustomerReadOnly;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecordsImmutable {

    private final Map<String, CustomerImmutable> records;

    public CustomerRecordsImmutable() {
        this.records = new HashMap<>();
    }

    public void addCustomer(CustomerImmutable customer) {
        this.records.put(customer.getName(), customer);
    }

    public void addCustomers(CustomerImmutable... customers) {
        for (final var customer : customers) {
            this.records.put(customer.getName(), customer);
        }
    }

    public CustomerImmutable getCustomerByName(final String name) {
        return this.records.get(name);
    }

    public Map<String, CustomerReadOnly> getCustomers() {
        return Collections.unmodifiableMap(this.records);
    }
}

