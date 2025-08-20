package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 어디서부터 Component를 찾을지 지정
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // CompnentScan할 것 중 뺄 것을 지정
        // 결과적으로 수동으로 설정한 AppConfig.class를 제외시킴
)
public class AutoAppConfig {
}
