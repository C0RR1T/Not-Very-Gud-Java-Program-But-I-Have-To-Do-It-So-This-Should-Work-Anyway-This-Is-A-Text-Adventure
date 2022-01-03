import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class StoryTeller {
    private ArrayList<String> state = new ArrayList<>();
    private Room currentRoom;
    private Story story;
    private Console console;

    private StoryTeller() {

    }

    public void readStory(String path) throws IOException {
        var story = new ObjectMapper(new YAMLFactory()).readValue(new File(path), Story.class);
        this.story = story;
        this.currentRoom = story.rooms().get(story.startRoom());
        this.console = new Console();
    }

    public void startStory() {
        console.say(story.description());
        console.say(currentRoom.name());
        console.say(currentRoom.description());

        while (true) {
            var inputString = console.input();
            checkInput(inputString.split(" "));
        }
    }

    public void checkInput(String[] input) {
        var verbString = input[0];
        String object = null;
        try {
            object = input[1];
        } catch (IndexOutOfBoundsException ignored) {
            // Why Java I don't understand. Why throw exception men (
        }
        Verb verb = null;

        if (currentRoom.verbs().containsKey(verbString)) {
            verb = currentRoom.verbs().get(verbString);
        } else {
            var synonym = story.verbs().keySet().stream()
                    .filter(v -> currentRoom.verbs().containsKey(v))
                    .map(v -> story.verbs().get(v))
                    .filter(v -> v.synonyms().contains(verbString))
                    .findFirst();

            if (synonym.isPresent()) {
                verb = synonym.get();
            }
        }

        if (verb == null) {
            if (story.verbs().containsKey(verbString) && !verbString.equals("default")) {
                console.say(story.verbs().get("default").errors().verb());
            }
            return;
        }

        if (!verb.nouns().containsKey(object) && verb.nouns().size() > 0) {
            console.say(story.verbs().get(verbString).errors().object().replace("{}", object));
            return;
        }

        var actions = verb.nouns().get(input[1]);

        for (Action action : actions) {
            boolean ifState = false;
            if (action.ifState() != null) {
                if (!isInState(action.ifState())) {
                    continue;
                } else {
                    ifState = true;
                }
            }

            if (action.message() != null)
                console.say(action.message());


            if (action.addState() != null)
                addToState(action.addState());


            if (action.room() != null)
                changeRoom(action.room());


            if (ifState)
                break;
        }

    }


    public boolean isInState(String key) {
        return state.contains(key);
    }

    public void addToState(String key) {
        state.add(key);
    }

    public void changeRoom(String room) {
        this.currentRoom = Optional.ofNullable(this
                        .story
                        .rooms()
                        .get(room))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Room \"%s\" doesn't exist", room)));
    }
}
