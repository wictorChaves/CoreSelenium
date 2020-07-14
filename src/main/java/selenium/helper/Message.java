package selenium.helper;

public class Message {

    private static final String ANSI_RESET  = "\u001B[0m";
    private static final String ANSI_BLACK  = "\u001B[30m";
    private static final String ANSI_RED    = "\u001B[31m";
    private static final String ANSI_GREEN  = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE   = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN   = "\u001B[36m";
    private static final String ANSI_WHITE  = "\u001B[37m";

    public static void text(String msg) {
        System.out.print(msg);
    }

    public static void breakLine() {
        System.out.println();
    }

    public static void success(String msg) {
        System.out.print(ANSI_GREEN + msg + ANSI_RESET);
    }

    public static void error(String msg) {
        System.out.print(ANSI_RED + msg + ANSI_RESET);
    }

}
