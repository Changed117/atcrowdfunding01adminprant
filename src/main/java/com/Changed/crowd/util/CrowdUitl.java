package com.Changed.crowd.util;

import com.Changed.crowd.constat.CrowdConstant;
import sun.plugin2.message.Message;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrowdUitl {

    /**
     * md5加密工具类
     * @param source 传入的明文字符串
     * @return 返回的结果
     */
    public static String md5(String source){
        // 1.判断source是否有效
        if (source == null || source.length() == 0){

            // 2.如果不是有效抛出异常
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }

        try {
            // 3.获取MessageDigest对象
            String algorithm = "md5";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // 4.获取明文对应字节数组
            byte[] input = source.getBytes();

            // 5.执行加密
            byte[] output = messageDigest.digest(input);

            // 6.创建bigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);

            // 7.按照16进制将bigInteger对象转换为字符串
            int radix = 16;
            String encoded = bigInteger.toString(radix).toUpperCase();

            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 判断当前请求是否是Ajax请求
     * @param request 请求对象
     * @return
     *          true:是Ajax
     *          false：不是Ajax
     */
    public static boolean judgeRequestType(HttpServletRequest request){
        String accept = request.getHeader("Accept");
        String xRequested = request.getHeader("X-Requested-With");

        return (accept != null && accept.contains("application/json"))
                ||
                (xRequested != null && xRequested.equals("XMLHttpRequest"));
    }

}
