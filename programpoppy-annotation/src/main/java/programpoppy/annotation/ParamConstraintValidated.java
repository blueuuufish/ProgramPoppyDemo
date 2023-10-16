package programpoppy.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import programpoppy.annotation.AutoIdempotent;

import java.util.Arrays;
import java.util.List;

public class ParamConstraintValidated implements ConstraintValidator<AutoIdempotent, Object> {
    private List<String> paramValues;
    @Override
    public void initialize(AutoIdempotent constraintAnnotation) {
        paramValues = Arrays.asList(constraintAnnotation.paramValues());
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return paramValues.contains(o);
    }
}
