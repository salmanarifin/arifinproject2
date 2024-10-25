import java.util.Scanner;

public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        boolean repeat = true;
        while (repeat) {
            System.out.println("Enter coordinate 1: ");
            String coord1 = scan.nextLine();
            System.out.println("Enter coordinate 2: ");
            String coord2 = scan.nextLine();

            int x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(",")));
            int x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")));
            int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.indexOf(")")));
            int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.indexOf(")")));

            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
            System.out.println();
            equation.lineInfo();
            System.out.println();

            if (x1 != x2) {
                System.out.println("Enter a value for x: ");
                double x = scan.nextDouble();
                scan.nextLine();
                System.out.println();
                System.out.println("The point on this line is " + equation.coordinateForX(x));
                System.out.println();
            }
            boolean another = true;
            while (another) {
                System.out.println("Would you like to enter another pair of coordinates? y/n: ");
                String answer = scan.nextLine();
                if (answer.equals("y")) {
                    another = false;
                    System.out.println();
                } else if (answer.equals("n")) {
                    another = false;
                    repeat = false;
                    System.out.println("Thank you for using the slope calculator, goodbye!");
                }
            }
        }
    }
}
