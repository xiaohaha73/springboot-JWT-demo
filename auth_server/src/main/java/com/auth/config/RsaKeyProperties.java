package com.auth.config;

// 私钥和公钥配置类，用来导入application.yml中的配置项

import com.myjwt.utils.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

@ConfigurationProperties(prefix = "rsa.key")
public class RsaKeyProperties {
    // 公钥和私钥的存储路径
    private String privateFilePath;
    private String publicFilePath;

    // 生成的公钥和私钥
    private PublicKey publicKey;
    private PrivateKey privateKey;


    // 构造函数加载完毕之后生成私钥公钥
    @PostConstruct
    private void createRsaKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(publicFilePath);
        privateKey = RsaUtils.getPrivateKey(privateFilePath);
    }


    public String getPrivateFilePath() {
        return privateFilePath;
    }

    public void setPrivateFilePath(String privateFilePath) {
        this.privateFilePath = privateFilePath;
    }

    public String getPublicFilePath() {
        return publicFilePath;
    }

    public void setPublicFilePath(String publicFilePath) {
        this.publicFilePath = publicFilePath;
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
