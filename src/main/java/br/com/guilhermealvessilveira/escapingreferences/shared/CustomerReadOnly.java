package br.com.guilhermealvessilveira.escapingreferences.shared;

import java.time.LocalDate;

public interface CustomerReadOnly {

    String getName();

    LocalDate getBirthDate();
}
