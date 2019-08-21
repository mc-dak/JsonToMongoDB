package com.dak.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.dak.model.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class MongoService {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${spring.data.mongodb.collection}")
    private String collection;

    void sendToMongo(String path) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String fullDoc = bufferedReader.lines().collect(Collectors.joining());
            ObjectMapper objectMapper = new ObjectMapper();
            Root root = objectMapper.readValue(fullDoc, Root.class);
            MongoClient mongo = new MongoClient(new ServerAddress(host, Integer.parseInt(port)));
            DB db = mongo.getDB(dbName);
            DBCollection dbCollection = db.getCollection(collection);
            dbCollection.insert(root);

            DBCursor cur = dbCollection.find();
            while(cur.hasNext()) {
                System.out.println(cur.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
