package json.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


//@Component
@ComponentScan
@RefreshScope
@RestController
@RequestMapping("api/file")
public class FileService {
    //    private static String UPLOAD_DIR = "uploads";
    @Value("${upload.dir}")
    private String upload_dir;

    @Autowired
    MongoService mongoService;

    //    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @PostMapping(value = "upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            String path = request.getServletContext().getRealPath("") + upload_dir + File.separator + fileName;
            System.out.println(request.getServletContext().getRealPath(""));
            System.out.println(path);
            saveFile(file.getInputStream(), path);

            //            sendToMongo(path);

            mongoService.sendToMongo(path);
        } catch (Exception e) {
            return e.getMessage();
            //            return ResponseEntity.notFound().build();
//            return new ResponseEntity<String>("error", HttpStatus.NOT_FOUND);
        }
        return "uploaded";
//        return ResponseEntity.ok("uploaded");
    }

    private void saveFile(InputStream inputStream, String path) {
        try{
            OutputStream outputStream = new FileOutputStream(new File(path));
            int read = 0;
            byte[]bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,read);
            }
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
