import java.io.*;
import java.util.*;

public class KnowledgeBase {

    private HashMap<String, String> responses;

    public KnowledgeBase() {

        responses = new HashMap<>();

        loadResponses();
    }

    private void loadResponses() {

        File file = new File("data/responses.txt");

        try (Scanner reader = new Scanner(file)) {

            while (reader.hasNextLine()) {

                String line = reader.nextLine().trim();

                if (line.isEmpty()) {

                    continue;
                }

                if (line.contains("=")) {

                    String[] parts =
                            line.split("=", 2);

                    responses.put(
                            parts[0].toLowerCase().trim(),
                            parts[1].trim());
                }
            }
        }

        catch (Exception e) {

            System.out.println(
                    "Unable to load responses.");
        }
    }

    public String findResponse(String input) {

        input = input.toLowerCase();

        for (String key : responses.keySet()) {

            if (input.contains(key)) {

                return responses.get(key);
            }
        }

        return null;
    }

    public boolean saveNewKnowledge(
            String question,
            String answer) {

        try {

            question =
                    question.toLowerCase().trim();

            answer =
                    answer.trim();

            // Prevent duplicates

            if (responses.containsKey(question)) {

                return true;
            }

            try (FileWriter writer =
                         new FileWriter(
                                 "data/responses.txt",
                                 true)) {

                writer.write(
                        "\n" +
                        question +
                        "=" +
                        answer);
            }

            responses.put(
                    question,
                    answer);

            return true;
        }

        catch (Exception e) {

            return false;
        }
    }
}