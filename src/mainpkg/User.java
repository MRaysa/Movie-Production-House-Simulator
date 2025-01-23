
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author abdur
 */
public class User implements Serializable{
    protected int id;
    protected String name,movieName;
    protected String desig;
    protected LocalDate DOJ;
    protected String pass;
    


    public User(int id, String name, String desig, LocalDate DOJ,String pass, String movieName) {
        this.id = id;
        this.name = name;
        this.movieName = movieName;
        this.desig = desig;
        this.DOJ = DOJ;
        this.pass = pass;
    }

    public void setDOJ(LocalDate DOJ) {
        this.DOJ = DOJ;
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

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public LocalDate getDOJ() {
        return DOJ;
    }

    public void setDOj(LocalDate DOJ) {
        this.DOJ = DOJ;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", movieName=" + movieName + ", desig=" + desig + ", DOj=" + DOJ + ", pass=" + pass +'}';
    }




    public String getMovieName(){
        return movieName;
    }


    
}
