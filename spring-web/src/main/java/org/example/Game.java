package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonRootName("root")
public class Game{
    private int score1 = 0;
    private int score2 = 0;
    private String id = "";
    @JsonIgnore
    private Map<String, Integer> stats;

    public Game(int score1, int score2, String id) {
        stats = new HashMap<>();
        this.score1 = score1;
        this.score2 = score2;
        this.id = id;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public String getId() {
        return id;
    }

    public void incrementScore1(){
        score1++;
    }
    public void incrementScore2(){
        score2++;
    }

    public void reset(){
        score1 = 0;
        score2 = 0;
    }

    public void addToStats(String userAgent){
        stats.merge(userAgent, 1, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return score1 == game.score1 && score2 == game.score2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score1, score2);
    }
}
