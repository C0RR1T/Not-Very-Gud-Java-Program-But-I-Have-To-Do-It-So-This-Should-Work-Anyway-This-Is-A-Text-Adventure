import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record Noun(String noun, ArrayList<Action> nouns) {
}

record Action(@JsonProperty IfState ifState, @JsonProperty Message message, @JsonProperty AddState state) {

}

record IfState(String key) {


    public boolean check() {
        return StoryTeller.INSTANCE.isInState(this.key);
    }
}

record Message(String message) {

    public void printMessage() {
        System.out.println(message);
    }
}

record ChangeRoom(String room) {
    public void changeRoom() {
        StoryTeller.INSTANCE.
    }
}

record AddState(String state) {
    public void addState() {
        StoryTeller.INSTANCE.addToState(this.state);
    }
}
