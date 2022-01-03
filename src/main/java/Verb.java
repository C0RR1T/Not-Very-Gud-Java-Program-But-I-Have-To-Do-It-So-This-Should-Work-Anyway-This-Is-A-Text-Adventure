import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

public record Verb(
        @JsonProperty
        Map<String, ArrayList<Action>> nouns,
        @JsonProperty
        ArrayList<String> synonyms,
        @JsonProperty
        Errors errors
) {

}

record Errors(String verb, String object) {

}


