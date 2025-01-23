
package CrewMembers;

import java.io.Serializable;
import java.time.LocalDate;

import mainpkg.User;

/**
 *
 * @author abdur
 */
public class CineMatoGrapher extends User implements Serializable{
    
    public CineMatoGrapher(int id, String name, String desig, LocalDate DOJ, String pass,String movieName) {
        super(id, name, desig, DOJ, pass,movieName);
    }
    



    
}
