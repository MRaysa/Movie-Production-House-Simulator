
package mainpkg;

/**
 *
 * @author abdur
 */

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
public class readWriteObject {

    public static ArrayList<MovieProject>arr;
    public static File fileName = new File("ProjectjectData.bin");
    public static void writeObj(ArrayList<MovieProject>obj){
        

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
            arr = (ArrayList<MovieProject>) inputStream.readObject();
            
            // Do something with the read object
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static ArrayList<MovieProject> getArr() {
        if(!fileName.exists()){
            return null;
        }else{
            readWriteObject.readObject();
            return arr;
        }
    }

    public static void setArr(ArrayList<MovieProject> arr) {
        readWriteObject.arr = arr;
    }
    




}
    

