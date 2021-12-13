import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.util.HashSet;
import java.util.Optional;

public class StoryTeller {
    public static StoryTeller INSTANCE = new StoryTeller();
    private HashSet<String> state = new HashSet<>();
    private Room currentRoom;
    private Story story;

    public StoryTeller() {
        var story = new ObjectMapper(new YAMLFactory()).readValue(new File(""), Story.class);
        this.story = story;
        this.currentRoom = story.rooms().get(story.startRoom());
    }

    public boolean isInState(String key) {
        return state.contains(key);
    }

    public void addToState(String key) {
        state.add(key);
    }

    public void changeRoom(String room) {
        this.currentRoom = Optional.ofNullable(this.story.rooms().get(room)).orElseThrow(() -> new IllegalArgumentException(String.format("Room \"%s\" doesn't exist", room)))
    }
}
