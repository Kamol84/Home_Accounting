package pl.kamol84.homeaccounting.entity;


import pl.kamol84.homeaccounting.validator.IsAssigneToUserOrGroup;
import pl.kamol84.homeaccounting.validator.IsPeriodicExpenses;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@IsAssigneToUserOrGroup
@IsPeriodicExpenses
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private BigDecimal value;

    private boolean periodicExpenses;       //TODO: check if I need to define default value on false.

    private Integer dayOfMonth;

    @Past
    private LocalDate created;

    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Group group;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
