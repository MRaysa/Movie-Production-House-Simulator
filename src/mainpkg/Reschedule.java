/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author abdur
 */
public class Reschedule implements Serializable{
    int id;
    String name,comments;
    LocalDate oldDate,newDate;

    public Reschedule(int id,String name, String comments, LocalDate oldDate, LocalDate newDate) {
        this.id = id;

        this.name = name;
        this.comments = comments;
        this.oldDate = oldDate;
        this.newDate = newDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getOldDate() {
        return oldDate;
    }

    public void setOldDate(LocalDate oldDate) {
        this.oldDate = oldDate;
    }

    public LocalDate getNewDate() {
        return newDate;
    }

    public void setNewDate(LocalDate newDate) {
        this.newDate = newDate;
    }

    @Override
    public String toString() {
        return "Reschedule{" + "id=" + id  + ", name=" + name + ", comments=" + comments + ", oldDate=" + oldDate + ", newDate=" + newDate + '}';
    }

    

    

    
    
}
