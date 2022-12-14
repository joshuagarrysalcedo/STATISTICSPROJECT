package xu.stat.statestix.data.Statistics.probability;

import xu.stat.statestix.data.Question;
import xu.stat.statestix.data.Statistics.Mode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MeanMedianModeQuestions {
    Random ran = new Random();
    private String[] MMMquestions = {
        "Find the mean, median and mode for the following set?",
         "Given the set provided, what is the mean median and mode? ",
         "Identify the mean, median , and mode from the set? ",
    };


    private String meanQuestion = "Find the mean of these set of Integers?";
    private String medianQuestion = "What is the median of the set? ";


    public Question generateQuestion() {
        int flag = ran.nextInt(4)+1;

        switch(flag) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    private Question generateModeQuestion() {
        Mode mode = new Mode()
        int n = ran.nextInt(6)+ 5;
        double[]set = new double[n];
        for(int i = 0; i < n; i++) {
            set[i] = ran.nextInt(20) + 1;
        }
        double[] modes = mode.findMode(set);
        String question = String.format("Identify the mode for the following set?\n%s", Arrays.toString(set) );
        String answer = Arrays.toString(modes);

    }

    public HashMap<Character, String> generateChoices(double ...a){
        double arr[] = new double[a.length]; // incase a is more than 1
        if(a.length > 1) {
            double wrongAnswers[] = new double[a.length];
            for(int i = 0; i < a.length; i++) {
                wrongAnswers[i] += 1;
            }
        }
    }

}
