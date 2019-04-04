package pl.kamol84.homeaccounting.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsAssigneToUserOrHouseholdValidator.class)
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAssigneToUserOrHousehold {

    String message() default "{pl.kamol84.homeaccounting.validator.IsAssigneToUserOrHousehold}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
