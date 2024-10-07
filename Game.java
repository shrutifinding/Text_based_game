public class Game {
    private StoryNode startNode;
    private StoryNode currentNode;
    private GameUI gameUI;

    public Game() {
        this.gameUI = new GameUI();
        setupStory();
    }

    private void setupStory() {
        // Create story nodes
        StoryNode start = new StoryNode("You wake up in a dark forest with no memory of how you got there. You see a path leading north and another leading east.");
        StoryNode northPath = new StoryNode("You follow the north path and come across a serene lake. A boat is tied to a dock.");
        StoryNode eastPath = new StoryNode("You follow the east path and encounter a small village. The villagers seem friendly but wary of strangers.");
        
        StoryNode lakeBoat = new StoryNode("You take the boat and row to the center of the lake, where you find a mysterious island.");
        StoryNode lakeShore = new StoryNode("You decide to walk along the shore of the lake and find a hidden cave.");
        
        StoryNode villageStay = new StoryNode("You decide to stay in the village for the night. The villagers tell you about an ancient legend.");
        StoryNode villageExplore = new StoryNode("You explore the village and find a hidden passage leading to an underground tunnel.");
        
        StoryNode islandExplore = new StoryNode("On the island, you find an old temple with ancient inscriptions.");
        StoryNode islandReturn = new StoryNode("You decide to return to the shore and continue your journey.");
        
        StoryNode caveEnter = new StoryNode("You enter the cave and discover a hidden treasure guarded by a giant spider.");
        StoryNode caveLeave = new StoryNode("You decide to leave the cave and continue walking along the shore.");
        
        StoryNode legendSearch = new StoryNode("You decide to investigate the legend. It leads you to a haunted forest.");
        StoryNode legendIgnore = new StoryNode("You ignore the legend and decide to rest. The next morning, you continue your journey.");
        
        StoryNode passageEnter = new StoryNode("You enter the passage and find yourself in an underground city.");
        StoryNode passageLeave = new StoryNode("You decide to leave the passage and return to the village.");
        
        StoryNode templeExplore = new StoryNode("You explore the temple and discover a portal to another world.");
        StoryNode templeLeave = new StoryNode("You decide to leave the temple and return to the boat.");

        // Add choices to the story nodes
        start.addChoice("Take the north path", northPath);
        start.addChoice("Take the east path", eastPath);
        
        northPath.addChoice("Take the boat to the island", lakeBoat);
        northPath.addChoice("Walk along the shore", lakeShore);
        
        eastPath.addChoice("Stay in the village", villageStay);
        eastPath.addChoice("Explore the village", villageExplore);
        
        lakeBoat.addChoice("Explore the island", islandExplore);
        lakeBoat.addChoice("Return to the shore", islandReturn);
        
        lakeShore.addChoice("Enter the cave", caveEnter);
        lakeShore.addChoice("Continue walking along the shore", caveLeave);
        
        villageStay.addChoice("Investigate the legend", legendSearch);
        villageStay.addChoice("Ignore the legend", legendIgnore);
        
        villageExplore.addChoice("Enter the passage", passageEnter);
        villageExplore.addChoice("Leave the passage", passageLeave);
        
        islandExplore.addChoice("Explore the temple", templeExplore);
        islandExplore.addChoice("Return to the boat", islandReturn);
        
        // Set dead ends with messages
        caveEnter.setDeadEnd("The giant spider attacks you. You have met a terrible fate.");
        legendSearch.setDeadEnd("The haunted forest is too dangerous. You cannot proceed.");
        passageEnter.setDeadEnd("The underground city is deserted and eerie. You decide to leave.");
        templeExplore.setDeadEnd("The portal takes you to an unknown place. You are lost forever.");

        // Set the start node
        this.startNode = start;
        this.currentNode = start;
    }

    public void play() {
        boolean playing = true;
        while (playing) {
            gameUI.displayNode(currentNode);
            if (currentNode.isDeadEnd()) {
                playing = gameUI.askToRestart();
                if (playing) {
                    currentNode = startNode;
                } else {
                    break;
                }
            } else if (currentNode.getChoices().isEmpty()) {
                playing = false;
            } else {
                int choice = gameUI.getUserInput(currentNode.getChoices().size());
                currentNode = currentNode.getNextNodes().get(choice);
            }
        }
        System.out.println("Thank you for playing!");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
