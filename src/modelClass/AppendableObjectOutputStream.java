/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Aysa
 */
public class AppendableObjectOutputStream extends ObjectOutputStream {
        
    public AppendableObjectOutputStream(OutputStream outs) throws IOException
    {
        super(outs);
    }
    
    @Override
    public void writeStreamHeader() throws IOException
    {
        
    }
    
}
