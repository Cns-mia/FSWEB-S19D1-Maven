package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Plant;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class PlantValidation {

    public static void checkId(Long id) {
        if (id == null || id < 0) {
            throw new PlantException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkPlant(Plant plant) {
        if (plant == null || plant.getName() == null || plant.getName().isBlank()
                || plant.getPrice() == null || plant.getPrice() < 0) {
            throw new PlantException("Plant data is missing or not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new PlantException("Name can not be empty", HttpStatus.BAD_REQUEST);
        }
    }
}
