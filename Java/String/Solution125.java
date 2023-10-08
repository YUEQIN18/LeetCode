package String;

/**
 * 125. 验证回文串
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            while (l < r && !isValid(array[l])) l++;
            while (l < r && !isValid(array[r])) r--;
            if (l >= r) break;
            if (array[l] == array[r]) {
                l++;
                r--;
            } else {
                return false;
            }

        }
        return true;
    }

    private boolean isValid(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        boolean palindrome = solution125.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

}
