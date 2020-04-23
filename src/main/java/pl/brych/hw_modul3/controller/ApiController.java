package pl.brych.hw_modul3.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.brych.hw_modul3.car.CarResource;
import pl.brych.hw_modul3.service.CarServiceImp;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = "application/xml")
public class ApiController {

    private CarServiceImp carServiceImp;

    public ApiController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<CarResource>> getCars() {
        List<CarResource> allCars = carServiceImp.getAllCarsService();
        final CollectionModel<CarResource> resources = new CollectionModel<>(allCars);
//        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
//        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable Integer id) {
//        Link link = linkTo(ApiController.class).slash(id).withSelfRel();
//        Optional<Car> carById = carServiceImp.getCarByIdService(id);
//        if (carById.isPresent()){
//            EntityModel<Car> carResource = new EntityModel<>(carById.get(), link);
//            return ResponseEntity.ok(carResource);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/color/{color}")
//    public ResponseEntity<CollectionModel<Car>> getCarsByColor(@PathVariable String color) {
//
//        List<Car> cars = carServiceImp.getCarsByColorService(color);
//        cars.forEach(car -> car.add(linkTo(ApiController.class).slash(car.getId()).withSelfRel()));
//        Link link = linkTo(ApiController.class).slash(cars).withSelfRel();
//        CollectionModel<Car> carCollectionModel = new CollectionModel<>(cars, link);
//        if (cars.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(carCollectionModel);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Car> addCar(@RequestBody Car car) {
//        carServiceImp.getAllCarsService().add(car);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping
//    public ResponseEntity<Car> modCar(@RequestBody Car newCar) {
//        Optional<Car> first = carServiceImp.getCarByIdService(newCar.getId());
//        if (first.isPresent()) {
//            carServiceImp.getAllCarsService().remove(first.get());
//            carServiceImp.getAllCarsService().add(newCar);
//            return ResponseEntity.ok().build();
//        } else return ResponseEntity.notFound().build();
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<?> modOneCarField(@RequestParam("color") String newColor, @PathVariable("id") Integer id) {
//        Optional<Car> first = carServiceImp.getCarByIdService(id);
//        if (first.isPresent()) {
//            carServiceImp.getAllCarsService().get(id - 1).setColor(newColor);
//            return ResponseEntity.ok().build();
//        } else return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Car> deleteCar(@PathVariable Integer id) {
//        Optional<Car> first = carServiceImp.getCarByIdService(id);
//        if (first.isPresent()) {
//            carServiceImp.getAllCarsService().remove(first.get());
//            return ResponseEntity.ok(first.get());
//        } else return ResponseEntity.notFound().build();
//    }
}
