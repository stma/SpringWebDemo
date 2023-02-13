package com.progmatic.springwebdemo.template;

import com.progmatic.springwebdemo.pathvariable.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/mybook2")
public class FormData2 {

    @GetMapping("/{id}")
    public String getBook(
            Model model,
            @PathVariable("id") String id
    ) {
        if ("321".equalsIgnoreCase(id)) {
            model.addAttribute(
                    "book",
                    new Book("Kázmér receptjei", id)
            );
        }
        return "book-show";
    }

    @GetMapping("/new")
    public String getBook(@ModelAttribute Book book) {
        return "book-form-2";
    }

    @PostMapping
    public String setBook(@ModelAttribute Book book) {
        // create or modify book
        return "redirect:/mybook2/" + book.isbn();
    }
}
