package BackTrack;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Solution17 {
    private List<String> res = new ArrayList<>();
    private List<String> path = new LinkedList<>();
    private Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (Objects.isNull(digits) || digits.isEmpty()) return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtracking(digits, 0);
        return res;
    }

    public void backtracking(String digits, int startIndex) {
        if (startIndex == digits.length()) {
            res.add(String.join("", path));
            return;
        }
        String letter = map.get(digits.charAt(startIndex));
        if (Objects.isNull(letter)) return;
        for (char c : letter.toCharArray()) {
            path.add(String.valueOf(c));
            backtracking(digits, startIndex + 1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("23");
        System.out.println(strings);
    }
}
