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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abdur
 */
public class ProducerSpendOfProjectReadWrite {
    public static ArrayList<Spends>arr;
    public static File fileName;

    public ProducerSpendOfProjectReadWrite(String Filename) {
        fileName = new File(Filename+"Spends.bin");
        
    }
    
    
    public void writeObj(ArrayList<Spends>obj){
        

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                // Write the object to the file
                outputStream.writeObject(obj);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    public  void readObject(){
        if(!fileName.exists()){
            return;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            // Read the object from the file
            arr = (ArrayList<Spends>) inputStream.readObject();
            
            // Do something with the read object
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public  ArrayList<Spends> getArr() {
        if(!fileName.exists()){
            return null;
        }else{
            this.readObject();
            return arr;
        }
    }

    public void setArr(ArrayList<Spends> arr) {
        this.arr = arr;
    }
    
}
