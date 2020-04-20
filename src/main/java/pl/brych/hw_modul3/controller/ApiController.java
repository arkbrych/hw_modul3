package pl.brych.hw_modul3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.brych.hw_modul3.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class ApiController {

    private List<Car> carList;

    public ApiController() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1, "Fiat", "126p", "czerwony"));
        carList.add(new Car(2, "Polonez", "FSO", "niebieski"));
        carList.add(new Car(3, "Syrena", "105", "biały"));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId().equals(id)).findFirst();
        return first.map(car -> new ResponseEntity<>(car, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCarsByColor(@PathVariable String color) {
        List<Car> cars = carList.stream()
                .filter(car -> car.getColor().equals(color))
                .collect(Collectors.toList());
        if (cars.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cars);
        }
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        carList.add(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Car> modCar(@RequestBody Car newCar) {
        Optional<Car> first = carList.stream().filter(car -> car.getId().equals(newCar.getId())).findFirst();
        if (first.isPresent()) {
            carList.remove(first.get());
            carList.add(newCar);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modOneCarField(@RequestParam("color") String newColor, @PathVariable("id") Integer id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId().equals(id)).findFirst();
        if (first.isPresent()) {
            carList.get((int) id - 1).setColor(newColor);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Integer id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId().equals(id)).findFirst();
        if (first.isPresent()) {
            carList.remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
