import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ChatBot bot = new ChatBot();

        ChatLogger logger = new ChatLogger();

        SessionStats stats = new SessionStats();

        UI.showBanner();

        UI.showCommands();

        while (true) {

            System.out.print("You > ");

            String input = sc.nextLine().trim();

            stats.increaseMessages();

            String response = bot.getResponse(input);

            System.out.println("Bot > " + response);

            logger.save(input, response);

            if (input.toLowerCase().startsWith("learn ")) {

                stats.increaseLearned();
            }

            if (input.equalsIgnoreCase("bye")) {

                break;
            }

            System.out.println();
        }

        System.out.println();

        System.out.println("===================================================");

        System.out.println("SESSION SUMMARY");

        System.out.println();

        System.out.println(
                "Total messages : "
                + stats.getTotalMessages());

        System.out.println(
                "Knowledge learned : "
                + stats.getLearnedItems());

        System.out.println();

        UI.showExit();

        System.out.println("===================================================");

        sc.close();
    }
}