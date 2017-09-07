package application.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCtrl {

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("it's ok!", HttpStatus.OK);
    }
}
