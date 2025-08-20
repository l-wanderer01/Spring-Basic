package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);// 빈 조회
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);// 빈 조회

        // ThreadA : A 사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB : B 사용자가 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA : 사용자 A 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price); // 만원이 조회될 것을 기대하지만 2만원이 조회됨

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}