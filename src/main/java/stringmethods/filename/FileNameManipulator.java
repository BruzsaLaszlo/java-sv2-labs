package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        String[] s = fileName.split("[.]");
        return s[s.length - 1];
    }

    public boolean identifyFilesByExtension(String ext, String fileName){
        return fileName.endsWith(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        return searchedFileName.equals(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName) {
        return findFileExtension(fileName).toLowerCase();
    }

    public String replaceStringPart(String fileName, String present, String target) {
        return fileName.replace(target, present);
    }

    public static void main(String[] args) {

        FileNameManipulator fnm = new FileNameManipulator();
        System.out.println(fnm.changeExtensionToLowerCase("explorer.EXE"));
        System.out.println(fnm.compareFilesByName("table.xls","pom.xml"));
        System.out.println(fnm.findFileExtension("WiFiScan.ino"));
        System.out.println(fnm.findLastCharacter("platformio.ini"));
        System.out.println(fnm.replaceStringPart("README.MD", "WRITE", "READ"));
        System.out.println(fnm.identifyFilesByExtension("class","FileManipulator.class"));

    }

}
