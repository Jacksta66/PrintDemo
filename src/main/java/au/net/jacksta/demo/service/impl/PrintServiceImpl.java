package au.net.jacksta.demo.service.impl;

import au.net.jacksta.demo.model.Print;
import au.net.jacksta.demo.service.PrintService;
import au.net.jacksta.demo.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public List<Print> getAdvicesForPrintHouse(Path sourceDir) {
        List<Print> printVo = new ArrayList<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDir)) {
            for (Path path : directoryStream) {
                FileChannel fileChannel = FileChannel.open(path);
                long fileChannelSize = fileChannel.size();
                String fileSize = FileUtil.getHumanReadableByteCount(fileChannelSize, true);
                String fileTime = FileUtil.getLastUpdated(path);
                Print vo = new Print(path.getFileName().toString(), fileSize, sourceDir.toString(), fileTime);
                printVo.add(vo);
                System.out.println("File added to Array: " + vo.toString());
            }
            return printVo;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public boolean writeFiles(Path sourceDir, String tempDir) {

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDir)) {
            String fileName = tempDir + "\\111.docx";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            for (Path path : directoryStream) {
                byte[] fileContent = Files.readAllBytes(path);
                outputStream.write(fileContent);
            }
            byte[] output = outputStream.toByteArray();

            Files.write(Paths.get(fileName), output);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }


    }
}
