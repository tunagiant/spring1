package hello.core.singleton;

public class SingletonService {

    // 자기자신을 가지고있음
    private static final SingletonService instance = new SingletonService();

    // getter
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자 private으로 해서 다른 클래스에서 생성할 수 없도록 만듬
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
