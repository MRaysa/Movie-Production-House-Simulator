
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
public class AprovalReadWrite {
    public static ArrayList<Aproval>arr;
    public static File fileName;

    public AprovalReadWrite(String Filename) {
        fileName = new File(Filename+"Aproval.bin");
    }
    
    
    public void writeObj(ArrayList<Aproval>obj){
        

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
            arr = (ArrayList<Aproval>) inputStream.readObject();
            
            // Do something with the read object
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public  ArrayList<Aproval> getArr() {
        if(!fileName.exists()){
            return null;
        }else{
            this.readObject();
            return arr;
        }
    }

    public void setArr(ArrayList<Aproval> arr) {
        this.arr = arr;
    }
    

    
    
}
