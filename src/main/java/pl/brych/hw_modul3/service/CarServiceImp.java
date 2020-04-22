package pl.brych.hw_modul3.service;

import org.springframework.stereotype.Service;
import pl.brych.hw_modul3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    private List<Car> carList;

    public CarServiceImp(){
        this.carList = new ArrayList<>();
        carList.add(new Car(1, "Fiat", "126p", "czerwony"));
        carList.add(new Car(2, "Polonez", "FSO", "czerwony"));
        carList.add(new Car(3, "Syrena", "105", "biały"));
    }

    @Override
    public List<Car> getAllCarsService() {
        return carList;
    }

    @Override
    public Optional<Car> getCarByIdService(Integer id) {
        return carList
                .stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Car> getCarsByColorService(String color) {
        return carList
                .stream()
                .filter(car -> car.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
