package test.w2m.jfvTest.confi.errors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(name = "superheroes.errors.attributes", havingValue = "true")
@Configuration
public class WebErrorConfiguration {

    @Value("${superheroes.api.version}")
    private String currentApiVersion;
    @Value("${superheroes.sendreport.uri}")
    private String sendReportUri;

    /**
     * @return A custom implementation of ErrorAttributes
     */
    @Bean
    public ErrorAttributes errorAttributes() {
        return new SuperHeroAppErrorAttributes(currentApiVersion, sendReportUri);
    }

}
