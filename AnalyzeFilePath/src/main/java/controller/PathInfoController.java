
package controller;

import java.io.File;
import java.util.Scanner;
import model.PathInfo;
import view.PathInfoView;

public class PathInfoController {
    private final Scanner scanner;
    private final PathInfoView view;

    public PathInfoController(Scanner scanner, PathInfoView view) {
        this.scanner = scanner;
        this.view = view;
    }

    public void checkInputPath() {
        System.out.print("Please input Path: ");
        String path = checkInputString();
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            PathInfo pathInfo = new PathInfo(
                    getDisk(path),
                    getExtension(path),
                    getFileName(path),
                    getFolder(path),
                    path
            );
            view.displayPathInfo(pathInfo);
        } else {
            view.displayErrorMessage("Path isn't file.");
        }
    }

    private String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.length() == 0) {
                view.displayErrorMessage("Not empty.");
            } else {
                return result;
            }
        }
    }

    private String getPath(String path) {
        int fromDisk = path.indexOf("\\");
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(fromDisk + 1, toNameFile);
    }

    private String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    private String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot, path.length());
    }

    private String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon + 1);
    }

    private String getFolder(String path) {
        int positionSlash = path.lastIndexOf("\\");
        String folderPath = path.substring(0, positionSlash);
        int positionSlashInFolder = folderPath.lastIndexOf("\\");
        return folderPath.substring(positionSlashInFolder + 1, positionSlash);
    }
}



