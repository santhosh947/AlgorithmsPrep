public class NameTheFile {

    public static void main(String[] args) {
        System.out.println("hi");
        String fileName = RenameFile("17. Letter Combinations of a Phone Number        ");

        System.out.println(fileName);
        System.out.println(fileName + ".java");

    }

    private static String RenameFile(String fileName) {
        String renamed_fileName = "L";
        fileName = fileName.replace(" ", "");
        fileName = fileName.replace(".", "");
        renamed_fileName = renamed_fileName + fileName;
        return renamed_fileName;
    }
}
