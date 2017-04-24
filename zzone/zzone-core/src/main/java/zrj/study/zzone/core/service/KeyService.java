package zrj.study.zzone.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import zrj.study.zzone.core.entity.Key;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/24
 */
@Service
@Transactional(readOnly = true)
public class KeyService {



    public Key get(String macId) {
        return null;
    }


    public Key generate(String macId) {
        return null;
    }


    /**
     * 测试方法
     */
    public static void main(String[] args) throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.genKeyPair();// 生成密钥对
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();// 创建公钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();// 创建私钥


        byte[] pukBytes = keyPair.getPublic().getEncoded();
        publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(pukBytes));
        byte[] prkBytes = keyPair.getPrivate().getEncoded();
        privateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(prkBytes));


        // 加密
        BigInteger e = publicKey.getPublicExponent();//返回此公钥的指数
        BigInteger n1 = publicKey.getModulus();//返回此公钥的模
        String string = "asdfasdS";
        byte bt[] = string.getBytes("UTF8");
        BigInteger bit = new BigInteger(bt);
        System.out.println("原文bigInteger：" + bit);
        BigInteger mi = bit.modPow(e, n1);//生成密文
        System.out.println("密文bigInteger：" + mi);


//        String a = Base64.getEncoder().encodeToString(mi.toByteArray());
//        System.out.println("原长：" + mi.toString().length());
//        System.out.println("Base64长：" + a.length());
//        System.out.println(new BigInteger(Base64.getDecoder().decode(a)));

        // 解密
        BigInteger d = privateKey.getPrivateExponent();//返回此公钥的指数
        BigInteger n2 = privateKey.getModulus();//返回此公钥的模
        BigInteger jie = mi.modPow(d, n2);//进行解密操作
        System.out.println("原文bigInteger：" + jie);
        System.out.println(new String(jie.toByteArray(), "UTF8"));


        //
        Cipher c1 =Cipher.getInstance("RSA");
        c1.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = c1.doFinal("钟如劼".getBytes("UTF-8"));

        Cipher c2 =Cipher.getInstance("RSA");
        c2.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] output = c2.doFinal(cipherText);
        System.out.println(new String(output, "UTF-8"));


    }


}
