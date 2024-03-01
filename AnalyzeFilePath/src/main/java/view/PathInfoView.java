package view;

import model.PathInfo;

public class PathInfoView {
    public void displayPathInfo(PathInfo pathInfo) {
        System.out.println("Disk: " + pathInfo.getDisk());
        System.out.println("Extension: " + pathInfo.getExtension());
        System.out.println("File name: " + pathInfo.getFileName());
        System.out.println("Folder: " + pathInfo.getFolder());
        System.out.println("Path: " + pathInfo.getPath());
    }

    public void displayErrorMessage(String message) {
        System.err.println(message);
    }
}