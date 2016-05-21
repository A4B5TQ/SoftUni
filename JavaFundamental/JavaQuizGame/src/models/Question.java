package models;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String QUESTION;
    private List<String> ANSWERS;
    private String correctAnswer;

    public List<String> getANSWERS() {
        return ANSWERS;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public Question(QuestionsCatalog catalog){
        QUESTION = catalog.getQuestion();
        ANSWERS =  catalog.getAnswers();
        correctAnswer = catalog.getCorrectAnswer();
    }

    public void nextQuestion(QuestionsCatalog catalog){
        QUESTION = catalog.getQuestion();
        ANSWERS =  catalog.getAnswers();
        correctAnswer = catalog.getCorrectAnswer();
    }

    public boolean checkCorrectAnswer(String answer) {
        if (answer.equals(getCorrectAnswer())) {
            return true;
        }
        return false;
    }

    public Question(String question, String answerOne,String answerTwo,String answerThree,String answerFour,String theCorrectAnswer){
        setQuestion(question);
        List<String> newQuestionAnswers = new ArrayList<>();
        newQuestionAnswers.add(answerOne);
        newQuestionAnswers.add(answerTwo);
        newQuestionAnswers.add(answerThree);
        newQuestionAnswers.add(answerFour);
        setAnswers(newQuestionAnswers);
        setCorrectAnswer(theCorrectAnswer);
    }

    public void setQuestion(String question) {
        this.QUESTION = question;
    }

    public void setAnswers(List<String> answers) {
        this.ANSWERS = answers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}



