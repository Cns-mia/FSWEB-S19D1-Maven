package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.validations.PlantValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getByPriceAsc() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable Long id) {
        PlantValidation.checkId(id);
        return fruitService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name) {
        PlantValidation.checkName(name);
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit) {
        PlantValidation.checkPlant(fruit);
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id) {
        PlantValidation.checkId(id);
        return fruitService.delete(id);
    }
}
