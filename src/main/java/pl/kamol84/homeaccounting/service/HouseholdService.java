package pl.kamol84.homeaccounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamol84.homeaccounting.entity.Household;
import pl.kamol84.homeaccounting.exceptions.BadRequestException;
import pl.kamol84.homeaccounting.exceptions.NotFoundException;
import pl.kamol84.homeaccounting.repository.HouseholdRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HouseholdService {

    private final HouseholdRepository householdRepository;
    private final Validator validator;

    @Autowired
    public HouseholdService(HouseholdRepository householdRepository, Validator validator) {
        this.householdRepository = householdRepository;
        this.validator = validator;
    }

    public Household save(Household household) {
        Set<ConstraintViolation<Household>> violations = validator.validate(household);
        if (!violations.isEmpty()) {
            throw new BadRequestException("wprowadzono niepoprawne dane");
        }
        householdRepository.save(household);
        return household;
    }

    public List<Household> getHousehold() {
        return householdRepository.findAll();
    }

    public Household getHouseholdById(Long id) {
        Optional<Household> household = householdRepository.findById(id);
        if(!household.isPresent()){
            throw new NotFoundException("Nie znaleziono grupy");
        }
        return household.get();
    }

    public void delete(Long id){
        householdRepository.deleteById(id);
    }

}
