package junit5;

public class Gentlemen {

    public String sayHello(String name) {
        if (name == null)
            return "Hello Anonymus";
        else
            return "Hello " + name;
    }

}
