package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.stream.Collectors;

import com.mongodb.*;

@RestController
@RequestMapping("api/file")
public class FileRestController {

    private static String UPLOAD_DIR = "uploads";

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = file.getOriginalFilename();
            String path = request.getServletContext().getRealPath("") + UPLOAD_DIR + File.separator + fileName;
            saveFile(file.getInputStream(), path);
            sendToMongo(path);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "uploaded";
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

    private void sendToMongo(String path) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String string = bufferedReader.lines().collect(Collectors.joining());
            ObjectMapper objectMapper = new ObjectMapper();
            Root root = objectMapper.readValue(string, Root.class);

            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("db");
            DBCollection dbCollection = db.getCollection("collection");
            dbCollection.insert(root);
        }
        catch (IOException e) {e.printStackTrace();}

    }
    }




