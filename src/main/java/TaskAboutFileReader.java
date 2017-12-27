import java.util.List;
import java.util.Map;

/**
 * Created by Mivanova on 26.12.2017 for TaskForFileReader
 */
public class TaskAboutFileReader {
    public static void main(String[] args) {
        String fileName = "src\\AboutReader.txt";
        //String fileName = "src\\hi.txt";
        //прочитать слова из файла
        List<String> massOfWords = ListOfWordsFromFile.readSomeFile(fileName);
        //Отсортировать в алфавитном порядке
        massOfWords = SortMassOfWords.toSort(massOfWords);
        //for(String a: massOfWords) System.out.println(a);//просто отсортированный список

        //Посчитать сколько раз каждое слово встречается в файле
        //для этого создаем мапу где ключ - это значение поля, а значение - это их количество
        Map<String, Integer> map = StatisticsOfWords.doStatisticsFromSortedList(massOfWords);
        for(Map.Entry<String, Integer> temp : map.entrySet()){
            //Вывести статистику на консоль
            System.out.println("слово: "+temp.getKey() + "; встречается в файле: " +temp.getValue()+ " раз.");
        }
        //Найти слово с максимальным количеством повторений.
        //Вывести на консоль это слово и сколько раз оно встречается в файле
        String keyForMaxValue = MaxValue.getKeyOfMaxValue(map);
        System.out.println("\n В итоге слово: \""+ keyForMaxValue + "\" больше всего повторяется в файле, "
        + map.get(keyForMaxValue) + " раз");
    }
}
