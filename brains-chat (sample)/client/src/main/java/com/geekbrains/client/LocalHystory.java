package com.geekbrains.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LocalHystory {
    public static void saveMesInFile(String log, String msg) {
    try {
        Files.write(getPath(log), msg.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private static Path getPath(String log) {
        Path hystoryPath = Paths.get("history","hystory_" + log + ".txt");
        if(Files.notExists(hystoryPath.getParent())) {
            try {
                Files.createDirectories(hystoryPath.getParent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hystoryPath;
    }
}
