import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public record Story(@JsonProperty(required = true) String startRoom, @JsonProperty(required = true) HashMap<String, Room> rooms, @JsonProperty(required = true) HashMap<String, VerbDefault> verbs, Room currentRoom, @JsonProperty(required = true) String description) {

}
