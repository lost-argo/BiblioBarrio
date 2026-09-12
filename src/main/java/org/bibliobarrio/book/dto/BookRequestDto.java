package org.bibliobarrio.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {
    private String title;
    private String author;
    private Integer totalCopies;
    private Integer availableCopies;

    public BookRequestDto(){}

    public BookRequestDto(String title, String author, Integer totalCopies, Integer availableCopies) {
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }
}
