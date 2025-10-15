package hexagonal.application.domain.person;

import hexagonal.application.exceptions.ValidationException;

public record Name(String value) {

    public Name {
        if (value == null) {
            throw new ValidationException("Invalid value for Name");
        }
    }
}
