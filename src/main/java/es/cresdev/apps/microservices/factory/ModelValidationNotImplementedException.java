package es.cresdev.apps.microservices.factory;

public class ModelValidationNotImplementedException extends Exception {

    public ModelValidationNotImplementedException(String name) {
        super(String.format("Model validation '%s' not implemented", name));
    }
}
