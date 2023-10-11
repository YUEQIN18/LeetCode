package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 注意:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();

        for (String word : words) {
            // 计算Line的长度
            int len = getTotalLength(line);
            // 已经装不下这个word，这个line已经确定，填充空格
            if (len + word.length() + 1 > maxWidth) {
                StringBuilder sb = new StringBuilder();
                // 先均匀分配空格，如果不能均匀分配，左侧的空格数要比右边多
                int remainWidth = maxWidth - getWordsLength(line); //还剩多少长度
                int remainSpace = line.size() - 1; // 还有多少个位置
                // 只有一个单词，应该左对齐
                if (line.size() == 1) {
                    int n = maxWidth - line.get(0).length();
                    sb.append(line.get(0));
                    sb.append(new String(new char[n]).replace("\0", " "));
                } else if (remainWidth % remainSpace == 0) {
                    int n = remainWidth / remainSpace;
                    for (int i = 0; i < line.size(); i++) {
                        sb.append(line.get(i));
                        if (i != line.size() - 1) {
                            sb.append(new String(new char[n]).replace("\0", " "));
                        }
                    }
                } else {
                    int n = remainWidth / remainSpace;
                    int remain = remainWidth % remainSpace; // 余数，每次添加的空格应该是n + 1，直到余数被耗尽，这样保证均匀
                    for (int i = 0; i < line.size(); i++) {
                        sb.append(line.get(i));
                        if (i != line.size() - 1) {
                            int n1 = n;
                            if (remain > 0) {
                                n1 = n + 1;
                            }
                            sb.append(new String(new char[n1]).replace("\0", " "));
                            remain--;
                        }
                    }
                }
                res.add(sb.toString());
                // 清空Line, 添加word
                line.clear();
                line.add(word);
            } else {
                line.add(word); // 能装下这个word
            }
        }
        // 最后一行，左对齐
        if (!line.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.get(i));
                if (i != line.size() - 1) {
                    sb.append(" ");
                }
            }
            int n = maxWidth - sb.length();
            if (n > 0) {
                sb.append(new String(new char[n]).replace("\0", " "));
            }
            res.add(sb.toString());
        }
        return res;
    }

    private int getTotalLength(List<String> line) {
        int len = getWordsLength(line);
        // 加上空格
        len += line.size() - 1;
        return len;
    }

    private int getWordsLength(List<String> line) {
        int len = 0;
        for (String s : line) {
            len += s.length();
        }
        return len;
    }
}
