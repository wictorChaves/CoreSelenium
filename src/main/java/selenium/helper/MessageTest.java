package selenium.helper;

public class MessageTest extends Message {

    public static void show(boolean test, String textTest) {
        Message.text(textTest + ": ");
        if (test)
            Message.success("OK");
        else
            Message.error("FAIL");
        System.out.println();
    }

}
