import java.util.ArrayList;
import java.util.List;

public class StoryNode {
    private String description;
    private List<String> choices;
    private List<StoryNode> nextNodes;
    private boolean isDeadEnd;
    private String deadEndMessage;

    public StoryNode(String description) {
        this.description = description;
        this.choices = new ArrayList<>();
        this.nextNodes = new ArrayList<>();
        this.isDeadEnd = false;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getChoices() {
        return choices;
    }

    public List<StoryNode> getNextNodes() {
        return nextNodes;
    }

    public void addChoice(String choiceDescription, StoryNode nextNode) {
        choices.add(choiceDescription);
        nextNodes.add(nextNode);
    }

    public void setDeadEnd(String message) {
        this.isDeadEnd = true;
        this.deadEndMessage = message;
    }

    public boolean isDeadEnd() {
        return isDeadEnd;
    }

    public String getDeadEndMessage() {
        return deadEndMessage;
    }
}
