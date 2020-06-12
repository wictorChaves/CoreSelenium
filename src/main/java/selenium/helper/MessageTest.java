package selenium.helper;

public class MessageTest extends Message {

    public static void show(boolean test, String textTest) {
        Message.Text(textTest + ": ");
        if (test)
            Message.Success("OK");
        else
            Message.Error("FAIL");
        System.out.println();
    }

}
