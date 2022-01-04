package com.example.keidapi.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CollectionRepository {

    private final ResourceLoader resourceLoader;



    private Map<Integer, TokenResponse> tokens;

    public CollectionRepository(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        tokens = new HashMap<>();
    }


    public TokenResponse getTokenMetadata(Integer tokenId){
        return tokens.getOrDefault(tokenId, null);
    }


    @PostConstruct
    public void fillMap() throws IOException {

        ObjectMapper om = new ObjectMapper();
        InputStream inputStream = resourceLoader.getResource("classpath:metadata.json").getInputStream();
        List<TokenResponse> tokenResponses = om.readValue(inputStream, om.getTypeFactory().constructCollectionType(List.class, TokenResponse.class));
        for (int i = 0; i < tokenResponses.size(); i++) {
            tokens.put(i, tokenResponses.get(i));
        }

        System.out.println("asd");
//        try {
//            ;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
