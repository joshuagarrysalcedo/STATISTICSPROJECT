package xu.stat.statestix.data.Statistics.probability;

import xu.stat.statestix.data.Question;
import xu.stat.statestix.util.MathUTIL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class ProbabilityQuestions {
     static Random ran = new Random();


     public ArrayList<Question> generateQuestions(int number) {
         ArrayList<Question> q = new ArrayList<>();
         int qType;

         for(int i = 0; i < number; i++) {
             qType = ran.nextInt(7) + 1;
             switch (qType) {
                 case 1: q.add(q1());
                     break;
                 case 2: q.add(q2());
                     break;
                 case 3: q.add(q3());
                     break;

                 case 4: q.add(q4());
                     break;
                 case 5: q.add(q5());
                     break;
                 case 6: q.add(q6());
                     break;

             }//end of switch
         }

         return q;
     }






   public Question q1() {
       int numToss = ran.nextInt(200)+100;
       int numResult = ran.nextInt(50)+ 25;
       String object = Coin.map.get((ran.nextInt(1) + 1));
       String question = String.format("We toss a fair coin %d times. What is the probability that We get exactly %d %s.", numToss, numResult, object);
       double result = (double)numResult/(double)numToss;
       String answer = getAnswerInWords(result, true);
       System.out.println(answer);


       HashMap<Character, String> choices = new HashMap<>();
       choices = generateChoices(result, "words");
       Question q = new Question(question,answer, choices);
        return q;
   }


   public Question q2(){
       int blue = ran.nextInt(20) + 5;
       int red = ran.nextInt(20) + 5;
       int yellow = ran.nextInt(20) + 5;
       String question = String.format("There are %d blue marbles, %d red marbles, and %d yellow marbles in a bag. " +
               "What is the probability of selecting a blue or red marble on the first draw?", blue, red, yellow );
       double outcome = blue + red + yellow;
       double desired = blue + red;
       double result = desired/outcome;
       String answer = getAnswerInPercent(result);

       HashMap<Character, String> choices = new HashMap<>();
       choices = generateChoices(result, "percent");
       Question q = new Question(question, answer, choices);

       return q;
   }


   public Question q3(){
         int d = ran.nextInt(10) + 1;
       String question = String.format("A two-digit number is chosen at random. What is the probability that the chosen number is a multiple of %d?", d);
       int count = 0;
       int max = 100;
       int min = 10;

       for(int i = min; i < 100; i++) {
           if(i % d == 0) {
               count++;
           }
       }
       double result = (double)count/90;
       String answer = getAnswerInWords(result, true);
       HashMap<Character, String> choices = new HashMap<>();
       choices = generateChoices(result, "words");

       Question q = new Question(question, answer,choices);

       return q;
   }



   public  Question q4(){
       int d = ran.nextInt(3) + 2;
       //2-4 random
       String question =  String.format("A regular deck of cards has 52 cards. " +
               "Assuming that you do not replace the card you had drawn before the next draw, " +
               "what is the probability of drawing %d aces in a row?",d);
       double card = 52.0;
       double numOfcard = 4.0;
       double result = 1.0;
       for(int i = 1; i<= d; i++) {
           result *= numOfcard/card;
           card--;
           numOfcard--;
       }
       String answer = getAnswerInWords(result, true);

       HashMap<Character, String> choices = new HashMap<>();
       choices = generateChoices(result, "words");

       Question q = new Question(question, answer,choices);
       return q;
   }



   public Question  q5() {
         int white = ran.nextInt(100) + 10;
         int yellow = ran.nextInt(100) + 10;
         int black = ran.nextInt(100) + 10;
       String question = String.format("If a bag of balloons consists of %d white balloons, " +
               "%d yellow balloons, and %d black balloons, what is the approximate likelihood " +
               "that a balloon chosen randomly from the bag will be black?", white, yellow, black);
       double sum =  white+yellow+black;
       double result = (double)black / sum;
       //percentage
       String answer = getAnswerInPercent(result);
       HashMap<Character, String> choices = new HashMap<>();
       choices = generateChoices(result, "percentage");

       Question q = new Question(question, answer,choices);
       return  q;
   }

  public Question q6() {
       int prize = ran.nextInt(10) + 1;
       int blank = ran.nextInt(100) + 25;
       String question = String.format("In a lottery, there are %d prizes and %d blanks. A lottery is drawn at random. " +
               "What is the probability of getting a prize?", prize, blank);
       double result =  (double)prize / (double)(blank+prize);

       String answer = getAnswerInPercent(result);
      HashMap<Character, String> choices = new HashMap<>();
      choices = generateChoices(result, "percent");

      Question q = new Question(question, answer,choices);
      return q;
  }


    public  String getAnswerInWords(double answer, boolean correct) {
            double temp = 1.0 / answer;
            int result = (int) temp;
            if(correct){
                return String.format("1 in %d", result);
            }else{
                int random;
                random = ran.nextInt(20) + 10;
                return String.format("1 in %d", result + random);

            }

    }

    public  String getAnswerInPercent(double answer) {
        BigDecimal decimal = new BigDecimal("100");
        BigDecimal percentage = decimal.multiply(new BigDecimal(answer/100.0));
          return String.format("%s%%",MathUTIL.df.format(percentage));
    }


    public HashMap<Character, String> generateChoices(double answer, String type) {
         ArrayList<String> list = new ArrayList<>();

         if(type == "words") {
             list.add(getAnswerInWords(answer, true));
             list.add(getAnswerInWords(answer, false));
             list.add(getAnswerInWords(answer , false));
             list.add(getAnswerInWords(answer , false));
         }else{
             list.add(getAnswerInPercent(answer));
             list.add(getAnswerInPercent(answer + .1));
             list.add(getAnswerInPercent(answer - .1));
             list.add(getAnswerInPercent(answer + .2));
         }

        Collections.shuffle(list);

         HashMap<Character, String> choices = new HashMap<>();
         choices.put('a', list.get(0));
        choices.put('b', list.get(1));
        choices.put('c', list.get(2));
        choices.put('d', list.get(3));

        return choices;
    }

}



