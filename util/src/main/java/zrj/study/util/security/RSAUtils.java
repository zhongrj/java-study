package zrj.study.util.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加解密工具
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
public class RSAUtils {


    public static final String KEY_ALGORITHM = "RSA";
    public static final String BC_PROVIDER = "BC";

    static {
        /**
         * 执行后才能
         * KeyFactory.getInstance(KEY_ALGORITHM);
         * KeyFactory.getInstance(KEY_ALGORITHM);
         */
        Security.addProvider(new BouncyCastleProvider());
    }

    // ---------------------------------------------------------------  生成密钥  ---------------------------------------------------------------

    /**
     * 好像两种并没什么区别
     **/
    public static KeyPair newKeyPair(boolean isUseBC) throws Exception {
        KeyPairGenerator keyPairGenerator;
        if (isUseBC) {
            keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM, BC_PROVIDER);
        } else {
            keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        }
        return keyPairGenerator.genKeyPair();
    }


    // ---------------------------------------------------------------  加密方法  ---------------------------------------------------------------

    public static byte[] encrypt(byte[] srcData, byte[] keyBytes) throws Exception {
        return encrypt(srcData, keyBytes, false);
    }

    public static byte[] encrypt(byte[] srcData, RSAPublicKey publicKey) throws Exception {
        return encrypt(srcData, publicKey, false);
    }

    public static byte[] encryptUseBC(byte[] srcData, byte[] keyBytes) throws Exception {
        return encrypt(srcData, keyBytes, true);
    }

    public static byte[] encryptUseBC(byte[] srcData, RSAPublicKey publicKey) throws Exception {
        return encrypt(srcData, publicKey, true);
    }

    /**
     * 根据公钥encoded加密
     *
     * @param srcData  原数据
     * @param keyBytes 公钥encoded
     * @return 密文
     * @throws Exception
     */
    public static byte[] encrypt(byte[] srcData, byte[] keyBytes, boolean isUseBC) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = createKeyFactory(isUseBC);
        RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);

        return encrypt(srcData, publicKey, isUseBC);
    }

    /**
     * 根据公钥对象加密
     *
     * @param srcData   原数据
     * @param publicKey 公钥对象
     * @return 密文
     */
    public static byte[] encrypt(byte[] srcData, RSAPublicKey publicKey, boolean isUseBC) throws Exception {

        Cipher cipher = createCipher(isUseBC);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(srcData);
    }


    // ---------------------------------------------------------------  解密方法  ---------------------------------------------------------------

    public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes) throws Exception {
        return decrypt(encryptedData, keyBytes, false);
    }

    public static byte[] decrypt(byte[] encryptedData, RSAPrivateKey privateKey) throws Exception {
        return decrypt(encryptedData, privateKey, false);
    }

    public static byte[] decryptUseBC(byte[] encryptedData, byte[] keyBytes) throws Exception {
        return decrypt(encryptedData, keyBytes, true);
    }

    public static byte[] decryptUseBC(byte[] encryptedData, RSAPrivateKey privateKey) throws Exception {
        return decrypt(encryptedData, privateKey, true);
    }

    /**
     * 根据私钥encoded解密
     *
     * @param encryptedData 密文
     * @param keyBytes      私钥encoded
     * @return 明文
     * @throws Exception
     */
    public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes, boolean isUseBC) throws Exception {

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = createKeyFactory(isUseBC);
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        return decrypt(encryptedData, privateKey, isUseBC);
    }


    /**
     * 根据私钥对象解密
     *
     * @param encryptedData 密文
     * @param privateKey    私钥对象
     * @return
     */
    public static byte[] decrypt(byte[] encryptedData, RSAPrivateKey privateKey, boolean isUseBC) throws Exception {

        Cipher cipher = createCipher(isUseBC);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encryptedData);
    }


    // ---------------------------------------------------------------  公用方法  ---------------------------------------------------------------

    private static KeyFactory createKeyFactory(boolean isUseBC) throws Exception {
        if (isUseBC) {
            return KeyFactory.getInstance(KEY_ALGORITHM, BC_PROVIDER);
        }
        return KeyFactory.getInstance(KEY_ALGORITHM);
    }

    private static Cipher createCipher(boolean isUseBC) throws Exception {
        if (isUseBC) {
            return Cipher.getInstance("RSA/None/PKCS1Padding", BC_PROVIDER);
        }
        return Cipher.getInstance(KEY_ALGORITHM);
    }


    // ---------------------------------------------------------------  测试方法  ---------------------------------------------------------------


    public static void main(String[] args) throws Exception {
        String srcText = "钟如劼";

        KeyPair keyPair = newKeyPair(true);// 生成密钥对

        // 加密
        byte[] encryptedData = encrypt(srcText.getBytes("UTF-8"), (RSAPublicKey) keyPair.getPublic());
        // Cipher解密
        byte[] srcData = decrypt(encryptedData, (RSAPrivateKey) keyPair.getPrivate());

        System.out.println(new String(srcData, "UTF-8"));


        // 加密useBC
        byte[] encryptedDataBC = encryptUseBC(srcText.getBytes("UTF-8"), keyPair.getPublic().getEncoded());
        // Cipher解密useBC
        byte[] srcDataBC = decryptUseBC(encryptedDataBC, keyPair.getPrivate().getEncoded());

        System.out.println(new String(srcDataBC, "UTF-8"));

    }

}
