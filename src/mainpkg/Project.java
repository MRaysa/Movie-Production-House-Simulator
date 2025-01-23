/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Hp
 */
import java.util.List;

public class Project {
    private String title;
    private List<String> genres;
    private int budget;

    public Project(String title, List<String> genres, int budget) {
        this.title = title;
        this.genres = genres;
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getBudget() {
        return budget;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}

