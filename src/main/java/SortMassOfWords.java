import java.util.Collections;
import java.util.List;

/**
 * Created by Mivanova on 26.12.2017 for TaskForFileReader
 */
public class SortMassOfWords {

    /**
     *
     * @param list - принимаем список слов
     * @return - возвращаем отсортированный список, применили метод sort() для Collections
     */
    public static List<String> toSort(List<String> list) {
        Collections.sort(list);
        return list;
    }
}
