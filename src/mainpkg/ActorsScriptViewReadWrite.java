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
public class ActorsScriptViewReadWrite {
    String fileName;
    File f;
    String str="";
    public ActorsScriptViewReadWrite(String fileName) {
        this.fileName = fileName;
        f = new File(this.fileName+"Script.txt");
    }
    public void writeText(String Txt) throws IOException{
        FileWriter fw=null;
        if(f.exists()){
            fw = new FileWriter(f,true);
        }else{
            fw = new FileWriter(f);
        }
        fw.write(Txt+"\n");
        fw.close();

    }
    public void readText(){
        if(!f.exists()){
            return;
        }
        try{
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String temp = sc.nextLine();
                str+=(temp+"\n");
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public String getStr(){
        this.readText();
        return str;
    }
    
    
}
