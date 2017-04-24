package zrj.study.util.security;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加解密工具
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
public class RSAUtils {

    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 根据公钥encoded加密
     * @param srcData 原数据
     * @param keyBytes 公钥encoded
     * @return 密文
     * @throws Exception
     */
    public static byte[] encrypt(byte[] srcData, byte[] keyBytes) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(x509EncodedKeySpec);

        return encrypt(srcData, publicKey);
    }

    /**
     * 根据公钥对象加密
     * @param srcData 原数据
     * @param publicKey 公钥对象
     * @return 密文
     */
    public static byte[] encrypt(byte[] srcData, RSAPublicKey publicKey) throws Exception {
//        BigInteger e = publicKey.getPublicExponent();
//        BigInteger n = publicKey.getModulus();
//        BigInteger encryptedData = new BigInteger(srcData).modPow(e, n);

        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(srcData);
    }

    /**
     * 根据私钥encoded解密
     * @param encryptedData 密文
     * @param keyBytes 私钥encoded
     * @return 明文
     * @throws Exception
     */
    public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes) throws Exception {

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        RSAPrivateKey privateKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(pkcs8EncodedKeySpec);

        return decrypt(encryptedData, privateKey);
    }


    /**
     * 根据私钥对象解密
     * @param encryptedData 密文
     * @param privateKey 私钥对象
     * @return
     */
    public static byte[] decrypt(byte[] encryptedData, RSAPrivateKey privateKey) throws Exception {

//        BigInteger d = privateKey.getPrivateExponent();
//        BigInteger n = privateKey.getModulus();
//        BigInteger src = new BigInteger(encryptedData).modPow(d, n);

        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encryptedData);
    }


    public static void main(String[] args) throws Exception {
        String srcText = "钟如劼";

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        KeyPair keyPair = keyPairGenerator.genKeyPair();// 生成密钥对

        // 加密
        byte[] encryptedData = encrypt(srcText.getBytes("UTF-8"), (RSAPublicKey) keyPair.getPublic());

        // 解密
        byte[] srcData = decrypt(encryptedData, (RSAPrivateKey) keyPair.getPrivate());

        System.out.println(new String(srcData, "UTF-8"));
    }

}
