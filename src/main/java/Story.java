import java.util.HashMap;

public record Story(String startRoom, HashMap<String, Room> rooms, HashMap<String, Verb> verbs, Room currentRoom, String description) {

}
