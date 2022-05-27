package Laboratory1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Laboratory1 {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Введите:
                [1 - Прямоугольник]
                [2 - Выод даты]
                [3 - Расчет вклада]
                [4 - Расчет кредита]
                """);
        int choice = SCANNER.nextInt();
        if (choice == 1) {
            Rectangle.rectangleCalculation();
        } else if (choice == 2) {
            Date.printDate();
        } else if (choice == 3) {
            BankOperations.bankOperations();
        } else if (choice == 4) {
            BankOperations.bankOperations2();
        } else System.out.println("Введите число от 1 до 4, а не " + choice);
    }

    public static class Rectangle {

        public static void rectangleCalculation() {
            System.out.println("Введите длину и ширину: ");
            double length, width, perimeter, square, diagonal;
            length = SCANNER.nextDouble();
            width = SCANNER.nextDouble();
            if (length > 0 && width > 0) {
                perimeter = 2 * (length + width);
                square = length * width;
                diagonal = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
                System.out.println("Периметр прямоугольника равен: " + perimeter + "\n" + "Площадь прямоугольника равна: " + square + "\n"
                        + "Диагональ прямоугольника равна: " + diagonal + "\n");
            } else System.out.println("Пожалуйста введите положительные числа");
        }
    }

    public static class Date {

        public static void printDate() {
            int year, month, dayOfMonth, hour, min, secs;
            System.out.println("Введите год: ");
            year = SCANNER.nextInt();
            System.out.println("Введите месяц: ");
            month = SCANNER.nextInt();
            System.out.println("Введите день: ");
            dayOfMonth = SCANNER.nextInt();
            System.out.println("Введите час: ");
            hour = SCANNER.nextInt();
            System.out.println("Введите минуты: ");
            min = SCANNER.nextInt();
            System.out.println("Введите секунды: ");
            secs = SCANNER.nextInt();

            LocalDate date = LocalDate.of(year, month, dayOfMonth);
            LocalTime time = LocalTime.of(hour, min, secs);
            System.out.println(date + " " + time);
        }
    }

    public static class BankOperations {

        public static void bankOperations() {
            double deposit, data, percent;
            System.out.println("Введите ваше Имя: ");
            String name = SCANNER.next();
            System.out.println(name + " " + "Введите сумму, которую хотите вложить: ");
            deposit = SCANNER.nextDouble();
            System.out.println("Под какой процент хотите вложить сумму: ");
            percent = SCANNER.nextDouble();
            System.out.println("Введите срок депозита(в годах): ");
            data = SCANNER.nextDouble();
            percent = (deposit * percent) / 100;
            for (int i = 0; i <= data; i++) {
                deposit = deposit + percent;
            }
            System.out.println(name + "," + " Вы получите: " + deposit + " Через " + data + " лет");
        }

        public static void bankOperations2() {
            double credit, data, percent, firstPay, leftToPay, payPerMonth;
            System.out.println("Введите сумму, которую хотите занять: ");
            credit = SCANNER.nextDouble();
            System.out.println("Под какой процент хотите занять сумму: ");
            percent = SCANNER.nextDouble();
            System.out.println("Введите срок (в месяцах): ");
            data = SCANNER.nextDouble();
            System.out.println("Введите первый взнос: ");
            firstPay = SCANNER.nextDouble();
            leftToPay = credit - firstPay;
            double percent2 = percent;
            percent = (credit * percent) / 100;
            int k = 1;
            for (double i = leftToPay; i > 0; i -= payPerMonth) {
                payPerMonth = percent + (leftToPay / data);
                System.out.format(k + " " + "Месяц - " + "Процентная ставка %-6.2fМесячная оплата %-8.2fОсталось оплатить %-8.2f\n", percent2, payPerMonth, i);
                k++;
            }
        }
    }
}
