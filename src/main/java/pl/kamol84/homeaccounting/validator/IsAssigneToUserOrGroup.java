package pl.kamol84.homeaccounting.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsAssigneToUserOrGroupValidator.class)
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAssigneToUserOrGroup {

    String message() default "{pl.kamol84.homeaccounting.validator.IsAssigneToUserOrGroup}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
