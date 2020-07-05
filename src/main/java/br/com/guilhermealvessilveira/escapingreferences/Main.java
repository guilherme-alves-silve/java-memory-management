package br.com.guilhermealvessilveira.escapingreferences;

import br.com.guilhermealvessilveira.escapingreferences.corrected.CustomerImmutable;
import br.com.guilhermealvessilveira.escapingreferences.corrected.CustomerRecordsImmutable;
import br.com.guilhermealvessilveira.escapingreferences.partiallycorrected.Customer;
import br.com.guilhermealvessilveira.escapingreferences.partiallycorrected.CustomerRecords;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        partiallyCorrectedEscapingReferences();

        System.out.println();

        correctedEscapingReferences();
    }

    private static void partiallyCorrectedEscapingReferences() {

        System.out.println("*** partiallyCorrectedEscapingReferences *** \n");

        final var records = new CustomerRecords();
        records.addCustomers(
                new Customer("John", LocalDate.of(1990, Month.DECEMBER, 13)),
                new Customer("Simon", LocalDate.of(1955, Month.APRIL, 1)),
                new Customer("Miriam", LocalDate.of(1920, Month.JULY, 29))
        );

        records.getCustomers().forEach((name, customer) -> {
            System.out.println(name + ": " + customer);
            //Doesn't compile because a CustomerReadOnly reference is being returned
            //customer.setName("HU3")
            //        .setBirthDate(LocalDate.now());
            //But you can modify if you cast to Customer
            //final var c = (Customer) customer;
            //c.setName("HU3")
            //.setBirthDate(LocalDate.now());
        });

        System.out.println("*******************************");

        records.getCustomers().forEach((name, customer) -> System.out.println(name + ": " + customer));

        System.out.println("*******************************");

        final var john = records.getCustomerByName("John");
        System.out.println(john);
    }

    private static void correctedEscapingReferences() {

        System.out.println("*** correctedEscapingReferences *** \n");

        final var records = new CustomerRecordsImmutable();
        records.addCustomers(
                new CustomerImmutable("John", LocalDate.of(1990, Month.DECEMBER, 13)),
                new CustomerImmutable("Simon", LocalDate.of(1955, Month.APRIL, 1)),
                new CustomerImmutable("Miriam", LocalDate.of(1920, Month.JULY, 29))
        );

        records.getCustomers().forEach((name, customer) -> {
            System.out.println(name + ": " + customer + " - " + customer.hashCode());
            final var immutable = (CustomerImmutable) customer;
            final var trying = immutable.withName("Trying to modify")
                    .withBirthDate(LocalDate.now());
            System.out.println(name + ":" + trying + " - " + trying.hashCode());
        });

        System.out.println("*******************************");

        records.getCustomers().forEach((name, customer) -> System.out.println(name + ": " + customer + " - " + customer.hashCode()));

        System.out.println("*******************************");

        final var john = records.getCustomerByName("John");
        System.out.println(john + " - " + john.hashCode());
    }
}
