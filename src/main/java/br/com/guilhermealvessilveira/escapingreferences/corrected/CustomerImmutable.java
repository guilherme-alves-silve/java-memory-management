package br.com.guilhermealvessilveira.escapingreferences.corrected;

import br.com.guilhermealvessilveira.escapingreferences.shared.CustomerReadOnly;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

public class CustomerImmutable implements CustomerReadOnly {

    private final String name;

    private final LocalDate birthDate;

    public CustomerImmutable(final String name, final LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public CustomerImmutable withName(final String name) {
        return new CustomerImmutable(name, this.birthDate);
    }

    public CustomerImmutable withBirthDate(final LocalDate birthDate) {
        return new CustomerImmutable(this.name, birthDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerImmutable.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("birthDate=" + DateTimeFormatter.ISO_DATE.format(birthDate))
                .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerImmutable)) return false;
        final var customer = (CustomerImmutable) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(birthDate, customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }
}
