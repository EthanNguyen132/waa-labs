package edu.miu.waa.lab1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private int id;
    private String isbn;
    public String title;
}
