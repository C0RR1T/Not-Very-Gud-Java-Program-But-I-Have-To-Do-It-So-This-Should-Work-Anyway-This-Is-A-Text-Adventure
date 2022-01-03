import java.util.ArrayList;

public record VerbDefault(Errors errors, ArrayList<String> synonyms) {
}

record Errors(String verb, String object) {

}
