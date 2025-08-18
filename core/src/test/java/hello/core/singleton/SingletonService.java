package hello.core.singleton;

public class SingletonService {

    private static SingletonService instance = new SingletonService(); // 자기 자신을 내부의 private로 하나 가지고 있음

    // 조회 시 사용
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { // private 생성자

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
