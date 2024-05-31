package com.caioneves.challenge_anota_ai.domain.product;


import com.caioneves.challenge_anota_ai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collation = "products")
public class Product {
    @Id
    private String id;

    private String title;

    private String description;

    private String ownerId;

    private Integer price;

    private Category category;
}
