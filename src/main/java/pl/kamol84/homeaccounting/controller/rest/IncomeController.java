package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Income;
import pl.kamol84.homeaccounting.repository.IncomeRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/income", produces = MediaType.APPLICATION_JSON_VALUE)
public class IncomeController {

    @Autowired
    IncomeRepository incomeRepository;

    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody @Valid Income income, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        incomeRepository.save(income);
        return new ResponseEntity(income, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }


    @PutMapping
    public ResponseEntity<Income> updateIncome(@RequestBody @Valid Income income, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        incomeRepository.save(income);
        return new ResponseEntity(income, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Income> deleteIncome(@PathVariable Long id) {
        if (!incomeRepository.findById(id).isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        incomeRepository.deleteById(id);
        return new ResponseEntity(incomeRepository.findById(id), new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }
}
