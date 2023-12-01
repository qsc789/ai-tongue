package com.mxjsxz.demo.utils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * rsa工具类
 *
 * @author xuwenbing
 * @date 2019-06-12
 */
public class RsaSimpleUtil {
    private static final String RSA = "RSA";
    private static final String MD5withRSA = "MD5withRSA";

    /**
     * 加密
     *
     * @param source
     * @param publicKeyBase64
     * @return
     */
    public static String encrypt(String source, String publicKeyBase64) throws Exception {
        // 获取publicKey
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64.getBytes(StandardCharsets.UTF_8));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        // 数据加密
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptBytes = cipher.doFinal(source.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptBytes);
    }

    /**
     * 解密
     *
     * @param encrypted
     * @param privateKeyBase64
     * @return
     */
    public static String decrypt(String encrypted, String privateKeyBase64) throws Exception {
        // 获取privateKey
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64.getBytes(StandardCharsets.UTF_8));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        // 解密数据
        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decryptBytes, StandardCharsets.UTF_8);
    }

    /**
     * 签名
     *
     * @param source
     * @param privateKeyBase64
     * @return
     */
    public static String sign(String source, String privateKeyBase64) throws Exception {
        // 获取privateKey
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64.getBytes(StandardCharsets.UTF_8));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        // 签名
        Signature signature = Signature.getInstance(MD5withRSA);
        signature.initSign(privateKey);
        signature.update(source.getBytes(StandardCharsets.UTF_8));
        byte[] signed = signature.sign();
        return Base64.getEncoder().encodeToString(signed);
    }

    /**
     * 验签
     *
     * @param source
     * @param signed
     * @param publicKeyBase64
     * @return
     */
    public static boolean verify(String source, String signed, String publicKeyBase64) throws Exception {
        // 获取publicKey
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64.getBytes(StandardCharsets.UTF_8));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        // 验签
        Signature signature = Signature.getInstance(MD5withRSA);
        signature.initVerify(publicKey);
        signature.update(source.getBytes(StandardCharsets.UTF_8));
        boolean verify = signature.verify(Base64.getDecoder().decode(signed));
        return verify;
    }
}
