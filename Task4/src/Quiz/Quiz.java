package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private List<QuizQuestion> questions;
    private int score;
    private int currentQuestionIndex;
    private Scanner scanner;
    private boolean answerSubmitted;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;
        scanner = new Scanner(System.in);
        answerSubmitted = false;
    }

    public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }

    public void start() {
        for (currentQuestionIndex = 0; currentQuestionIndex < questions.size(); currentQuestionIndex++) {
            displayQuestion(questions.get(currentQuestionIndex));
            startTimer(10);  // 10 seconds for each question
            waitForAnswer();
        }
        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((char)('A' + i) + ": " + options[i]);
        }
    }

    private void startTimer(int seconds) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if (!answerSubmitted) {
                    System.out.println("\nTime's up!");
                    answerSubmitted = true;
                }
            }
        };
        timer.schedule(task, seconds * 1000);
    }

    private void waitForAnswer() {
        answerSubmitted = false;
        while (!answerSubmitted) {
            System.out.print("Enter your answer (A/B/C/D): ");
            String answer = scanner.nextLine().toUpperCase();
            if (answer.length() == 1 && answer.charAt(0) >= 'A' && answer.charAt(0) <= 'D') {
                checkAnswer(answer.charAt(0));
                answerSubmitted = true;
            } else {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
            }
        }
    }

    private void checkAnswer(char userAnswer) {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        if (userAnswer == currentQuestion.getCorrectOption()) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect! The correct answer is " + currentQuestion.getCorrectOption() + ".");
        }
    }

    private void displayResult() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score is: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        
        String[] options1 = {" Mars ", " Venus", " Jupiter"," Saturn"};
        quiz.addQuestion(new QuizQuestion("Which planet is known as the Red Planet?", options1, 'A'));
        
        String[] options2 = {" Isaac Newton",
        		 " Albert Einstein",
        		 " Niels Bohr",
        		 " Galileo Galilei"};
        quiz.addQuestion(new QuizQuestion("Which scientist is credited with developing the general theory of relativity?", options2, 'B'));

        
        String[] options3 = {"a) Marie Curie, Physics\r\n",
        		 " Bertha von Suttner, Peace\r\n",
        		 " Irene Joliot-Curie, Chemistry\r\n",
        		 " Dorothy Crowfoot Hodgkin, Chemistry"};
        quiz.addQuestion(new QuizQuestion("Which scientist is credited with developing the general theory of relativity?", options3, 'a'));

        // Add more questions as needed
        
        quiz.start();
    }
}
