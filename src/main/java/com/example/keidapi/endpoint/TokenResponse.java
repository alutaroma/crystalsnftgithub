package com.example.keidapi.endpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {

    private String name;
    private String description;
    private String image;
    private String external_url;
    private List<Attribute> attributes;

}
