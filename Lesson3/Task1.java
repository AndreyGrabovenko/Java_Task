/*
Задание 1.
Создать карту (Map), будет хранить в себе данные телефонной книги (Фамилии и телефонные номера), если будут дубликаты фамилий, 
то должны выводиться оба номера (если помним Map не может хранить дубликаты, будет заменять номер телефона по ключу, 
нужно подумать как не допустить такого)
*/
package Lesson3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Map<Long,String> phoneBook = new HashMap<Long,String>();
        phoneBook.put(83452212133L, "Лидия Аркадьевна Бубликова");
        phoneBook.put(83452162348L, "Иван Михайлович Серебряков");
        phoneBook.put(83452082771L, "Дональд Джон Трамп");
        System.out.println(phoneBook);
    }
}