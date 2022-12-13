import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zah
 * @create 2022-11-30 14:47
 * @Description
 */

public class PolandNotation {
    public static void main(String[] args) {
        String s = "1 + 2 + 3 - 4 * 23 - 32";
        System.out.println(getListString(s));
    }
//    字符串序列转为ArrayList 里面存储String
    public static List<String> getListString(String suffixExpression){
        String[] s = suffixExpression.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (String string:
             s) {
            strings.add(string);
        }
        return  strings;

    }
}

