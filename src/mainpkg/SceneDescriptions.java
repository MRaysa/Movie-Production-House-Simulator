package mainpkg;

import java.util.ArrayList;
import java.util.List;

public class SceneDescriptions {

    private List<String> sceneDescriptions;

    public SceneDescriptions(List<String> sceneDescriptions) {
        // Create a new ArrayList and add all elements from the provided list
        this.sceneDescriptions = new ArrayList<>(sceneDescriptions);
    }

    public List<String> getSceneDescriptions() {
        return sceneDescriptions;
    }

    public void setSceneDescriptions(List<String> sceneDescriptions) {
        this.sceneDescriptions = new ArrayList<>(sceneDescriptions);
    }

    @Override
    public String toString() {
        return "SceneDescriptions{" + "sceneDescriptions=" + sceneDescriptions + '}';
    }

    public void addSceneDescription(String description) {
        sceneDescriptions.add(description);
    }
}
