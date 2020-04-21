package pl.brych.hw_modul3.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.brych.hw_modul3.model.Car;
import pl.brych.hw_modul3.service.CarServiceImp;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/cars")
public class ApiController {

    private CarServiceImp carServiceImp;

    public ApiController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(carServiceImp.getAllCarsService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable Integer id) {
        Link link = linkTo(ApiController.class).slash(id).withSelfRel();
        Optional<Car> first = carServiceImp.getCarByIdService(id);
        if (first.isPresent()){
            EntityModel<Car> carResource = new EntityModel<>(first.get(), link);
            return ResponseEntity.ok(carResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCarsByColor(@PathVariable String color) {
        List<Car> cars = carServiceImp.getCarsByColorService(color);
        if (cars.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cars);
        }
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        carServiceImp.getAllCarsService().add(car);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Car> modCar(@RequestBody Car newCar) {
        Optional<Car> first = carServiceImp.getCarByIdService(newCar.getId());
        if (first.isPresent()) {
            carServiceImp.getAllCarsService().remove(first.get());
            carServiceImp.getAllCarsService().add(newCar);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modOneCarField(@RequestParam("color") String newColor, @PathVariable("id") Integer id) {
        Optional<Car> first = carServiceImp.getCarByIdService(id);
        if (first.isPresent()) {
            carServiceImp.getAllCarsService().get(id - 1).setColor(newColor);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Integer id) {
        Optional<Car> first = carServiceImp.getCarByIdService(id);
        if (first.isPresent()) {
            carServiceImp.getAllCarsService().remove(first.get());
            return ResponseEntity.ok(first.get());
        } else return ResponseEntity.notFound().build();
    }
}
