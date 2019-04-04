package pl.kamol84.homeaccounting.entity;


import pl.kamol84.homeaccounting.validator.IsAssigneToUserOrHousehold;
import pl.kamol84.homeaccounting.validator.IsPeriodicExpenses;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@IsAssigneToUserOrHousehold
@IsPeriodicExpenses
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin("0.01")
    private BigDecimal value;

    private boolean periodicExpenses = false;

    @Min(1)
    @Max(31)
    private Integer dayOfMonth;

    @Past
    private LocalDate created;

    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Household household;

    public Expense() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isPeriodicExpenses() {
        return periodicExpenses;
    }

    public void setPeriodicExpenses(boolean periodicExpenses) {
        this.periodicExpenses = periodicExpenses;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }
}
