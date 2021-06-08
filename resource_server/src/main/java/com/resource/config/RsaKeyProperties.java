package com.resource.config;

// 公钥配置类，用来导入application.yml中的配置项

import com.myjwt.utils.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

@ConfigurationProperties(prefix = "rsa.key")
public class RsaKeyProperties {
    // 公钥的存储路径
    private String publicFilePath;

    // 生成的公钥
    private PublicKey publicKey;


    // 构造函数加载完毕之后生成私钥公钥
    @PostConstruct
    private void createRsaKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(publicFilePath);
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

}
