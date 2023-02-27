package com.progmatic.springwebdemo.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path = "/mybook2")
public class FormData2 {

    private final static String PATH = "./covers/";

    List<Book2Show> books2 = new LinkedList<>();

    @GetMapping(path={"", "/"})
    public String getAllBooks(Model m) {
        m.addAttribute("books", books2);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBook(
            Model model,
            @PathVariable("id") String id
    ) {
        Book2Show b = null;
        for (var c: books2) {
            if (c.getIsbn().equalsIgnoreCase(id)) {
                b = c;
                break;
            }
        }
        System.out.println(b.getCoverPath());
        model.addAttribute("book", b);
        return "book-show2";
    }

    @GetMapping("/new")
    public String getBook(Model m) {
        m.addAttribute("book", new Book2());
        return "book-form-2";
    }

    @PostMapping
    public String setBook(
            @ModelAttribute("book")
            @Validated
            Book2 book,
            BindingResult formCheck
    ) throws IOException {
        if (formCheck.hasErrors()) {
            return "book-form-2";
        }

        Book2Show bs = new Book2Show();
        bs.setIsbn(book.getIsbn());
        bs.setTitle(book.getTitle());
        if (book.getCover() != null) {
            String path = FormData2.PATH + book.getCover().getOriginalFilename();
            bs.setCoverPath(book.getCover().getOriginalFilename());

            System.out.println(book.getCover().getOriginalFilename());
            Files.copy(
                    book.getCover().getInputStream(),
                    Paths.get(path),
                    StandardCopyOption.REPLACE_EXISTING
            );
        }
        books2.add(bs);

        return "redirect:/mybook2/" + book.getIsbn();
    }
}
