import java.util.Scanner;

public class Homework {
    
    public static void printBMI(double weight, double height) {
        double bmi = weight / (height * height);
        String result;

        if (bmi < 18.5) {
            result = "Underweight: less than 18.5";
        } else if (bmi <= 24.9) {
            result = "Normal: between 18.5 and 24.9";
        } else if (bmi <= 29.9) {
            result = "Overweight: between 25 and 29.9";
        } else {
            result = "Obesity: 30 or greater";
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // try-with-resources 自动关闭资源
            System.out.print("请输入体重(kg): ");
            double weight = scanner.nextDouble();

            System.out.print("请输入身高(m): ");
            double height = scanner.nextDouble();

            printBMI(weight, height);
        }
    }
}
