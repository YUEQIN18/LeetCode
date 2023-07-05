package String;

public class Solution151 {
    public static String reverseWords(String s) {
        s = reverse(s.trim());
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string: ss) {
            if (string.equals("")) continue;
            String res = reverse(string);
            sb.append(res);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private static String reverse(String s) {
        char[] array = s.toCharArray();
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            char temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
        return new String(array);
    }
    public static void main(String[] args) {
        String a = "a good   example";
        System.out.println(Solution151.reverseWords(a));
    }
}
