package v11.helper;

import java.util.Scanner;

public class KioskConsoleIOHandler implements IOHandler {

    Scanner sc = new Scanner(System.in);

    @Override
    public String readInput() {
        return sc.nextLine();
    }

    @Override
    public void writeOutput(String data) {
        System.out.println(data);
    }
}
