package com.wangwei.java8.utils;

/**
 * @author: wangwei
 * @date: 2019-09-09 14:50
 */
public class StringUtil {
    public static void main(String[] args) {
        String str = "{\n" +
                "    \"applyNo\": \"161201254785782\",\n" +
                "    \"applyTime\": \"20161201163114\",\n" +
                "    \"businessType\": \"JT\",\n" +
                "    \"userInfo\": {\n" +
                "        \"username\": \"小亮亮\",\n" +
                "        \"certType\": \"10100\",\n" +
                "        \"pin\": \"jdpin\",\n" +
                "        \"certNo\": \"110210198301011122\",\n" +
                "        \"userTel\": \"12312124563\",\n" +
                "        \"address\": \"北京市XX银行分行\",\n" +
                "        \"applyAmount\": \"900000\", \n" +
                "        \"interestRate\": \"0.0005\",\n" +
                "        \"activateTag\": \"ACTIVATED\"\n" +
                "    },\n" +
                "    \"riskInfo\": {\n" +
                "        \"creditData\": {\n" +
                "            \"btProperty\": \"-1\"\n" +
                "        } \n" +
                "    }\n" +
                "}";

        String s = str.replaceAll(" ", "");

        System.out.println(s);
    }
}
