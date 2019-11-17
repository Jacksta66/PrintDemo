package au.net.jacksta.demo.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

public class FileUtil {
    // Credit to aioobe on stack overflow : https://stackoverflow.com/users/276052/aioobe
    // https://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java
    public static String getHumanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    public static String getLastUpdated(Path file) {

        String dateCreated;

        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            FileTime date = attr.lastModifiedTime();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss a");
            dateCreated = df.format(date.toMillis());
        } catch (IOException e) {
            e.printStackTrace();
            return "unknown";
        }

        return dateCreated;
    }


}
