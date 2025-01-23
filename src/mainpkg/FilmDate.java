package mainpkg;

import java.time.LocalDate;

public class FilmDate {

    LocalDate date;
    String shift;

    public FilmDate(LocalDate date, String shift) {
        this.date = date;
        this.shift = shift;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "FilmDate{" + "date=" + date + ", shift=" + shift + '}';
    }

}
