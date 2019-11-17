package au.net.jacksta.demo.controller;

import au.net.jacksta.demo.model.Print;
import au.net.jacksta.demo.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PrintController {
    @Value("${spring.application.name}")
    String appName;

    @Value("${jacksta.source.dir}")
    String sourceDirString;

    @Value("${jacksta.destination.dir}")
    String destinationDirString;

    @Value("${jacksta.temp.dir}")
    String tempDirString;


    @Autowired
    private PrintService jackstaPrintService;


    @GetMapping({"/", "/print", "/print.html"})
    public String homePage(Model model) {
        Path sourceDir = Paths.get(sourceDirString);
        Path destinationDir = Paths.get(destinationDirString);
        List<Print> printVo = jackstaPrintService.getAdvicesForPrintHouse(sourceDir);
        jackstaPrintService.writeFiles(sourceDir, tempDirString);

        model.addAttribute("directory", sourceDirString);
        model.addAttribute("appName", appName);
        model.addAttribute("print", printVo);


        return "print";
    }

    @PostMapping("/print")
    public String greetingSubmit(@ModelAttribute Print print) {
        System.out.println(print.toString());
        return "print";
    }

}
