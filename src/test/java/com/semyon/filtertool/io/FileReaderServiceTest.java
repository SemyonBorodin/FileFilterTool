package com.semyon.filtertool.io;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderServiceTest {
    @Test
    void fileReaderTest() throws IOException {
        List<String> result = FileReaderService.readFile(new String[]{"in1.txt", "in2.txt"});
        System.out.println("List<String> для последующей обработки выглядит так:");
        result.forEach(System.out::println);

        assertEquals(17, result.size());
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
    }
}
