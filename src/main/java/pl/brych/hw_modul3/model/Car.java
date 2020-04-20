package pl.brych.hw_modul3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private long id;
    private String mark;
    private String model;
    private String color;
}
