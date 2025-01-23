
package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdur
 */
public class Validation {
    
 


    public int idVerification(int data) {
        String test = String.valueOf(data);
        return test.length();
    }
    public boolean idDuplicate(ArrayList<Integer> arr,int data){
        for(int i : arr){
            if(i==data){
                return false;
            }
        
        }
        return true;
    
    }
        



    
}
