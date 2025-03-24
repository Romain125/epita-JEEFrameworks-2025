package org.example;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class WrestleController {

    Map<String, Game> games = new HashMap<>();

    public WrestleController() {
        Game defaultGame = new Game(0,0, "0");
        games.put("0", defaultGame);
    }

    @GetMapping(path="/simple", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Game> showScore(){
        Game game = games.get("0");
        if(game == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(game);
    }

    @GetMapping(path="/wrestle/{gameId}")
    public Game showScore(@PathVariable String gameId){
        return games.get(gameId);
    }

    @PostMapping(path="/wrestle")
    public void createGame(@RequestBody Game game){
         games.put(game.getId(), game);
    }

    @PutMapping(path="/wrestle/{gameId}")// /wrestle?player=player1
    public void incrementScore(@RequestParam String player, @PathVariable String gameId, HttpServletRequest request){
        switch (player){
            case "player1" : games.get(gameId).incrementScore1();break;
            case "player2" : games.get(gameId).incrementScore2();
        }
        String header = request.getHeader("user-agent");
        games.get(gameId).addToStats(header);
    }

    @DeleteMapping(path="/wrestle/{gameId}")
    public void reset(@PathVariable String gameId){
        games.get(gameId).reset();
    }



}
