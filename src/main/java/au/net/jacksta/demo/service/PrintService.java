package au.net.jacksta.demo.service;

import au.net.jacksta.demo.model.Print;

import java.nio.file.Path;
import java.util.List;

public interface PrintService {
    List<Print> getAdvicesForPrintHouse(Path sourceDir);
    boolean writeFiles(Path sourceDir, String tempDir);
}
