/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelClass;

/**
 *
 * @author abuzafor
 */
import java.io.Serializable;
import java.time.LocalDate;

public class CrewRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String crewName;
    private String role;
    private LocalDate requestDate;

    public CrewRequest(String crewName, String role, LocalDate requestDate) {
        this.crewName = crewName;
        this.role = role;
        this.requestDate = requestDate;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
