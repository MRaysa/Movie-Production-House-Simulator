/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author abdur
 */
public class Aproval implements Serializable{
    String name,desig,comments,aplicationType,status;

    public Aproval(String name, String desig, String comments, String aplicationType) {
        this.name = name;
        this.desig = desig;
        this.comments = comments;
        this.aplicationType = aplicationType;
        this.status = "Pending";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAplicationType() {
        return aplicationType;
    }

    public void setAplicationType(String aplicationType) {
        this.aplicationType = aplicationType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aproval{" + "name=" + name + ", desig=" + desig + ", comments=" + comments + ", aplicationType=" + aplicationType + ", status=" + status + '}';
    }
    
}
