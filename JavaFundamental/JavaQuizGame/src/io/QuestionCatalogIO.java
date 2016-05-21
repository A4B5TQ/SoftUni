package io;

import engine.controllers.GameChooseController;
import models.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static engine.controllers.ExceptionHandling.warningDisplay;

public class QuestionCatalogIO {

    public List<String[]> readQuiz() {
        List<String[]> quiz = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("res/Questions/" + GameChooseController.getQuizChoose() + ".txt"));
            String[] line;
            String inputLine;
            while ((inputLine = reader.readLine())!= null) {
                line = inputLine.split("\\|");
                if (line.length > 1){

                    quiz.add(line);
                }
            }
        } catch (Exception e) {
            warningDisplay("Cannot read quiz data! Please check for missing .txt files");
        }
        return quiz;
    }

    public static void writeQuiz(Question que) {
        String question = "\r\n" + que.getQUESTION() + "|" + que.getANSWERS().get(0) + "|" + que.getANSWERS().get(1) + "|" +
                que.getANSWERS().get(2) + "|" + que.getANSWERS().get(3) + "|" + que.getCorrectAnswer();
        try (PrintWriter writer = new PrintWriter(new FileWriter("res/Questions/" + GameChooseController.getQuizChoose() + ".txt", true))) {
            writer.write(question);
            writer.flush();
        } catch (IOException exe) {
            warningDisplay("Cannot write quiz data! Please check for missing .txt files");
        }
    }
}
