package com.qhh.rsademo;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author qinhaihang
 * @version $Rev$
 * @time 19-5-13 下午9:15
 * @des
 * @packgename com.qhh.rsademo
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes
 */
public class AESUtils {

    public static final String AES = "AES";
    public static final String WORK_MODEL = "AES/CBC/PKCS5PADDING";

    public static byte[] getRandomKey(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(keySize);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return encoded;
    }

    /**
     * 加密
     * @param content
     * @return
     */
    public static byte[] encrypt(String content,byte[] secrectKey) throws Exception {
        // 创建AES秘钥
        SecretKeySpec key = new SecretKeySpec(secrectKey, WORK_MODEL);
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 初始化加密器
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 加密
        return cipher.doFinal(content.getBytes("UTF-8"));
    }

    public static byte[] decrypt(byte[] content, byte[] secrectKey) throws Exception {
        // 创建AES秘钥
        SecretKeySpec key = new SecretKeySpec(secrectKey, WORK_MODEL);
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 初始化解密器
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 解密
        return cipher.doFinal(content);
    }
}
