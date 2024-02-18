import java.util.*;

public class Ques01 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String st = s.substring(i, i + 10);
            if (!s1.add(st)) {
                s2.add(st);
            }
        }

        return new ArrayList<>(s2);

    }
}