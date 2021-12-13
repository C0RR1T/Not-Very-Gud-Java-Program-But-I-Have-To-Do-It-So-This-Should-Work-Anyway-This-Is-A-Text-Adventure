import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Verb {
    @JsonProperty()
    private Error errors;
    @JsonProperty()
    private ArrayList<String> synonyms;
    private List<String> nouns;
}



record Error(String verb, String object) {

}
