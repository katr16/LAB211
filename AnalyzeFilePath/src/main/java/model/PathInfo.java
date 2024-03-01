package model;
import java.io.File;
import java.util.Scanner;

// Model
public class PathInfo {
    private final String disk;
    private final String extension;
    private final String fileName;
    private final String folder;
    private final String path;

    public PathInfo(String disk, String extension, String fileName, String folder, String path) {
        this.disk = disk;
        this.extension = extension;
        this.fileName = fileName;
        this.folder = folder;
        this.path = path;
    }

    public String getDisk() {
        return disk;
    }

    public String getExtension() {
        return extension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFolder() {
        return folder;
    }

    public String getPath() {
        return path;
    }
}