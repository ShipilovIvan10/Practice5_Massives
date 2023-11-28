import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Character.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int taskNumber = -1;

        while (taskNumber!=0) {

            System.out.println("Введите номер задания (1-10) [0 - выход]: ");

            taskNumber = scanner.nextInt();

            switch (taskNumber) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                default:
                    System.out.println("Введен неверный номер задания!");
            }
        }
    }

    public static void task1(){
        //Пользователь вводит с клавииатуры строку.
        //Произведите поворот строк и полученный результат выведите
        //в консоль


        System.out.println("Введите слово: ");
        scanner.nextLine();
        String str = scanner.nextLine();

        char[] reverseSring = new char[str.length()];

        for (int i = str.length() - 1; i>=0; i--){
            reverseSring[str.length() - i - 1] = str.charAt(i);
        }

        System.out.println(reverseSring);
    }

    public static void task2(){

        System.out.println("Введите строку: ");
        String str = scanner.nextLine();
        System.out.println("Введите слово поиска: ");
        String wordSearch = scanner.nextLine();

        //Количество повторов
        int count=0;

        //Токинайзер
        StringTokenizer st = new StringTokenizer(str, " ");

        //Метод split
        String[] wordsArr = str.split(",\\s|\\s");

        for (String word : wordsArr) {
            System.out.println(word);
            if (Objects.equals(word, wordSearch)) {
                count++;
            }
        }
        System.out.println("Количество исковмых слов: " + count);
    }

    public static void task3(){

        System.out.print("Введите исходную строку: ");
        scanner.nextLine();
        String str = scanner.nextLine();
        System.out.print("Введите слово поиска: ");
        String wordSearch = scanner.nextLine();
        System.out.print("Введите слово для замены: ");
        String wordInsert = scanner.nextLine();

        //Результат строка
        StringBuilder strResult = new StringBuilder();

        String[] wordsArr = str.split(",\\s|\\s");

        String[] wordsRes = new String[str.length()];

        int i=0;

        for (String word: wordsArr){
            if (Objects.equals(word,wordSearch)){
                wordsRes[i] = wordInsert;
            }else {
                wordsRes[i] = word;
            }

            strResult.append(wordsRes[i]).append(" ");
            i++;
        }
        System.out.println(strResult);
    }

    public static void task4() {

        System.out.print("Введите исходную строку: ");
        scanner.nextLine();
        String str = scanner.nextLine();

        String strReplace = str.replace(" ", "");
        String strLowCase = strReplace.toLowerCase();

       // System.out.println(strLowCase);

        StringBuilder strBuilder = new StringBuilder(strLowCase);
        //System.out.println(strBuilder);
        StringBuilder strReverse = new StringBuilder(strLowCase);
        //strReverse.reverse();
        System.out.println(strReverse);

        if (strBuilder.compareTo(strReverse) == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void task5() {

        System.out.print("Введите исходную строку (Предложения разделяются точкой): ");
        scanner.nextLine();
        String str = scanner.nextLine();

        String[] sentenceArr = str.split("\\.\\s");

//        for(String sentence : sentenceArr){
//            System.out.println(sentence);
//        }

        int countOfSentenses = 0;
        int countOfDigits = 0;
        int countOfMarks = 0;
        char ch;

        StringBuilder strBuilder = new StringBuilder();

        for(String sentence : sentenceArr){
           // strBuilder.deleteCharAt(0);

            strBuilder.append(toLowerCase(sentence.charAt(0)));
            if (sentence.length() > 1){
                strBuilder.append(sentence.subSequence(1, sentence.length()));
            }
            System.out.print(strBuilder + ". ");

            for (int i=0; i< sentence.length(); i++) {
                ch = sentence.charAt(i);
                if (Character.isDigit(ch)) {
                    {
                        countOfDigits++;
                    }
                } else if ((sentence.charAt(i) == ',') || (sentence.charAt(i) == ';')) {
                    countOfMarks++;
                    }
            }
            strBuilder.delete(0, strBuilder.length());
        }

        System.out.println();
        System.out.println("Количество цифр: " + countOfDigits);
        System.out.println("Количество знаков препинания: " + countOfMarks);
    }


}