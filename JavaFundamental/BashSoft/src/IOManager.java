import java.io.File;
import java.util.LinkedList;

public class IOManager {

    public static void traverseFolder(int depth){
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;
        File root = new File(path);
        subFolders.add(root);

        while (subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();
            int currentIdentation = currentFolder.toString().split("\\\\").length - initialIndentation;

            if (depth - currentIdentation < 0)
                break;

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null){
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()){
                        subFolders.add(file);
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");

                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }
            System.out.println(currentFolder.toString());
        }
    }

    public static void createDirectoryInCurrentFoldeer(String name){
        String path = getCurrentDirectoryPath() + "\\" + name;

        File file = new File(path);
        file.mkdir();
    }

    private static String getCurrentDirectoryPath() {

        return SessionData.currentPath;
    }

    public static void changeCurrentDirRelativePath(String relativPath){

        if (relativPath.equals("..")){
            String currentPath = SessionData.currentPath;
            int indexOfLastSlash = currentPath.lastIndexOf("\\");
            String newPath = currentPath.substring(0,indexOfLastSlash);
            SessionData.currentPath = newPath;
        } else {
            String currentPath = SessionData.currentPath;

            currentPath += "\\" + relativPath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    private static void changeCurrentDirAbsolute(String absolutePath) {

        File file = new File(absolutePath);

        if (!file.exists()){
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }
}
