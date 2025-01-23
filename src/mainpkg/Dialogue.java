package mainpkg;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dialogue implements Serializable {
    private CharacterD character; // Assuming you have a reference to the Character
    private StringProperty dialogue;
    
    public Dialogue(CharacterD character, String dialogue) {
        this.character = character;
        this.dialogue = new SimpleStringProperty(dialogue);
    }
    // Getter for character
    public CharacterD getCharacter() {
        return character;
    }

    // Getter for dialogue property
    public String getDialogue() {
        return dialogue.get();
    }

    // Setter for dialogue property
    public void setDialogue(String dialogue) {
        this.dialogue.set(dialogue);
    }

    // Property getter for dialogue
    public StringProperty dialogueProperty() {
        return dialogue;
    }
}

