import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public record Room(
        @JsonProperty(required = true)
        String description,
        @JsonProperty(required = true)
        HashMap<String, Verb> verbs,
        @JsonProperty(required = true)
        String name) {
}
