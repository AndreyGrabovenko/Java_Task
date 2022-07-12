/*
Задание 2.
Написать метод, который проверяет валидность логина и пароля (где нибудь в переменных сохраните) и 
при помощи конструкции try-catch рекурсивно принимайте данные 
(нужно ограничить колиичество попыток до 6 и после 3 попытки должно быть сообщение, 
мол вы привысили количество попыток, немного пододождите 
тут можете поток заслипить на некоторое время. 
А когда попытки кончатся - выйти)
*/

package Lesson3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        int countAttempt = 6;
        checkData(countAttempt);

    }

    public static String[] checkData(int count) throws InterruptedException {
        String[] array = new String[2];
        if (0 < count) {
            if (count == 3) {
                System.out.println("\nСлишком много попыток, ввод временно заблокирован!");
                Thread.sleep(10000);
            }
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("\n\nУ Вас " + count + " попыток.");
                System.out.print("Введите логин : ");
                String userLogin = in.nextLine();
                System.out.print("Введите пароль : ");
                String userPassword = in.nextLine();

                while (!validation_Data(userLogin, userPassword)) { // функция проверки валидности логина и пароля
                    System.out.println("Неверно!");
                    return checkData(count - 1); // рекурсивный вызов самой себя с уменьшением количества попыток
                }
                System.out.println("Отлично! Валидация пройдена!\n\n");
                array[0] = userLogin;
                array[1] = userPassword;
            }
        } else {
            System.out.println("Превышено количество попыток, ввод заблокирован!\n");
            array[0] = "";
            array[1] = "";
        }

        return array;
    }

    public static boolean validation_Data(String LOGIN_Arg, String PASSWORD_Arg) {
        boolean result = false;
        try {
            if (LOGIN_Arg != null & PASSWORD_Arg != null) {

                String Login_PATTERN = "(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,15}";
                String Password_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

                result = LOGIN_Arg.matches(Login_PATTERN) & PASSWORD_Arg.matches(Password_PATTERN);
            }

        } catch (Exception ex) {
            result = false;
        }

        return result;
    }
}
