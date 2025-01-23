/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import mainpkg.MovieProject;
import mainpkg.readWriteObject;

/**
 *
 * @author Aysa
 */
public class ProductReadWrite {
    
    public static ArrayList<Item>arr;
    public static File fileName = new File("ItemFile.bin");
    public static void writeObj(ArrayList<Item>obj){
        

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
            arr = (ArrayList<Item>) inputStream.readObject();
            
            // Do something with the read object
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static ArrayList<Item> getArr() {
        if(!fileName.exists()){
            return null;
        }else{
            ProductReadWrite.readObject();
            return arr;
        }
    }

    public static void setArr(ArrayList<Item> arr) {
        ProductReadWrite.arr = arr;
    }
    



    
}
