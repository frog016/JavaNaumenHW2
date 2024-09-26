package org.example;

import java.io.IOException;
import java.nio.file.*;

public class SyncFilesTask implements Task {
    private final Path fromFolder;
    private final Path toFolder;

    private Thread thread;

    public SyncFilesTask(Path fromFolder, Path toFolder) {
        this.fromFolder = fromFolder;
        this.toFolder = toFolder;
    }

    @Override
    public void start() {
        thread = new Thread(() -> {
            try {
                Files.walkFileTree(fromFolder, new SyncFileVisitor(fromFolder, toFolder));
            } catch (IOException exception) {
                System.out.println("File sync error: " + exception.getMessage());
            }
        });

        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}

