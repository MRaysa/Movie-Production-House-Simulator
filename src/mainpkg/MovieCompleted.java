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
public class MovieCompleted implements Serializable{
    String moviName ,movieType,aproval;
    String producerName,actorName,actressName;

    public MovieCompleted(String moviName, String movieType, String producerName, String actorName, String actressName) {
        this.moviName = moviName;
        this.movieType = movieType;
        this.producerName = producerName;
        this.actorName = actorName;
        this.actressName = actressName;
        this.aproval="Not Approved";
    }

    public String getAproval() {
        return aproval;
    }

    public void setAproval(String aproval) {
        this.aproval = aproval;
    }

    public String getMoviName() {
        return moviName;
    }

    public void setMoviName(String moviName) {
        this.moviName = moviName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActressName() {
        return actressName;
    }

    public void setActressName(String actressName) {
        this.actressName = actressName;
    }
    
    
    
    
}
