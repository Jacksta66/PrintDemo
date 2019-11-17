package au.net.jacksta.demo.model;

public class Print {

    public Print (String fileName, String fileSize, String fileLocation, String lastUpdated) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileLocation = fileLocation;
        this.lastUpdated = lastUpdated;
    }

    private String fileName;
    private String fileSize;
    private String fileLocation;
    private String lastUpdated;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Print{" +
                "fileName='" + fileName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileLocation='" + fileLocation + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
