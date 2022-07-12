package com.ethen.nowcoder.api;

/**
 * 字符串相关操作
 *
 * @author ethenyang@126.com
 * @since 2022/07/10
 */
public class StringTest {
    public static void main(String[] args) {
        String origin = "Hello12345,广州、深圳！@#￥%&*（）ASDFGJKL;";

        char[] charArray = origin.toCharArray();

        System.err.println("length:" + origin.length());
        System.err.println("bytesLength:" + origin.getBytes().length);

        System.err.println(charArray);
    }
}
