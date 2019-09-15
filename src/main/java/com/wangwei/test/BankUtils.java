package com.wangwei.test;

/**
 * @author: wangwei
 * @date: 2019-09-15 15:21
 */
public class BankUtils {

    public static String getBankName(String card){

        String urlString = new StringBuilder().append("https://ccdcapi.alipay.com/validateAndCacheCardInfo.json")
                .append("?cardNo=")
                .append(card)
                .append("cardBinCheck=true").toString();


        return "";
    }

    public static String getBankLogo(){
        return "";
    }
}
