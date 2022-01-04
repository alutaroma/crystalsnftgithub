package com.example.keidapi.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/metadata")
public class CollectionController {


    private final CollectionRepository collectionRepository;

    public CollectionController(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;

    }


    @GetMapping(path = "/{tokenId}")
    public TokenResponse getTokenMetadata(@PathVariable(name = "tokenId") Integer tokenId) {
        return collectionRepository.getTokenMetadata(tokenId);
    }

}
