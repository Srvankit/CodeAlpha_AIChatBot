import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class ChatBot {

    private KnowledgeBase knowledgeBase;

    public ChatBot() {

        knowledgeBase = new KnowledgeBase();
    }

    public String getResponse(String input) {

        input = input.toLowerCase().trim();

        // HELP

        if (input.equals("help")) {

            return """
AVAILABLE COMMANDS

hello

time

date

joke

calculate 25+15

learn question=answer

bye
""";
        }

        // LEARN VALIDATION

        if (input.equals("learn")) {

            return "Usage: learn question=answer";
        }

        // LEARN NEW KNOWLEDGE

        if (input.startsWith("learn ")) {

            try {

                String data = input.substring(6).trim();

                String[] parts = data.split("=", 2);

                if (parts.length != 2) {

                    return "Usage: learn question=answer";
                }

                boolean saved = knowledgeBase.saveNewKnowledge(
                        parts[0].trim(),
                        parts[1].trim());

                if (saved) {

                    return "New knowledge saved successfully.";
                }

                return "Unable to save.";

            }

            catch (Exception e) {

                return "Invalid format.";
            }
        }

        // TIME

        if (input.equals("time")) {

            return "Current time: "
                    + LocalTime.now()
                    .withSecond(0)
                    .withNano(0);
        }

        // DATE

        if (input.equals("date")) {

            return "Today's date: "
                    + LocalDate.now();
        }

        // JOKE

        if (input.equals("joke")) {

            String[] jokes = {

                "Why do programmers prefer dark mode? Because light attracts bugs.",

                "Why did Java break up with C++? Too many pointers.",

                "A SQL query walks into a bar and says: Can I join you?"
            };

            Random random = new Random();

            return jokes[random.nextInt(jokes.length)];
        }

        // CALCULATOR VALIDATION

        if (input.equals("calculate")) {

            return "Usage: calculate 25+15";
        }

        // CALCULATOR

        if (input.startsWith("calculate ")) {

            String expression = input
                    .replace("calculate", "")
                    .trim();

            Calculator calculator =
                    new Calculator();

            return calculator.solve(expression);
        }

        // KNOWLEDGE BASE

        String response =
                knowledgeBase.findResponse(input);

        if (response != null) {

            return response;
        }

        return """
Sorry, I don't understand that.

Type 'help' to see available commands.
""";
    }
}