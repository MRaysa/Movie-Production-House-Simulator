
package mainpkg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author abdur
 */
public class AppendableObjectStream extends ObjectOutputStream implements Serializable{
        public AppendableObjectStream(OutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException{ 
        
        }
    
}
