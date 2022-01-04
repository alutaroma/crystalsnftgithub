package com.example.keidapi.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/metadata")
public class KaszojadyController {


    private final KeidRepository keidRepository;

    public KaszojadyController(KeidRepository keidRepository) {
        this.keidRepository = keidRepository;

    }


    @GetMapping(path = "/{tokenId}")
    public TokenResponse getTokenMetadata(@PathVariable(name = "tokenId") Integer tokenId) {
        return keidRepository.getTokenMetadata(tokenId);
    }

}
