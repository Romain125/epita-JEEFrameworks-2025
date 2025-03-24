package org.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WrestleController {

    private int score = 0;

    @GetMapping(path="/wrestle")
    public int showScore(){
        return score;
    }

    @PutMapping(path="/wrestle")
    public void incrementScore(){
        score++;
    }

    @DeleteMapping(path="/wrestle")
    public void reset(){
        score=0;
    }


}
