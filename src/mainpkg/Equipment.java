
package mainpkg;

import java.io.Serializable;

public class Equipment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Equipment{" + "name=" + name + '}';
    }
    
}
