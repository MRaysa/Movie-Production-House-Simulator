package mainpkg;

public class Actor {
    private String name;
    private String gender;

    public Actor(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    // No need for setter methods if you don't intend to change these values after initialization

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", gender=" + gender + '}';
    }
}
