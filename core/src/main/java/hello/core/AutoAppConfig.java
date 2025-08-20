package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // CompnentScan할 것 중 뺄 것을 지정
        // 결과적으로 수동으로 설정한 AppConfig.class를 제외시킴
)
public class AutoAppConfig {
}
