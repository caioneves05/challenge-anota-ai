package com.caioneves.challenge_anota_ai.domain.category;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collation = "categories")
public class Category {
    @Id
    private String id;

    private String title;

    private String description;

    private String ownerId;

    public Category(CategoryDTO category) {
        this.title = category.title();
        this.description = category.description();
        this.ownerId = category.ownerId();
    }
}
