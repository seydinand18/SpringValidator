package sn.seydina.springvalidator.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class AnneevalidatorTest {

    final AnneeValidator validator = new AnneeValidator();

    @Mock
    ConstraintValidatorContext context;

    @ParameterizedTest
    @ValueSource(ints = {2000, 2022,2005, 2024})
    void doitRetournerTrueSiAnneeEstValide(int annee) {

        AnneeValid anneeValid = creationAnnotation(2000);
        validator.initialize(anneeValid);

        assertTrue(validator.isValid(annee, context));

    }

    @ParameterizedTest
    @ValueSource(ints = {1999, 2025, 1999, 1990})
    void doitRetournerFalseSiAnneeEstInvalide(int annee) {

        AnneeValid anneeValid = creationAnnotation(2000);
        validator.initialize(anneeValid);

        assertFalse(validator.isValid(annee, context));

    }

    private AnneeValid creationAnnotation(int min) {

        return new AnneeValid(){
            @Override
            public Class<? extends Annotation> annotationType() {
                return AnneeValid.class;
            }

            @Override
            public String message() {
                return "{javax.validation.constraints.AnneeValid.message}";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<?>[] payload() {
                return new Class[0];
            }

            @Override
            public int min() {
                return min;
            }
        };
    }
}
