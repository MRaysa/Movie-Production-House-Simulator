/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author abdur
 */
public class Report implements Serializable{
    String name;
    int id;
    String reportedName,reportedDesig;
    String reason;
    String description;
    public Report(String name, int id, String reportedName, String reportedDesig, String reason) {
        this.name = name;
        this.id = id;
        this.reportedName = reportedName;
        this.reportedDesig = reportedDesig;
        this.reason = reason;
        description = "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportedName() {
        return reportedName;
    }

    public void setReportedName(String reportedName) {
        this.reportedName = reportedName;
    }

    public String getReportedDesig() {
        return reportedDesig;
    }

    public void setReportedDesig(String reportedDesig) {
        this.reportedDesig = reportedDesig;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Report{" + "name=" + name + ", id=" + id + ", reportedName=" + reportedName + ", reportedDesig=" + reportedDesig + ", reason=" + reason + '}';
    }
    
}
