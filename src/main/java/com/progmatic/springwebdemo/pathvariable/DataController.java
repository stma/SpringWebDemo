package com.progmatic.springwebdemo.pathvariable;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataController {

    @GetMapping("/greeting/{name}")
    @ResponseBody
    public String greeting(@PathVariable("name") String visitor) {
        return String.format("Hello %s, long time no see!", visitor);
    }

    @RequestMapping(path = "/book/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public String getBook(@PathVariable("isbn") String visitor) {
        return String.format("Book %s, is not available!", visitor);
    }

    @RequestMapping(path = "/json/book/{isbn}", method = RequestMethod.GET)
    @ResponseBody   // alapertelmezetten JSON object a visszateresi ertek
    public Book getJsonBook(@PathVariable("isbn") String isbn) {
        return new Book("Kázmér receptjei", isbn);
    }

//    @RequestMapping(
//            path = "/xml/book/{isbn}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_XML_VALUE
//    )
//    @ResponseBody
//    public String getXmlBook(@PathVariable("isbn") String isbn) {
//        return String.format("""
//<book><title>Kázmér receptjei</title><isbn>%s</isbn></book>
//""",
//                isbn
//        );
//    }

    @GetMapping(
            path = "/xml/book/{isbn}",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    @ResponseBody
    public ResponseEntity<String> getXmlBook(@PathVariable("isbn") String isbn) {
//        return ResponseEntity.ok(
//            String.format("""
//<book><title>Kázmér receptjei</title><isbn>%s</isbn></book>
//""",
//                isbn
//            )
//        );
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(path = "/bookByParam", method = RequestMethod.GET)
    @ResponseBody
    public String getBookByParam(@RequestParam("isbn") String visitor) {
        return String.format("""
<html>
<head>
<title>Book %s</title>
</head>
<body>
<h1>
Book %s, is not available!
</h1>
</body>
</html>
""", visitor, visitor);
    }
}
