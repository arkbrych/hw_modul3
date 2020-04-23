package pl.brych.hw_modul3.service;

import pl.brych.hw_modul3.car.CarResource;

import java.util.List;

public interface CarService {

  //  Optional<Car> getCarByIdService(Integer id);

    List<CarResource> getAllCarsService();

  //  List<Car> getCarsByColorService(String color);
}
