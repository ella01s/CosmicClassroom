package functionality.score;

import java.util.HashMap;

public class IncorrectAnswersRecord {
    HashMap<String, Integer> answerRecord = new HashMap<>();

    public static void main(String[] args) {

    }

    public void updateAnswerRecord(String topic){
        if (!answerRecord.containsKey(topic)) {
            // If the topic is not in the record, add it with a value of 0
            answerRecord.put(topic, 0);
        }
    }
}
