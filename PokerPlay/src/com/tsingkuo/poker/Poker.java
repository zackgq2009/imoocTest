package com.tsingkuo.poker;

import java.util.Arrays;

/**
 * Created by johnnykuo on 2017/10/26.
 */
public class Poker implements Comparable<Poker> {
//    private String[] suits = {"黑桃","红桃","梅花","方片"};;
//    private String[] cards = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private String suit;
    private String card;

    public Poker() {
    }

    public Poker(String suit, String card) {
        this.suit = suit;
        this.card = card;
    }

    public String getSuit() {
        return suit;
    }

    public String getCard() {
        return card;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poker)) return false;

        Poker poker = (Poker) o;

        if (getSuit() != null ? !getSuit().equals(poker.getSuit()) : poker.getSuit() != null) return false;
        return getCard() != null ? getCard().equals(poker.getCard()) : poker.getCard() == null;
    }

    @Override
    public int hashCode() {
        int result = getSuit() != null ? getSuit().hashCode() : 0;
        result = 31 * result + (getCard() != null ? getCard().hashCode() : 0);
        return result;
    }

    /**
     * 重写关于中国扑克牌玩法的比较逻辑
     * @param o
     * @return
     */
    @Override
    public int compareTo(Poker o) {
//        System.out.println(this.getSuit().equals("黑桃"));
        if (this.getCard().equals(o.getCard())) {
            if (this.getSuit().equals("黑桃")) {
                if (o.getSuit().equals("黑桃")) {
                    System.out.println("抓老千");
                    return 1;
                } else {
                    return 1;
                }
            } else if (this.getSuit().equals("红桃")) {
                if (o.getSuit().equals("红桃")) {
                    System.out.println("抓老千");
                    return 1;
                } else if (o.getSuit().equals("黑桃")) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.getSuit().equals("梅花")) {
                if (o.getSuit().equals("梅花")) {
                    System.out.println("抓老千");
                    return 1;
                } else if (o.getSuit().equals("方片")) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.getSuit().equals("方片")) {
                if (o.getSuit().equals("方片")) {
                    System.out.println("抓老千");
                    return 1;
                } else {
                    return -1;
                }
            } else {
                System.out.println("给我发错牌了");
                return -1;
            }
        } else {
            if (this.getCard().equals("2")) {
                return 1;
            } else if (this.getCard().equals("A")) {
                if (o.getCard().equals("2")) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.getCard().equals("K")) {
                if (o.getCard().equals("2") || o.getCard().equals("A")) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.getCard().equals("Q")) {
                if (o.getCard().equals("2") || o.getCard().equals("A") || o.getCard().equals("K")) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.getCard().equals("J")) {
                if (o.getCard().equals("2") || o.getCard().equals("A") || o.getCard().equals("K") || o.getCard().equals("Q")) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                if (o.getCard().equals("2") || o.getCard().equals("A") || o.getCard().equals("K") || o.getCard().equals("Q") || o.getCard().equals("J")) {
                    return -1;
                } else {
                    return this.getCard().compareTo(o.getCard());
                }
            }
        }
    }
}
