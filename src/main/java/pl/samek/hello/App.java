package pl.samek.hello;

public class App {
    public static void main(String[] args) {
        var name = "Piotrek";

        System.out.println(String.format("Hello %s", name));

        int a = 2;
        int b = 3;

        System.out.println(a);
        System.out.println(b);
        System.out.println("My resoult: ");
        var result = a+b;
        System.out.println(result);
        if (result != 5){
            throw new IllegalStateException("assertion detected");
        }
    }
}
