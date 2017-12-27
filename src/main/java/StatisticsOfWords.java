import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mivanova on 27.12.2017 for TaskForFileReader
 */
public class StatisticsOfWords {

    /**
     * метод подходит только для отсортированного списка
     * @param words - на вход список слов
     * @return - возвращаем ключ - слово, значение - количество повторений
     */
    public static Map<String, Integer> doStatisticsFromSortedList (List<String> words){
        //использовали TreeMap, чтобы сохранить последовательность
        Map<String, Integer> afterStat = new TreeMap<String, Integer>();
        int times = 1;
        //создала первое значение мапы, остальные будут добавлены при сравнении ключа
        afterStat.put(words.get(0),times);

        for (int i = 1 ; i<words.size(); i++){
            if(afterStat.containsKey(words.get(i))) afterStat.put(words.get(i),++times);
            else {
                afterStat.put(words.get(i),1);
                times = 1;
            }
        }
        return afterStat;
    }
}
