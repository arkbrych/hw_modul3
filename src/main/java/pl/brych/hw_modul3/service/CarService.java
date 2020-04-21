package pl.brych.hw_modul3.service;

import pl.brych.hw_modul3.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<Car> getCarById(long id);

    List<Car> getAllCars();

    List<Car> getCarsByColor(String color);
}
