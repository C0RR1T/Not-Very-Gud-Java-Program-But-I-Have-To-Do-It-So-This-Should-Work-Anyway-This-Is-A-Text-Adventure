import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record Room(
        @JsonProperty(required = true)
        String description,
        @JsonProperty(required = true)
        Map<String, Map<String, List<Action>>> verbs,
        @JsonProperty(required = true)
        String name) {
}
