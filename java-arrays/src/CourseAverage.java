package arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CourseAverage {

    public static void main(String[] args) {
        int[] exams = new int[3];
        Scanner gradeFile = null;

        try {
            gradeFile = new Scanner(new FileInputStream("grades.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        for (int i = 0; i < 3; ++i) {
            exams[i] = gradeFile.nextInt();
        }

        double examAvg = calcAverage(exams);
        double hwAvg = gradeFile.nextDouble();
        double finalExam = gradeFile.nextDouble();
        double courseAvg = .2 * hwAvg + .6 * examAvg + .2 * finalExam;
        System.out.printf("Your course average is %.1f%n", courseAvg);
    }

    private static double calcAverage(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}
