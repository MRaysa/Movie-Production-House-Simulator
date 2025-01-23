
package mainpkg;

import java.io.Serializable;
import java.util.ArrayList;


public class MovieProject implements Serializable{
    String movieName,movieType;
    
    Producer producer;

    public MovieProject(String movieName,String movieType,Producer producer) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.producer = producer;
    }



    public String getMovieName() {
        return movieName;
    }



    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "MovieProject{" + "movieName=" + movieName + ", movieType=" + movieType + ", Producer Name :" + producer.getName() + '}';
    }

    public int getTotalMember(){
        return this.getProducer().getCrewList().size();
    
    
    }

    public ArrayList<User> getCrewList(){
        return this.getProducer().getCrewList();
    }
    public void addCrewList(ArrayList<User> arr){
        this.getProducer().addCrew(arr);
    }
    
    
}
