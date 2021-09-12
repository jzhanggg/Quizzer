import java.util.Scanner;
import java.util.ArrayList;

//This program allows the user to create a quiz of any preferred number of questions
//To create and answer the questions, run the program and type in the console! 
//The final score the user achieves in the quiz and the wrong questions' answers will be printed
//have fun! 



class Main {
  public static void main(String[] args) {
    int numQs;
    int numQsCorrect = 0;
    ArrayList<Integer> wrongQsIndex = new ArrayList<Integer>();

    System.out.println("\nWelcome to Joyce's quiz maker & self tester! \n");
    
    numQs = numQsUserWant();
    String[] questions = new String[numQs];
    String[] answers = new String[numQs];
    String[] userAnswers = new String[numQs];
  

    // saves all questions and answers in the quiz into their respective arraylists
    for (int questionCount = 0; questionCount < numQs; questionCount++){
      questions[questionCount] = enterQ(questionCount); 
      answers[questionCount] = enterA(questionCount); 
    }

    // blocks out console content
    blockContent();

    // Notify user that the quiz will start now
    System.out.println("The quiz will start now! \n");

    // 1. outputs quiz questions and asks user to input answers
    //    answers are saved into arraylist
    for (int questionCount = 0; questionCount < numQs; questionCount++){
      Scanner userQuizInput = new Scanner(System.in);

      System.out.println("Q" + (questionCount + 1) + ": " + questions[questionCount]+ "\n");
      userAnswers[questionCount] = userQuizInput.nextLine();
      System.out.println("\n");

      // 2. checks user input answers with the correct answers
      //    if user gets the question right, add 1 to the numQsCorrect
      //    if user gets the question wrong, records the index of the wrong answered question\
      if (answers[questionCount].equals(userAnswers[questionCount])) {
        numQsCorrect++;
      } else {
        wrongQsIndex.add(questionCount);
      }
    }

    blockContent();

    // 3. Output the number of correct questions over the total number of questions
    System.out.println("You got " + numQsCorrect + " out of " + numQs + " questions correct! \n\n");

    // 4. Output the wrong questions with the question and the wrong and correct answers comparison
    if (wrongQsIndex.size() == 0) {
      System.out.println("You got everything right, you are so damn smart! \n");
    } else {
      System.out.println("The following are the answers to the questions you got wrong: \n");

      for (int wrongQsCount = 0; wrongQsCount < wrongQsIndex.size(); wrongQsCount++){
        System.out.println("Q" + (wrongQsIndex.get(wrongQsCount) + 1) + ": " + questions  [wrongQsCount] + "\n");
        System.out.println("entered answer: " + userAnswers[wrongQsIndex.get(wrongQsCount)] + "\n");        
        System.out.println("correct answer: " + answers[wrongQsIndex.get(wrongQsCount)] + "\n");
      }
    }
   
  }

  //method asks user to input the number of questions to be in the quiz
  //returns the number of questions to bein the quiz
  private static int numQsUserWant() {
    Scanner userInputNumQs = new Scanner(System.in);

    System.out.println("How many fill in the blank questions would you like to create? Enter a number: \n");
    
    return userInputNumQs.nextInt();
  }

  //method asks user to input question
  //parameter: the question # 
  //returns the question content as a string
  private static String enterQ(int questionCount) {
    Scanner userInputQ = new Scanner(System.in);
    
    System.out.println("Please enter question " + (questionCount + 1)+ ": \n");
    String question = userInputQ.nextLine();

    return question;
  }

  //method asks user to input answer for a question
  //parameter: the question # 
  //returns the answer content as a string
  private static String enterA(int questionCount) {
    Scanner userInputA = new Scanner(System.in);

    System.out.println("Please enter the answer for question " + (questionCount + 1) + ": \n");
    String answer = userInputA.nextLine();

    return answer;
  }

  //blocks out console content
  private static void blockContent(){
    for (int i = 0; i< 40; i++){
      System.out.println("-------------------------------------------------------------\n");
    }
  }
}