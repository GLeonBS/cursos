package br.com.leon.cursos.modules.curso.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Status {
    ACTIVE("The course is active"),
    IN_CONSTRUCTION("The course is in construction"),
    INACTIVE("The course is inactive");

    private final String description;
}
