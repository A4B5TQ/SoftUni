public class Main {
    public static void main(String[] args) {
        StudentsRepository.initializeData();
        StudentsRepository.getStudentsByCourse("Unity");
        IOManager.createDirectoryInCurrentFoldeer("pesho");
    }
}
