package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.stream.Collectors;

import com.mongodb.*;

@RefreshScope
@RestController
@RequestMapping("api/file")
public class FileRestController {

//    private static String UPLOAD_DIR = "uploads";
    @Value("${upload.dir}")
    private String upload_dir;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${spring.data.mongodb.collection}")
    private String collection;

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
            sendToMongo(path);
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

    private void sendToMongo(String path) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String fullDoc = bufferedReader.lines().collect(Collectors.joining());
            ObjectMapper objectMapper = new ObjectMapper();
            Root root = objectMapper.readValue(fullDoc, Root.class);

            MongoClient mongo = new MongoClient(new ServerAddress(host, Integer.parseInt(port)));
            DB db = mongo.getDB(dbName);
            DBCollection dbCollection = db.getCollection(collection);
            dbCollection.insert(root);

//            DBCursor cur = dbCollection.find();
//            while(cur.hasNext()) {
//                System.out.println(cur.next());
//            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
