/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Producer extends User implements Serializable{
    ArrayList<User> crewList ;

    public Producer(int id, String name, String desig, LocalDate DOJ, String pass, String movieName) {
        super(id, name, desig, DOJ, pass, movieName);
    }



    public void addCrew(ArrayList<User> crewList) {
        this.crewList = crewList;
    }
    



    

    public ArrayList<User> getCrewList() {
        return crewList;
    }
    private void setMovieName(String newName){
        movieName = newName;
    }
    
}
