package com.kapctha.start.config;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.kapctha.start.properties.KaptchaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author xingzi
 * @date 2019 07 02  10:28
 */
@Configuration
@ConditionalOnClass(DefaultKaptcha.class)
@EnableConfigurationProperties(KaptchaProperties.class)
public class KaptchaConfig implements DisposableBean {

    private final KaptchaProperties kaptchaProperties;

    public KaptchaConfig(KaptchaProperties properties) {
        this.kaptchaProperties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Config config = new Config(setProperties());
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    @Override
    public void destroy() throws Exception {

    }

    public Properties setProperties(){

        Properties properties = new Properties();
        properties.setProperty("kaptcha.border",this.kaptchaProperties.getBorder());
        properties.setProperty("kaptcha.border.color",this.kaptchaProperties.getBorderColor());
        properties.setProperty("kaptcha.image.width",this.kaptchaProperties.getWidth().toString());
        properties.setProperty("kaptcha.image.height",this.kaptchaProperties.getHeight().toString());
        properties.setProperty("kaptcha.producer.impl",this.kaptchaProperties.getProducerImpl());

        properties.setProperty("kaptcha.border.thickness",this.kaptchaProperties.getBorderThickness().toString());
        properties.setProperty("kaptcha.textproducer.impl",this.kaptchaProperties.getTextProducerImpl());
        properties.setProperty("kaptcha.textproducer.char.string",this.kaptchaProperties.getTextProducerCharString());
        properties.setProperty("kaptcha.textproducer.char.length",this.kaptchaProperties.getLength().toString());
        properties.setProperty("kaptcha.textproducer.font.names",this.kaptchaProperties.getFontNames());

        properties.setProperty("kaptcha.textproducer.font.size",this.kaptchaProperties.getFontSize());
        properties.setProperty("kaptcha.textproducer.font.color",this.kaptchaProperties.getFontColor());
        properties.setProperty("kaptcha.textproducer.char.space",this.kaptchaProperties.getFontSpace().toString());
        properties.setProperty("kaptcha.obscurificator.impl",this.kaptchaProperties.getObscurificatorImpl());
        properties.setProperty("kaptcha.background.impl",this.kaptchaProperties.getBackgroundImpl());

        properties.setProperty("kaptcha.background.clear.from",this.kaptchaProperties.getClearFrom());
        properties.setProperty("kaptcha.noise.impl",this.kaptchaProperties.getNoiseImpl());
        properties.setProperty("kaptcha.noise.color",this.kaptchaProperties.getNoiseColor());
        properties.setProperty("kaptcha.background.clear.to",this.kaptchaProperties.getClearTo());
        properties.setProperty("kaptcha.word.impl",this.kaptchaProperties.getWordImpl());

        properties.setProperty("kaptcha.session.key",this.kaptchaProperties.getSessionKey());
        properties.setProperty("kaptcha.session.date",this.kaptchaProperties.getSessionDate());

        return properties;
    }

}
