package com.acolque.apitest.datasource;

import com.acolque.apitest.entities.Prices;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class CryptoPriceMongoDB implements CryptoPriceDataSource {

    @Override
    public List<Prices> getPrices() {
        String uri = String.format("mongodb+srv://root:%s@cluster0.joteu5w.mongodb.net/?retryWrites=true&w=majority", System.getenv("DB_PASS"));

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("crypto").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Prices> collection = database.getCollection("prices", Prices.class);
            return collection.find().into(new ArrayList<>());
        }
    }
}
