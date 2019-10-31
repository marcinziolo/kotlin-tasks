import java.util.Optional;

public class Extensions {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Some value");
//        optional.is
        ExtensionsKt.ifPresentOrElse(optional, System.out::println, () -> System.out.println("absent"));
        //TODO - Invoke extension function in Java
    }
}
