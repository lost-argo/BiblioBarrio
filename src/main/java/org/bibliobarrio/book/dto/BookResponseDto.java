package org.bibliobarrio.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private Integer totalCopies;
    private Integer availableCopies;

    public BookResponseDto(){}

    public BookResponseDto(Long id, String title, String author, Integer totalCopies, Integer availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }
}