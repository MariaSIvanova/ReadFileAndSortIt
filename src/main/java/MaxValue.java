import java.util.Map;

/**
 * Created by Mivanova on 27.12.2017 for TaskForFileReader
 */
public class MaxValue {

    /**
     *
     * @param map на вход мапа
     * @return возвращаем ключ для самого большого значения
     */
    public static String getKeyOfMaxValue(Map<String, Integer> map) {
        int max = 0;
        String maxKey = null;
        int temp;
        String tempMaxKey;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            temp = entry.getValue();
            tempMaxKey = entry.getKey();
            if (max < temp) {
                max = temp;
                maxKey = tempMaxKey;
            }
        }
        return maxKey;
    }
}
