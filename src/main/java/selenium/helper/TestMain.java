package selenium.helper;

public class TestMain {

    public static void check(boolean test, String testLabel) {
        Message.text("[ ");
        if (test) {
            Message.success("OK");
        } else {
            Message.error("FAIL");
        }
        Message.text(" ]");
        Message.text(" " + testLabel);
        Message.breakLine();
    }

}
