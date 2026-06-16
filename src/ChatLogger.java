import java.io.FileWriter;
import java.time.LocalDateTime;

public class ChatLogger {

    public void save(String user, String bot) {

        try (FileWriter writer =
                     new FileWriter(
                             "data/chat_history.txt",
                             true)) {

            writer.write(
                    "\n[" +
                    LocalDateTime.now() +
                    "]\n");

            writer.write(
                    "You : " +
                    user + "\n");

            writer.write(
                    "Bot : " +
                    bot + "\n");

            writer.write(
                    "-------------------------\n");
        }

        catch (Exception e) {

            System.out.println(
                    "Unable to save chat history.");
        }
    }
}