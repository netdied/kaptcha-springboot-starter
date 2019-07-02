package com.kapctha.start.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author xingzi
 * @date 2019 07 02  11:04
 */
@Component
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix ="kaptcha")
public class KaptchaProperties {

    private String border = "no";
    private String borderColor = "black";
    private Integer borderThickness = 1;
    private Integer width = 140;
    private Integer height = 40;

    private String producerImpl = "com.google.code.kaptcha.impl.DefaultKaptcha";
    private String textProducerImpl="com.google.code.kaptcha.text.impl.DefaultTextCreator";
    private String textProducerCharString="abcde2345678gfynmnpwx";
    private Integer length = 5;
    private String fontNames = "Arial, Courier";

    private String fontSize= "14";
    private String fontColor = "blue";
    private Integer fontSpace= 2;
    private String noiseImpl ="com.google.code.kaptcha.impl.NoNoise";
    private String noiseColor = "white";

    private String obscurificatorImpl = "com.google.code.kaptcha.impl.ShadowGimpy";
    private String backgroundImpl ="com.google.code.kaptcha.impl.DefaultBackground";
    private String clearFrom = "194,229,156";
    private String clearTo = "100,179,244";
    private String wordImpl = "com.google.code.kaptcha.text.impl.DefaultWordRenderer";

    private String sessionKey = "KAPTCHA_SESSION_KEY";
    private String sessionDate = "KAPTCHA_SESSION_DATE";
}
