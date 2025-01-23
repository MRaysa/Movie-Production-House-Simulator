
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

public class Scriptwriter extends User implements Serializable {

    public Scriptwriter(int id, String name, String desig, LocalDate DOJ, String pass, String movieName) {
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

  //  public LocalDate getDOB() {
   //     return DOB;
   // }

   // public void setDOB(LocalDate DOB) {
   //     this.DOB = DOB;
   // }

    @Override
    public String toString() {
        return "Scriptwriter{" + '}';
    }




    public void maintainScriptFormat() {
        // Implementation for maintaining script format
        // This method is void, update it based on your specific logic
    }

    // Getters and setters for the attributes


}
