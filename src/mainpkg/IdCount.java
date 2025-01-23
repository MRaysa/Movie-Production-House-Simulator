/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdur
 */
public class IdCount implements Serializable{
    File f = new File("Id.bin");
    int id = 100000;
//    ArrayList<Integer>arr=new ArrayList();
    int count;
    public void writeId(int id){
        FileOutputStream fos = null;
        DataOutputStream obj = null;
        
        try {
            
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                

            } else {
                
                fos = new FileOutputStream(f);
                
            }
            obj = new DataOutputStream(fos);
            obj.writeInt(id);
            
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
    public void readId(){
        count=0;
        FileInputStream fis = null;      
        DataInputStream ois = null;
        
        try {

            fis = new FileInputStream(f);
            ois = new DataInputStream(fis);
            int id;
            try{

                while(true){
                    
                    id = (int)ois.readInt();
//                    System.out.println(id );
//                    arr.add(id);
                    count+=1;
                    
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
     
        } catch (IOException ex) { } 

    }

    public int getId(){
        
        this.readId();
        if(count==0){
            this.writeId(id);
            return id;
            
        }else{
            id= id + count;
            this.writeId(id);
            return id;
        
        }
    }
    
    
}
