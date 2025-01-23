package mainpkg;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CharacterDataHolder {
    private ObservableList<CharacterD> characterList;
    private static CharacterDataHolder instance;
    private ObservableList<CharacterD> characters;

    private CharacterDataHolder() {
        characters = FXCollections.observableArrayList();
        
    }

    public static CharacterDataHolder getInstance() {
        if (instance == null) {
            instance = new CharacterDataHolder();
        }
        return instance;
    }
    
    public ObservableList<CharacterD> getCharacterList() {
        return characterList;
    }

    public ObservableList<CharacterD> getCharacters() {
        return characters;
    }

    public ObservableList<String> getCharacterNames() {
        ObservableList<String> characterNames = FXCollections.observableArrayList();
        for (CharacterD character : characters) {
            characterNames.add(character.getCharacterName());
        }
        return characterNames;
    }
    

    public void addCharacter(CharacterD character) {
        characters.add(character);
    }
}
