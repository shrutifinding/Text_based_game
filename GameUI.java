import java.util.Scanner;

public class GameUI {
    private Scanner scanner = new Scanner(System.in);

    public void displayNode(StoryNode node) {
        System.out.println(node.getDescription());
        if (node.isDeadEnd()) {
            System.out.println(node.getDeadEndMessage());
        } else {
            for (int i = 0; i < node.getChoices().size(); i++) {
                System.out.println((i + 1) + ": " + node.getChoices().get(i));
            }
        }
    }

    public int getUserInput(int numberOfChoices) {
        System.out.print("Enter the number of your choice: ");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > numberOfChoices) {
            System.out.print("Invalid choice. Enter a number between 1 and " + numberOfChoices + ": ");
            choice = scanner.nextInt();
        }
        return choice - 1;
    }

    public boolean askToRestart() {
        System.out.print("Do you want to start the story again? (yes/no): ");
        scanner.nextLine();  // consume the newline character left by nextInt()
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("yes");
    }
}
