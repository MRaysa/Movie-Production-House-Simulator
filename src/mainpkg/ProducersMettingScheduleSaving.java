/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author abdur
 */
public class ProducersMettingScheduleSaving {
    File f;
    String str;
    public ProducersMettingScheduleSaving(String name) {
        f = new File(name+"MettingSchedule.txt");
        str="";
    }
    public void writeFile(String str) throws IOException{
        FileWriter fw;
        if (f.exists()){ fw = new FileWriter(f,true);}
        else{fw = new FileWriter(f);}
        fw.write(str+"\n");
        fw.close();
    
    
    }
    public void readFile(){
        if(!f.exists()){
            return;
        }
        Scanner sc=null;
        String str2=null;
        try{
            sc = new Scanner(f);
            while(sc.hasNextLine()){
                str2 = sc.nextLine();
                str+=str2+"\n";
            
            
            }
        
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public String getStr(){
        this.readFile();
        return str;
    
    }
       
}
    
    

