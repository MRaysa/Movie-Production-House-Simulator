
package mainpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectReadWrite{

    ArrayList<User> userArr = new ArrayList();
    ArrayList<MovieProject> projectArr = new ArrayList();

    
    public void writeUserObject(User user) {

        FileOutputStream fos = null;
        ObjectOutputStream obj = null;
        File f=null;
        try {
            f = new File("User.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                obj = new AppendableObjectStream(fos);

            } else {
                
                fos = new FileOutputStream(f);
                obj = new ObjectOutputStream(fos);
            }
            
            obj.writeObject(user);
            
        }catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (obj != null) {
                    obj.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }


    public void readUserObject(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        User us = null;

        try {

            File f= new File("User.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (true) {
                us = (User) ois.readObject();
                userArr.add(us);

            }

        } catch (Exception ex) {}
    }




    



   public void writeProjectObject(MovieProject user){

        FileOutputStream fos = null;
        ObjectOutputStream obj = null;
        File f=null;
        try {
            f = new File("Projects.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                obj = new AppendableObjectStream(fos);

            } else {
                
                fos = new FileOutputStream(f);
                obj = new ObjectOutputStream(fos);
            }
            
            obj.writeObject(user);
            obj.close();
        }catch (IOException ex) {
            
        } finally {
            try {
                if (obj != null) {
                    obj.close();
                }
            } catch (IOException ex) {
                
            }
        }
   }
      public void reWriteProjectObject(MovieProject user){

        FileOutputStream fos = null;
        ObjectOutputStream obj = null;
        File f=null;
        try {
            f = new File("Projects.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f);
                obj = new AppendableObjectStream(fos);

            } else {
                
                fos = new FileOutputStream(f);
                obj = new ObjectOutputStream(fos);
            }
            
            obj.writeObject(user);
            obj.close();
        }catch (IOException ex) {
            
        } finally {
            try {
                if (obj != null) {
                    obj.close();
                }
            } catch (IOException ex) {
                
            }
        }
   }
        

    public void readProjectObject(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        MovieProject us = null;

        try {

            File f= new File("Projects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (true) {
                us = (MovieProject) ois.readObject();
                projectArr.add(us);

            }

        } catch (Exception ex) {}
        
    }
    
    
    
    public  ArrayList<User> getUserArr() {
        this.readUserObject();

        return userArr;
   }
   
    public  ArrayList<MovieProject> getProjectArr() {
        this.readProjectObject();

        return projectArr;
   }
   

}

