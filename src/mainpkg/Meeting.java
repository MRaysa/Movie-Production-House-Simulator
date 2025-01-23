/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author abdur
 */
public class Meeting implements Serializable{
    String name;
    LocalDate schDate;
    String meetingType,platform,time;
    int id;

    public Meeting( String name,Integer id, LocalDate schDate,String time, String meetingType, String platform) {
        
        this.name = name;
        this.schDate = schDate;
        this.meetingType = meetingType;
        this.platform = platform;
        this.id = id;
        this.time = time;
        
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSchDate() {
        return schDate;
    }

    public void setSchDate(LocalDate schDate) {
        this.schDate = schDate;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Metting ( " + "Name = " + name + ", Id = "+id +", Metting Type= " +meetingType+", platform= "+platform+", Date= "+schDate+" )";
    }
    
    
}
