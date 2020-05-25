package leetcode.example.string;

/**
 * 字符串查询
 *
 * @author xinghai
 */
public class StringSearch {

    /**
     * 查找最小无重复字符的字串长度
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     *
     * 测试：
     * abcabcbb: 3
     * abcabcdef : 6
     * aab: 2
     * dvdf: 3
     * bbbbb: 1
     * pwwkew: 3
     *
     * @param s 传入字符串
     * @return 字串长度
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        String string = "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars[0]);
        // 可以理解为滑动窗口法
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            String tmpStr = stringBuilder.toString();
            int index = tmpStr.indexOf(aChar);
            if (index >= 0) {
                if (string.length() < tmpStr.length()) {
                    // 保存当前字符串到上一次字符串，方便跟下次的字串长度比较
                    string = tmpStr;
                }

                stringBuilder = new StringBuilder();
                if (index < tmpStr.length() - 1) {
                    stringBuilder.append(tmpStr.substring(index+1));
                }
            }
            stringBuilder.append(aChar);
        }

        return Math.max(stringBuilder.length(), string.length());
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("abcabcdef : " + lengthOfLongestSubstring("abcabcdef"));
        System.out.println("aab: " + lengthOfLongestSubstring("aab"));
        System.out.println("dvdf: " + lengthOfLongestSubstring("dvdf"));
        System.out.println("bbbbb: " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew: " + lengthOfLongestSubstring("pwwkew"));
    }

}
