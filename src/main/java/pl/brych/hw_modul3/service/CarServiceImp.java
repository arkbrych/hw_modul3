package pl.brych.hw_modul3.service;

import org.springframework.stereotype.Service;
import pl.brych.hw_modul3.car.CarResource;
import pl.brych.hw_modul3.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private List<Car> carList;
    private List<CarResource> carResources;

    public CarServiceImp(){
        this.carResources = new ArrayList<>();
        carResources.add(new CarResource( new Car(1, "Fiat", "126p", "czerwony")));
        carResources.add(new CarResource(new Car(2, "Polonez", "FSO", "czerwony")));
        carResources.add(new CarResource(new Car(3, "Syrena", "105", "biały")));
    }

    @Override
    public List<CarResource> getAllCarsService() {
        return carResources;
    }

//    @Override
//    public Optional<Car> getCarByIdService(Integer id) {
//        return carList
//                .stream()
//                .filter(car -> car.getId().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public List<Car> getCarsByColorService(String color) {
//        return carList
//                .stream()
//                .filter(car -> car.getColor().equals(color))
//                .collect(Collectors.toList());
//    }

}
