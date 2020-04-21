package pl.brych.hw_modul3.service;

import pl.brych.hw_modul3.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<Car> getCarByIdService(Integer id);

    List<Car> getAllCarsService();

    List<Car> getCarsByColorService(String color);
}
