package pl.brych.hw_modul3.model;

import lombok.Data;

@Data
public class Car {

    private Integer id;
    private String mark;
    private String model;
    private String color;

    public Car(Integer id, String mark, String model, String color) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }
}
