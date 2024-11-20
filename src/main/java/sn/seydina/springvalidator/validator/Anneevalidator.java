package sn.seydina.springvalidator.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.Year;
import static java.util.Objects.isNull;

public class Anneevalidator implements ConstraintValidator<AnneeValid, Integer> {

    private int anneeMin;

    @Override
    public void initialize(AnneeValid constraintAnnotation) {
        this.anneeMin = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if(isNull(value)) return false;

        return value >= anneeMin && value <= Year.now().getValue();

    }
}
