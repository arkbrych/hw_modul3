package pl.brych.hw_modul3.service;

import org.springframework.stereotype.Service;
import pl.brych.hw_modul3.model.Car;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService {

    public CarServiceImp(){

    }

    @Override
    public Optional<Car> getCarById(long id) {
        return createListOfCars()
                .stream()
                .filter(car -> car.getCarId() == id)
                .findFirst();
    }

    @Override
    public List<Car> getAllCars() {
        return createListOfCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return null;
    }

    private List<Car> createListOfCars() {
    }
}
