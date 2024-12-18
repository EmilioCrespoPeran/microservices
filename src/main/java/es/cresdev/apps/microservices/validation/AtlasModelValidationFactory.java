package es.cresdev.apps.microservices.validation;

import es.cresdev.apps.microservices.exception.factory.ModelValidationNotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtlasModelValidationFactory {

    @Autowired
    private List<ModelValidation> modelValidations;

    public <T> ModelValidation<T> buildModelValidation(Class<T> model) throws ModelValidationNotImplementedException {
        return findModelValidation(model.getClass().getName());
    }

    private ModelValidation findModelValidation(String modelName) throws ModelValidationNotImplementedException {
        return modelValidations.stream()
                .filter(m -> getClass().getGenericSuperclass().getClass().getName().equals(modelName))
                .findFirst()
                .orElseThrow(() -> new ModelValidationNotImplementedException(modelName));
    }

}
