package records.incorrectAnswersRecords.lessonRecords;

import functionality.LessonController;
import lessons.chapter01.DirectionCosinesLesson02;
import lessons.chapter01.SimpleRotationLesson01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompletedLessonsTracker {
    private Map<String, Boolean> completedLessons;

    public CompletedLessonsTracker() {
        completedLessons = new HashMap<>();
    }

    public static void main(String[] args) {
        CompletedLessonsTracker tracker = new CompletedLessonsTracker();
        List<String> allLessonNames = Arrays.asList("SimpleRotation01", "DirectionCosines02");
        // Initialize all lessons as incomplete
        for (String lessonName : allLessonNames) {
            tracker.markLesson(lessonName, false);
        }
    }
    public void markLesson(String lessonName, boolean b) {
        completedLessons.put(lessonName, true);
    }
    public void markLessonAsComplete(String topic) {
        completedLessons.put(topic, true);
    }

    public String getNextIncompleteLesson() {
        for (Map.Entry<String, Boolean> entry : completedLessons.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return null; // Return null if all lessons are completed
    }

    public int getUserCompletionLevel() {
        int completedCount = 0;
        for (boolean isCompleted : completedLessons.values()) {
            if (isCompleted) {
                completedCount++;
            }
        }
        return completedCount;
    }

    public boolean isLessonCompleted(String topic) {
        return completedLessons.getOrDefault(topic, false);
    }

    public void startNextLesson(LessonController lessonController) {
        String nextLessonTopic = getNextIncompleteLesson();
        if (nextLessonTopic != null) {
            switch (nextLessonTopic) {
                case "SimpleRotation01":
                    SimpleRotationLesson01 simpleRotation = new SimpleRotationLesson01(lessonController);
                    simpleRotation.startLesson();
                    markLessonAsComplete("SimpleRotation01");
                    break;
                case "DirectionCosines02":
                    DirectionCosinesLesson02 directionCosines = new DirectionCosinesLesson02(lessonController);
                    directionCosines.startLesson();
                    markLessonAsComplete("DirectionCosines02");
                    break;
                // Add cases for other lessons as needed
            }
        }
    }

    // You can add more methods as needed, such as:
    // - Retrieving a list of completed lessons
    // - Retrieving a list of incomplete lessons
}

