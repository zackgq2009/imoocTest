package com.tsingkuo.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnnykuo on 2017/10/26.
 */
public class Player {
    private String id;
    private String name;
    private List<Poker> pokerList = new ArrayList<>();

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Player() {
    }

    public String getName() {
        return name;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Poker> getPokerList() {
        return pokerList;
    }

    public void setPokerList(List<Poker> pokerList) {
        this.pokerList = pokerList;
    }
}
