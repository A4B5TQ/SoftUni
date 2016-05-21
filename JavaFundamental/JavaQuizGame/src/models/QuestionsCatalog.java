package models;

import io.QuestionCatalogIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionsCatalog {
    private String Question;
    private List<String> Answers;
    private String correctAnswer;
    private int questionCount = 0;

    public List<String> getAnswers() {

        return Answers;
    }

    public void setAnswers(List<String> answers) {
        Answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    private List<String[]> catalog;

    public QuestionsCatalog(QuestionCatalogIO catalogIO) throws IOException {
        catalog = catalogIO.readQuiz();
        setQuestion(catalog.get(questionCount)[0]);
        List<String> answ = new ArrayList<>();
        answ.add(catalog.get(questionCount)[1]);
        answ.add(catalog.get(questionCount)[2]);
        answ.add(catalog.get(questionCount)[3]);
        answ.add(catalog.get(questionCount)[4]);
        setAnswers(answ);
        setCorrectAnswer(catalog.get(questionCount)[5]);

    }

    public void nextQuestion() {
        setQuestion(catalog.get(questionCount)[0]);
        List<String> answ = new ArrayList<>();
        answ.add(catalog.get(questionCount)[1]);
        answ.add(catalog.get(questionCount)[2]);
        answ.add(catalog.get(questionCount)[3]);
        answ.add(catalog.get(questionCount)[4]);
        setAnswers(answ);
        setCorrectAnswer(catalog.get(questionCount)[5]);
        questionCount++;
    }
}

