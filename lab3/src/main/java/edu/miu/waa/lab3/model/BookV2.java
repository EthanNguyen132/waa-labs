package edu.miu.waa.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookV2 {
    private int id;
    private String title;
    private String author;
}
