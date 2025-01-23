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

/**
 *
 * @author abdur
 */
public class ProducerMettingScheduleReadWrite {
    public static ArrayList<Meeting>arr;
    public static File fileName;

    public ProducerMettingScheduleReadWrite(String Filename) {
        fileName = new File(Filename+"Meeting.bin");
        
    }
    
    
    public void writeObj(ArrayList<Meeting>obj){
        

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
            arr = (ArrayList<Meeting>) inputStream.readObject();
            
            // Do something with the read object
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public  ArrayList<Meeting> getArr() {
        if(!fileName.exists()){
            return null;
        }else{
            this.readObject();
            return arr;
        }
    }

    public void setArr(ArrayList<Meeting> arr) {
        this.arr = arr;
    }


}
