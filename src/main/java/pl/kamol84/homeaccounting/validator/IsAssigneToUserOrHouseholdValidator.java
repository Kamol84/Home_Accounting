package pl.kamol84.homeaccounting.validator;

import pl.kamol84.homeaccounting.entity.Expense;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsAssigneToUserOrHouseholdValidator implements ConstraintValidator<IsAssigneToUserOrHousehold, Expense> {


    @Override
    public boolean isValid(Expense expense, ConstraintValidatorContext context) {

        if (expense.getUser() == null && expense.getHousehold() == null) {
            return false;
        } else if (expense.getUser() != null && expense.getHousehold() != null){
            return false;
        }

        return true;
    }

}
