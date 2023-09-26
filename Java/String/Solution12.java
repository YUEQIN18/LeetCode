package String;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 */
public class Solution12 {
    // 优雅的做法

    public String intToRoman2(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    // 朴素的做法
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                res.append("M");
            } else if (num >= 900) {
                num -= 900;
                res.append("CM");
            } else if (num >= 500) {
                num -= 500;
                res.append("D");
            } else if (num >= 400) {
                num -= 400;
                res.append("CD");
            } else if (num >= 100) {
                num -= 100;
                res.append("C");
            } else if (num >= 90) {
                num -= 90;
                res.append("XC");
            } else if (num >= 50) {
                num -= 50;
                res.append("L");
            } else if (num >= 40) {
                num -= 40;
                res.append("XL");
            } else if (num >= 10) {
                num -= 10;
                res.append("X");
            } else if (num == 9) {
                num -= 9;
                res.append("IX");
            } else if (num >= 5) {
                num -= 5;
                res.append("V");
            } else if (num == 4) {
                num -= 4;
                res.append("IV");
            } else {
                num -= 1;
                res.append("I");
            }
        }
        return res.toString();
    }
}
