package Laboratory1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Laboratory1 {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Введите:
                [1 - Прямоугольник]
                [2 - Вывод даты]
                [3 - Вывод даты ISO]
                [4 - Расчет вклада]
                [5 - Расчет кредита]
                """);
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        switch (choice) {
            case 1 -> Rectangle.rectangleCalculation(10, 12);
            case 2 -> Date.printDate(2012, 10, 12, 14, 30, 55);
            case 3 -> Date.printDateIso("20191012T143055");
            case 4 -> BankOperations.bankOperations();
            case 5 -> BankOperations.bankOperations2();
            default -> System.out.println("Введите число от 1 до 5, а не " + choice);
        }
    }

    public static class Rectangle {

        public static void rectangleCalculation(double length, double width) {
            double perimeter, square, diagonal;
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

        public static void printDate(int year, int month, int dayOfMonth, int hour, int sec, int min) {
            System.out.println("Дата " + year + "-" + month + "-" + dayOfMonth);
            System.out.println("Время " + hour + ":" + min + ":" + sec);

        }

        public static void printDateIso(String iso) {
            System.out.println("Дата " + iso.substring(0, 4) + "-" + iso.substring(4, 6) + "-" + iso.substring(6, 8));
            System.out.println("Время " + iso.substring(9, 11) + "-" + iso.substring(11, 13) + "-" + iso.substring(13, 15));

        }

    }

    public static class BankOperations {

        final static Random random = new Random();
        static ArrayList<String> info = new ArrayList<>();
        static LocalDate date = LocalDate.now();

        public static void bankOperations() {
            double deposit;
            int data = 0;
            double percent = 0;
            System.out.println("Введите ваше ФИО: ");
            String fio = SCANNER.nextLine();
            System.out.println("Введите вашу дату рождения: ");
            String dateOfBirthday = SCANNER.nextLine();
            int identifier = random.nextInt(1, 100000);
            System.out.println("Ваш уникальный идентификатор: " + identifier);
            System.out.println(fio + " " + "Введите сумму, которую хотите вложить: ");
            deposit = SCANNER.nextDouble();
            System.out.println("""
                    Выберите тип вклада:
                    [1 - 5 процентов на год]
                    [2 - 10 процентов на 3 года]
                    [3 - 20 процентов на 5 лет]
                    """);
            int choice = SCANNER.nextInt();
            switch (choice) {
                case 1 -> {
                    percent = 5;
                    data = 1;
                }
                case 2 -> {
                    percent = 10;
                    data = 3;
                }
                case 3 -> {
                    percent = 20;
                    data = 5;
                }
                default -> System.out.println("Введите число от 1 до 3, а не " + choice);
            }
            info.add(fio);
            info.add(dateOfBirthday);
            info.add(String.valueOf(identifier));
            System.out.println(info);
            LocalDate date2 = date.plusYears(data);
            System.out.println("Вы вложили: " + deposit + " " + date + " числа" + "\n");
            percent = (deposit * percent) / 100;
            for (int i = 0; i <= data; i++) {
                deposit = deposit + percent;
            }
            System.out.println("Вы получите: " + deposit + " " + date2 + " числа");
        }

        public static void bankOperations2() {
            double credit, firstPay, leftToPay, payPerMonth;
            double percent = 0;
            double data = 0;
            System.out.println("Введите ваше ФИО: ");
            String fio = SCANNER.nextLine();
            System.out.println("Введите вашу дату рождения: ");
            String dateOfBirthday = SCANNER.nextLine();
            int identifier = random.nextInt(1, 100000);
            System.out.println("Ваш уникальный идентификатор: " + identifier);
            System.out.println("Введите сумму, которую хотите занять: ");
            credit = SCANNER.nextDouble();
            System.out.println("""
                    Выберите тип кредита:
                    [1 - 5 процентов на год]
                    [2 - 7.5 процентов на 3 года]
                    [3 - 10 процентов на 5 лет]
                    """);
            int choice = SCANNER.nextInt();
            double percent2 = percent;
            switch (choice) {
                case 1 -> {
                    percent2 = 5;
                    data = 12;
                }
                case 2 -> {
                    percent2 = 7.5;
                    data = 36;
                }
                case 3 -> {
                    percent2 = 10;
                    data = 60;
                }
                default -> System.out.println("Введите число от 1 до 3, а не " + choice);
            }
            System.out.println("Введите первый взнос: ");
            firstPay = SCANNER.nextDouble();
            leftToPay = credit - firstPay;
            percent = (credit * percent) / 100;
            int k = 1;
            info.add(fio);
            info.add(dateOfBirthday);
            info.add(String.valueOf(identifier));
            System.out.println(info);
            System.out.println("Вы заняли: " + credit + " " + date + " числа" + "\n");
            for (double i = leftToPay; i >= 0; i -= payPerMonth) {
                payPerMonth = percent + (leftToPay / data);
                System.out.format(k + " " + "Месяц - " + "Процентная ставка %-6.2fМесячная оплата %-8.2fОсталось оплатить %-8.2f\n", percent2, payPerMonth, i);
                k++;
            }
        }
    }
}
