// the sublcass of Scriptwriter Model Class
//contaiting the createCharacter method which is one of 8 Goals of the scriptwriter

package mainpkg;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CharacterD implements Serializable {
    private static final long serialVersionUID = -6162035976770830222L;

    private String characterName;
    private String characterType;
    private List<String> dialogues;

    public CharacterD(String characterName, String characterType) {
        this.characterName = characterName;
        this.characterType = characterType;
        this.dialogues = new ArrayList<>();
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterType() {
        return characterType;
    }

    public List<String> getDialogues() {
        return dialogues;
    }

    public void addDialogue(String dialogue) {
        dialogues.add(dialogue);
    }
    @Override
    public String toString() {
        return "Name: " + characterName + ", Type: " + characterType;
    }    
}



