package Lesson6.View;

import java.util.Scanner;

public class View {
    public void print(String str) {
        System.out.println(str);
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
