package main.bg.softuni.interfaces;

import java.io.IOException;

public interface ContentComparer {
    void compareContent(String actualOutput, String expectedOutput) throws IOException;
}
