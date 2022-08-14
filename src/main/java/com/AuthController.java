package com;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.spring.MongoDbConfig;
import lombok.extern.log4j.Log4j2;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;


@RestController
@Log4j2
//@RequestMapping("v1")
public class AuthController {

    @Autowired
    private MongoDbConfig dbConfig;

    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;
    private String COLLECTION_NAME = "TEST_COLLECTION";
    private MongoClient mc;

    @PostConstruct
    public void init() {
        log.info("Mongo config initialise client with properties=" + dbConfig);
        try {
            var mc = new MongoClient(new MongoClientURI("mongodb://" + dbConfig.getUsername() + ":"
                    + dbConfig.getSecret() + "@" + dbConfig.getUrl()));
            this.mc = mc;
        } catch (Exception e) {
            log.error("Failed to connect to Mongo database={}", dbConfig.getDatabase(), e);
        }
        this.mongoDatabase = mc.getDatabase(dbConfig.getDatabase());
        this.collection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    @PostMapping(path = "post")
    public ResponseEntity<Object> auth(@RequestBody Map<String, Object> body) {
        log.info("Received '/post' request body=" + body);
        var document = new Document(body);
        collection.insertOne(document);
        log.info("Returning OK '/post' request body");
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "health")
    public ResponseEntity<Object> healthCheck() {
        final var prefix = "Received '/health' request";
        log.info(prefix);
        return ResponseEntity.ok().build();
    }

}