package es.cresdev.apps.microservices.validation;

public interface ModelValidation<T> {

    boolean isValid(T model);

}
