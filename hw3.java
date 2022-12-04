// 1) Создать новый список, добавить несколько строк и вывести коллекцию на экран.
// 2) Итерация всех элементов списка цветов и добавления к каждому символа '!'.
// 3) Вставить элемент в список в первой позиции.
// 4) Извлечь элемент (по указанному индексу) из заданного списка.
// 5) Обновить определенный элемент списка по заданному индексу.
// 6) Удалить третий элемент из списка.
// 7) Поиска элемента в списке по строке.
// 8) Создать новый список и добавить в него несколько елементов первого списка.
// 9) Удалить из первого списка все элементы отсутствующие во втором списке.
// 10) *Сортировка списка.
// 11) *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.

package Sem.date221121.HW3;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * hw3
 */
public class hw3 {

    public static void main(String[] args) {
        // 1) Создать новый список, добавить несколько строк и вывести коллекцию на экран.
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add(0, "null element");
        arrList.add(1, "first element");
        arrList.add(2, "second elememt");
        arrList.add(3, "third elememt");
        arrList.add(4, "fourth elememt");
        arrList.add(5, "fifth elememt");
        //запоминаем стартовый список
        ArrayList<String> initialArrList = new ArrayList<>();
        for (String string : arrList) {
            initialArrList.add(string);
        }

        for (String string : arrList) {
            System.out.printf("Элемент № %d называется %s\n", arrList.indexOf(string), string);
        }

        // 2) Итерация всех элементов списка цветов и добавления к каждому символа '!'.
        System.out.print("\nДобавляем всем !:");
        for (int i = 0; i < arrList.size(); i++) {
            arrList.set(i, arrList.get(i) + "!");
        }
        printArr(arrList, initialArrList, null);    
        
        // 3) Вставить элемент в список в первой позиции.
        System.out.print("\nВставляем, например, первый элемент");
        arrList.add(1, "new first element");
        printArr(arrList, initialArrList, null);    

        // 4) Извлечь элемент (по указанному индексу) из заданного списка.
        Scanner scanEl = new Scanner(System.in);
        System.out.printf("\nВведите индекс элемента от 0 до %d: ", arrList.size()-1);
        Integer indexEl = Integer.parseInt(scanEl.nextLine());
        System.out.printf("Элемент с индексом %d => %s\n", indexEl, arrList.get(indexEl));
        
        // 5) Обновить определенный элемент списка по заданному индексу.
        System.out.print("\nВведите новое значение элемента: ");
        String newEl = scanEl.nextLine();
        arrList.set(indexEl, newEl);
        printArr(arrList, initialArrList, null);    

        // 6) Удалить третий элемент из списка.
        arrList.remove(2);
        System.out.print("\nDelete third element:");
        printArr(arrList, initialArrList, null);    

        // 7) Поиска элемента в списке по строке.
        System.out.print("\nВведите значение строки для поиска: ");
        String findEl = scanEl.nextLine();
        if (arrList.contains(findEl)) {
            System.out.println("Ага, есть такое"); 
        } else {
            System.out.println("Дык, нет такого"); 
        }

        // 8) Создать новый список и добавить в него несколько елементов первого списка.
        System.out.print("\nДобавляем во второй список, ну, например, четные элементы из текущего: "); 
        ArrayList<String> newArrList = new ArrayList<>();
        for (int i = 0; i < arrList.size(); i++) {
            if (i%2 == 0) newArrList.add(arrList.get(i));
        }
        printArr(arrList, initialArrList, newArrList);    

        // 9) Удалить из первого списка все элементы отсутствующие во втором списке.
        System.out.print("\nУдаляем из текущего списка все элементы, отсутствующие во втором списке: ");
        Iterator arrIt = arrList.iterator();
        while (arrIt.hasNext()) {
            if (newArrList.contains(arrIt.next()) == false) arrIt.remove();
        }
        printArr(arrList, initialArrList, newArrList);    

        // 10) *Сортировка списка.
        System.out.print("\nСортируем текущий список: ");
        arrList.sort(null);
        printArr(arrList, initialArrList, newArrList);

        // 11) *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
        // 3) Вставить элемент в список в первой позиции.
        System.out.printf("\nСравниваем время работы:\n");
        ArrayList<Integer> al = new ArrayList<Integer>();
        long timeAL = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            al.add(0, i);
        }
        long elapsedAL = System.nanoTime() - timeAL;
        System.out.print("по методу ArrayList => ");
        System.out.println(elapsedAL);
          
        LinkedList<Integer> ll = new LinkedList<Integer>();
        long timeLL = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            ll.add(0, i);
        }
        long elapsedLL = System.nanoTime() - timeLL;
        System.out.print("по методу LinkedList => ");
        System.out.println(elapsedLL);
      
        scanEl.close();

    }

    private static void printArr(ArrayList<String> tempList, ArrayList<String> iniList, ArrayList<String> modList) {
        System.out.print("\nСтартовая коллекция => ");
        System.out.println(iniList);
        System.out.print("Текущая коллекция => ");
        System.out.println(tempList);
        System.out.print("Вторая коллекция => ");
        System.out.println(modList);

    }
}
