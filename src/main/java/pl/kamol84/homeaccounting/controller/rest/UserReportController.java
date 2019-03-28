package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kamol84.homeaccounting.entity.Expense;
import pl.kamol84.homeaccounting.entity.Income;
import pl.kamol84.homeaccounting.exceptions.DoesntFoundException;
import pl.kamol84.homeaccounting.service.UserReportService;

import java.util.List;

@RestController
@RequestMapping(path = "/userreport", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserReportController {

    @Autowired
    UserReportService userReportService;

    @GetMapping("/income/{id}/{year}/{month}")
    public List<Income> findUserIncomes(@PathVariable Long id, @PathVariable Integer year, @PathVariable Integer month){
        return userReportService.userIncomeFromYearMonth(id, year, month);
    }

    @GetMapping("/expense/{id}/{year}/{month}")
    public List<Expense> findUserExpense(@PathVariable Long id, @PathVariable Integer year, @PathVariable Integer month){
        return userReportService.userExpenseFromYearMonth(id, year, month);
   }

    @GetMapping("/expensesum/{id}/{year}/{month}")
    public String sumUserExpenseFromMonth(@PathVariable Long id, @PathVariable Integer year, @PathVariable Integer month){
        try {
            return userReportService.sumUserExpenseFromMonth(id, year, month).toString();
        } catch (NullPointerException e) {
            throw new DoesntFoundException("brak danych do wyświetlenia");
        }
    }

    @GetMapping("/incomesum/{id}/{year}/{month}")
    public String sumUserIncomeFromMonth(@PathVariable Long id, @PathVariable Integer year, @PathVariable Integer month){
        try {
            return userReportService.sumUserIncomeFromMonth(id, year, month).toString();
        } catch (NullPointerException e) {
            throw new DoesntFoundException("brak danych do wyświetlenia");
        }
    }


}
