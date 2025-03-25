package util;

public class ConsolePrint implements Print {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    public static ConsolePrint getInstance() {
        return SingletonPrint.INSTANCE;
    }

    static class SingletonPrint {
        static final ConsolePrint INSTANCE = new ConsolePrint();
    }
}
