package sn.seydina.springvalidator.validator;

import jakarta.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Anneevalidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnneeValid {
    String message() default "{javax.validation.constraints.AnneeValid.message}";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

    int min() default 2000;
}
