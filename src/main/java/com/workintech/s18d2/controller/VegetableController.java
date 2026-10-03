package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.PlantResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.validations.PlantValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getByPriceAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public PlantResponse<Vegetable> getById(@PathVariable Long id) {
        PlantValidation.checkId(id);
        return new PlantResponse<>("Vegetable found successfully", vegetableService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> searchByName(@PathVariable String name) {
        PlantValidation.checkName(name);
        return vegetableService.searchByName(name);
    }

    @PostMapping
    public PlantResponse<Vegetable> save(@RequestBody Vegetable vegetable) {
        PlantValidation.checkPlant(vegetable);
        return new PlantResponse<>("Vegetable saved successfully", vegetableService.save(vegetable));
    }

    @DeleteMapping("/{id}")
    public PlantResponse<Vegetable> delete(@PathVariable Long id) {
        PlantValidation.checkId(id);
        return new PlantResponse<>("Vegetable deleted successfully", vegetableService.delete(id));
    }
}
