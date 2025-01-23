/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author abdur
 */
public class ProducersBudgetMangeMentDataBase implements Serializable{
    public static ArrayList<BudgetManangeMent>arr;
    public static File fileName = new File("Budget.bin");
    
    
    
    public static void writeObj(ArrayList<BudgetManangeMent> obj){
        

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Write the object to the file
            outputStream.writeObject(obj);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void readObject(){
        if(!fileName.exists()){
            return;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            // Read the object from the file
            arr = (ArrayList<BudgetManangeMent>) inputStream.readObject();
            
            // Do something with the read object
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static ArrayList<BudgetManangeMent> getArr() {
        if(!fileName.exists()){
            return null;
        }else{
            ProducersBudgetMangeMentDataBase.readObject();
            return arr;
        }
    }


    
}
