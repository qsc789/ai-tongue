package com.mxjsxz.demo.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * aes工具类
 *
 * @author xuwenbing
 * @date 2019-06-12
 */
public class AesSimpleUtil {
    // 对于Java中AES的默认模式是：AES/ECB/PKCS5Padding
    private static final String AES = "AES";

    /**
     * 加密
     *
     * @param source    源字符串
     * @param keyBase64 keyBase64
     * @return 加密的字符串
     * @throws Exception
     */
    public static String encrypt(String source, String keyBase64) throws Exception {
        // 获取secretKey
        byte[] keyBytes = Base64.getDecoder().decode(keyBase64.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, AES);
        // 数据加密
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptBytes = cipher.doFinal(source.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptBytes);
    }

    /**
     * 解密
     *
     * @param encrypted 加密的字符串
     * @param keyBase64 keyBase64
     * @return 源字符串
     * @throws Exception
     */
    public static String decrypt(String encrypted, String keyBase64) throws Exception {
        // 获取secretKey
        byte[] keyBytes = Base64.getDecoder().decode(keyBase64.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, AES);
        // 数据解密
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decryptBytes, StandardCharsets.UTF_8);
    }
}
