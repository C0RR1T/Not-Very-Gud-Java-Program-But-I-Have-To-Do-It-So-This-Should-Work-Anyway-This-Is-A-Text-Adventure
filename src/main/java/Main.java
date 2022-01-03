import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var storyTeller = StoryTeller.getStoryTeller();
        try {
            storyTeller.readStory(args[0]);
        } catch (IndexOutOfBoundsException ex) {
          System.err.println("Please provide a path to the story");
          System.exit(1);
        } catch (IOException ex) {
          System.err.printf("Couldn't open specified path %s: %s%n", args[0], ex.getMessage());
          System.exit(1);
        }
        storyTeller.startStory();
    }
}
