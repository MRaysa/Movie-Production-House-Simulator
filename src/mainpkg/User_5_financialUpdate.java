/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
/**
 * FXML Controller class
 *
 * @author abuzafor
 */
public class User_5_financialUpdate {
    private final SimpleIntegerProperty dailyIncome;
    private final SimpleStringProperty movieName;
    private final SimpleObjectProperty<LocalDate> date;

    public User_5_financialUpdate(int dailyIncome, String movieName, LocalDate date) {
        this.dailyIncome = new SimpleIntegerProperty(dailyIncome);
        this.movieName = new SimpleStringProperty(movieName);
        this.date = new SimpleObjectProperty<>(date);
    }

    public int getDailyIncome() {
        return dailyIncome.get();
    }

    public SimpleIntegerProperty dailyIncomeProperty() {
        return dailyIncome;
    }

    public void setDailyIncome(int dailyIncome) {
        this.dailyIncome.set(dailyIncome);
    }

    public String getMovieName() {
        return movieName.get();
    }

    public SimpleStringProperty movieNameProperty() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName.set(movieName);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }
}
