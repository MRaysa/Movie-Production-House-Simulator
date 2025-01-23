
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class Director extends User implements Serializable{


    public Director(int id, String name, String desig, LocalDate DOJ, String pass, String movieName) {
        super(id, name, desig, DOJ, pass, movieName);
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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public LocalDate getDOJ() {
        return DOJ;
    }

    public void setDOJ(LocalDate DOJ) {
        this.DOJ = DOJ;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

 //   public LocalDate getDOB() {
 //       return DOB;
 //   }

 //   public void setDOB(LocalDate DOB) {
 //       this.DOB = DOB;
//    }

    @Override
    public String toString() {
        return "Director{" + '}';
    }
    




   // Methods

    public void scheduleFilmDates() {
        // Implementation to schedule film dates
    }

    public void manageProductionResources() {
        // Implementation to manage production resources
    }

    public void reviewAndEditScript(String newScriptText) {
        // Implementation to review and edit the script
     //   this.script.editScript(newScriptText);
    }


    public void coordinateEquipmentWithCinematographer() {
        // Perform coordination logic with selected equipments and visualized script
        // For example:
        //System.out.println("Coordination with Cinematographer:");
        //System.out.println("Selected Equipments: " + selectedEquipments);
        //System.out.println("Visualized Script: " + visualizedScript);
    }


    public void requestProductsFromProjectManager(List<RequestedProduct> products) {
        // Assuming there is a ProjectManager class with a method to handle product requests
        //ProjectManager projectManager = new ProjectManager();
        
        // Assuming ProjectManager has a method to handle product requests
        //projectManager.handleProductRequests(products);

        // Add any additional logic or update UI as needed
    }

    // Getters and Setters (Omitted for brevity)
}    
