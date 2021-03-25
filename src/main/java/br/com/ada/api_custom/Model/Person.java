package br.com.ada.api_custom.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Entity;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {


    private Long id;
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;

    @Override
    public String toString(){
        return ("\nname: " + this.getName() + "\n" +
                "height: " + this.getHeight() + "\n" +
                "mass: " + this.getMass() + "\n" +
                "hair_color: " + this.getHair_color() + "\n" +
                "skin_color: " + this.getSkin_color() + "\n" +
                "eye_color: " + this.getEye_color() + "\n" +
                "gender: " + this.getGender() + "\n");
    }
}
