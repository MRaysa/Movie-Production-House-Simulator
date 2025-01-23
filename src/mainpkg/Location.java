
package mainpkg;

import java.time.LocalDate;
import java.util.ArrayList;

public class Location {
    // Attributes
    private String name;
    private String description;
    private LocalDate dataPicker;
    
    // Getters and Setters (Omitted for brevity)

    public Location(String name, String description, LocalDate dataPicker) {
        this.name = name;
        this.description = description;
        this.dataPicker = dataPicker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescriptionTextArea(String descriptionTextArea) {
        this.description = descriptionTextArea;
    }

    public LocalDate getDataPicker() {
        return dataPicker;
    }

    public void setDataPicker(LocalDate dataPicker) {
        this.dataPicker = dataPicker;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", descriptionTextArea=" + description + ", dataPicker=" + dataPicker + '}';
    }
}

