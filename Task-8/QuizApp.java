import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption; // index starting from 1

    Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create list of questions
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question(
            "Which language is used for Android app development?",
            new String[]{"Java", "Python", "C++", "Ruby"}, 1
        ));
        quiz.add(new Question(
            "Who is known as the father of Java?",
            new String[]{"James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum"}, 1
        ));
        quiz.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            new String[]{"extends", "implements", "inherits", "super"}, 1
        ));
        quiz.add(new Question(
            "Which company developed Java?",
            new String[]{"Oracle", "Microsoft", "Sun Microsystems", "IBM"}, 3
        ));
        quiz.add(new Question(
            "Which of these is not a Java feature?",
            new String[]{"Object-Oriented", "Platform Independent", "Use of Pointers", "Robust"}, 3
        ));
        quiz.add(new Question(
            "Which package contains the Scanner class in Java?",
            new String[]{"java.io", "java.util", "java.net", "java.sql"}, 2
        ));
        quiz.add(new Question(
            "Which symbol is used for single-line comments in Java?",
            new String[]{"/* */", "//", "#", "<!-- -->"}, 2
        ));
        quiz.add(new Question(
            "What is the default value of an int variable in Java?",
            new String[]{"0", "null", "undefined", "1"}, 1
        ));

        // 🔀 Shuffle questions so they appear in random order every run
        Collections.shuffle(quiz);

        int score = 0;

        System.out.println("===== Welcome to the Online Quiz App =====\n");

        System.out.println("Answer the Below Quiz to know your performance on Java");
        System.out.println("===================================================");

        // Loop through shuffled questions
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println((i + 1) + ". " + q.questionText);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }
            System.out.print("Enter your answer (1-" + q.options.length + "): ");
            int answer = sc.nextInt();

            if (answer == q.correctOption) {
                System.out.println(" Correct!\n");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + q.options[q.correctOption - 1] + "\n");
            }
        }

        // Display final result
        System.out.println("===== Quiz Finished! =====");
        System.out.println("Your Score: " + score + "/" + quiz.size());
        if (score == quiz.size()) {
            System.out.println(" Excellent! Perfect Score! :)");
        } else if (score >= quiz.size() / 2) {
            System.out.println(" Good job! Keep practicing. ^_^");
        } else {
            System.out.println(" [OK] Better luck next time!");
        }

        sc.close();
    }
}