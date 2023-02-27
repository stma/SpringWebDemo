package com.progmatic.springwebdemo.template;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class Book2 {

    @NotBlank
    @Size(max = 45)
    private String title;
    @NotBlank
    @Pattern(regexp = "\\w{12}", message = "ISBN 12 karakter hosszu")
    private String isbn;

//    @Future
//    @DateTimeFormat(pattern = "yyyy/MM/dd")
//    private LocalDate start;

    private MultipartFile cover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }
}
