package br.com.guilhermealvessilveira.escapingreferences.partiallycorrected;

import br.com.guilhermealvessilveira.escapingreferences.shared.CustomerReadOnly;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

public class Customer implements CustomerReadOnly {

    private String name;

    private LocalDate birthDate;

    public Customer(final String name, final LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Customer(final Customer other) {
        this.name = other.name;
        this.birthDate = other.birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Customer setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("birthDate=" + DateTimeFormatter.ISO_DATE.format(birthDate))
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(birthDate, customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }
}
