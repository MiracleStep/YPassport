package com.mirac.main.ypassport.config;

import com.mirac.main.ypassport.utils.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

@ConfigurationProperties(prefix = "ypassport.key")
public class JwtProperties {
    private String privateKeyPath;
    private String publicKeyPath;
    private int expire;// token过期时间
    private String cookieName;

    private PublicKey publicKey;
    private PrivateKey privateKey;
    @PostConstruct
    public void init(){
        try {
            File pubKey = new File(publicKeyPath);
            File priKey = new File(privateKeyPath);
            if (!pubKey.exists() || !priKey.exists()) {
                // 生成公钥和私钥
                RsaUtils.generateKey(publicKeyPath, privateKeyPath, "123");
            }
            // 获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey(publicKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(privateKeyPath);
        } catch (Exception e) {

            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "JwtProperties{" +
                "privateKeyPath='" + privateKeyPath + '\'' +
                ", publicKeyPath='" + publicKeyPath + '\'' +
                ", expire=" + expire +
                ", cookieName='" + cookieName + '\'' +
                ", publicKey=" + publicKey +
                ", privateKey=" + privateKey +
                '}';
    }

    public String getPrivateKeyPath() {
        return privateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }

    public String getPublicKeyPath() {
        return publicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        this.publicKeyPath = publicKeyPath;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
