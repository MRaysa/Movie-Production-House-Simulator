/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrewMembers;

import java.io.Serializable;
import java.time.LocalDate;

import mainpkg.User;

/**
 *
 * @author abdur
 */
public class Director extends User implements Serializable{
    
    public Director(int id, String name, String desig, LocalDate DOJ,String pass,String movieName) {
        super(id, name, desig, DOJ,pass,movieName);
    }
    
}
