import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Created by Mivanova on 24.12.2017 for TaskForFileReader
 */
public class ListOfWordsFromFile {

    /**
     * публичный метод класса, который дергает остальные методы класса
     * @param fileName - при вызове передаем путь и названием файла
     * @return - возвращаем список из слов, которые были в файле
     */
   public static List<String> readSomeFile(String fileName) {
       List<String> list = doLineForFile(fileName);
       List<String> words = new ArrayList<String>();
       for (String a: list) {
           if (searchEmptyLine(a))
           for (String b: singleWord(a)) words.add(b);
       }
       return words;
   }

    /**
     *
     * @param line - одна стринговая строка
     * @return - возвращает false, если строка пустая или в строке одни пробелы
     */
   private static boolean searchEmptyLine (String line){
       // Создание Pattern объекта
       Pattern pattern = Pattern.compile("^[\\s]*$");
       // Создание matcher объекта
       Matcher m = pattern.matcher(line);
       if(m.find()) return false;
       else return true;
   }

    /**
     *
     * @param fileName - путь и имя файла
     * @return - возвращает список строк
     */
   private static List<String> doLineForFile (String fileName) {
    BufferedReader bufferedReader = null;
    List<String> list = new ArrayList<String>();
    try {
        //применили BufferedReader чтобы учесть кодировку для русского языка, иначе текст на русском отображался в виде ромбиков
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1251"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }

    } catch (FileNotFoundException e) {
        System.out.println("FileNotFoundException " + e.getStackTrace());
        System.out.println(e.getMessage());
    } catch (IOException e) {
        System.out.println("IOException " + e.getStackTrace());
        System.out.println(e.getMessage());
    }
    //блок для закрытия файла с обработкой ошибки на случай, если файл не найден
    finally {
        try {
            if (bufferedReader != null) bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

    /**
     *
     * @param someLine на входе строка
     * @return возвращаем массив слов
     */
    private static String[] singleWord(String someLine) {
        String[] words;
        //words = someLine.split("\\s+"); //тут не учлись пробелы перед строкой

        //удаляем пробелы до и после строки и строку делим на слова при наличии пробела
        //использовала регулярное выражение для пробела \s
        words = someLine.trim().split("\\s+");
        return words;
    }


}
