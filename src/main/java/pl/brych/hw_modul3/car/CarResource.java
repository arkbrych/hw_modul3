package pl.brych.hw_modul3.car;


import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import pl.brych.hw_modul3.controller.ApiController;
import pl.brych.hw_modul3.model.Car;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
public class CarResource extends RepresentationModel {

    private final Car car;

    public CarResource(final Car car) {
        this.car = car;
        final Integer id = car.getId();
        add(linkTo(ApiController.class).withRel("cars"));
        add(linkTo(ApiController.class).slash(id).withSelfRel());
    }
}
