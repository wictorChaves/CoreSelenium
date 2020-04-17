package selenium.helper;

public class TestMain {

    public static void Check(boolean test, String testLabel) {
        Message.Text("[ ");
        if (test) {
            Message.Success("OK");
        } else {
            Message.Error("FAIL");
        }
        Message.Text(" ]");
        Message.Text(" " + testLabel);
        Message.BreakLine();
    }

}
