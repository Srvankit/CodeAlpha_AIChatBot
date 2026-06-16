public class SessionStats {

    private int totalMessages;

    private int learnedItems;

    public SessionStats() {

        totalMessages = 0;

        learnedItems = 0;
    }

    public void increaseMessages() {

        totalMessages++;
    }

    public void increaseLearned() {

        learnedItems++;
    }

    public int getTotalMessages() {

        return totalMessages;
    }

    public int getLearnedItems() {

        return learnedItems;
    }
}