import java.util.HashMap;

public record Room(String description, HashMap<String, Verb> verbs) {
}
