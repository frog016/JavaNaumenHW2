package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class SyncFileVisitor implements FileVisitor<Path> {
    private final Path fromFolder;
    private final Path toFolder;

    public SyncFileVisitor(Path fromFolder, Path toFolder) {
        this.fromFolder = fromFolder;
        this.toFolder = toFolder;
    }

    @Override
    public FileVisitResult visitFile(Path sourceFile, BasicFileAttributes attrs) throws IOException {
        Path targetFile = toFolder.resolve(fromFolder.relativize(sourceFile));

        if (Files.notExists(targetFile) || !Files.isSameFile(sourceFile, targetFile)) {
            Files.createDirectories(targetFile.getParent());
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Sync file: " + targetFile + " with " + sourceFile);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path sourceDirectory, BasicFileAttributes attrs) throws IOException {
        Path targetDirectory = toFolder.resolve(fromFolder.relativize(sourceDirectory));

        if (Files.notExists(targetDirectory)) {
            Files.createDirectories(targetDirectory);
            System.out.println("Sync directory: " + targetDirectory + " with " + sourceDirectory);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
