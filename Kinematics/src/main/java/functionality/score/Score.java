package functionality.score;

public class Score {
    int overallScore =0;
    int chapter01Score = 0;
    public static void main(String[] args) {

    }

    //getters
    public int getOverallScore(){
        return overallScore;
    }

    public int getChapter01Score(){
        return chapter01Score;
    }

    //increment
    public void incrementScore(){
        overallScore+=1;
    }

    public void incrementChapter01Score(){
        chapter01Score+=1;
    }



    public String toString(){
        System.out.println(" ");
        return "Your current score is: "+ getOverallScore();

    }
}
