package com.progmatic.springwebdemo.template;

import com.progmatic.springwebdemo.pathvariable.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path = "/mybook")
public class FormData {

    List<Book> books = new LinkedList<>();

    @GetMapping(path = {"", "/{id}"})
    public String getBook(
            Model model,
            @PathVariable(required = false, name = "id") String id
    ) {
        if ("321".equalsIgnoreCase(id)) {
            model.addAttribute(
                    "book",
                    new Book("Kázmér receptjei", id)
            );
        } else {
            model.addAttribute(
                    "book",
                    new Book("", "")
            );
        }
        return "book-form";
    }

    @PostMapping
    public String setBook(@ModelAttribute("book") Book book) {
        // create or modify book
        return "book-show";
    }
}
