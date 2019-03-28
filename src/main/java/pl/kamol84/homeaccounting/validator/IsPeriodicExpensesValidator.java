package pl.kamol84.homeaccounting.validator;

import pl.kamol84.homeaccounting.entity.Expense;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPeriodicExpensesValidator implements ConstraintValidator<IsPeriodicExpenses, Expense> {


    @Override
    public boolean isValid(Expense expense, ConstraintValidatorContext context) {

        if (expense.isPeriodicExpenses() == false && expense.getDayOfMonth() == null) {
            return true;
        } else if (expense.isPeriodicExpenses() == true && expense.getDayOfMonth()!= null && 0 < expense.getDayOfMonth() && expense.getDayOfMonth() <= 31) {
            return true;
        }
        return false;
    }
}
