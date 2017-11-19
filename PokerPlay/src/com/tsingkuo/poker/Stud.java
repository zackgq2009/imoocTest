package com.tsingkuo.poker;

import java.util.*;

//import static java.lang.Integer.valueOf;

public class Stud {
    public String[] suits = {"黑桃","红桃","梅花","方片"};
    public String[] cards = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    public List<Poker> newPokers;
    public List<Poker> shuffledPokers;
//    public List<Poker> dealedPokers;
    public Player player;

    public Stud() {
        this.newPokers = new ArrayList<>();
        this.shuffledPokers = new ArrayList<>();
    }

    public List<Poker> pokers() {
        Poker poker;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                poker = new Poker();
                poker.setSuit(suits[i]);
                poker.setCard(cards[j]);
                newPokers.add(poker);
            }
        }
        return newPokers;
    }

    public void showPokers(List<Poker> pokers) {
        for (Poker poker : pokers
                ) {
            System.out.print(poker.getSuit() + poker.getCard() + "  ");
        }
    }

    public List<Poker> shuffledPokers(List<Poker> pokers) {
        Poker poker, newPoker;
        int pokersLang = pokers.size();
        Random random = new Random();
        for (int i = 0; i< pokersLang; i ++) {
            poker = pokers.get(random.nextInt(pokers.size()));
            newPoker = new Poker(poker.getSuit(), poker.getCard());
//            newPoker.setCard(poker.getCard());
//            newPoker.setSuit(poker.getSuit());
            shuffledPokers.add(newPoker);
            newPokers.remove(poker);
        }
        return shuffledPokers;
    }

    public void dealPokers(Player player) {
//        dealedPokers = new ArrayList<>();
        List<Poker> dealedPokers = player.getPokerList();
        Poker poker = new Poker(shuffledPokers.get(0).getSuit(), shuffledPokers.get(0).getCard());
        shuffledPokers.remove(0);
        dealedPokers.add(poker);
        player.setPokerList(dealedPokers);
    }

    public Player appearPlayer() {
        player = new Player();
        String playerId, playerName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入这位牌友的ID：");
        playerId = scanner.next();
        if (!(Integer.valueOf(playerId) instanceof Integer)) {
            System.out.println("请再次输入这位牌友的ID：");
            playerId = scanner.next();
        }
        player.setId(playerId);
        System.out.println("请输入这位牌友的名字：");
        playerName = scanner.next();
        player.setName(playerName);
        return player;
    }

    public static void main(String[] args) {
	// write your code here
//        List<Poker> newPokers;
//        List<Poker> shuffledPokers;
//        Stud stud = new Stud();
//        newPokers = stud.pokers();
//        shuffledPokers = stud.shuffledPokers(newPokers);
//        stud.showPokers(shuffledPokers);
        Stud stud = new Stud(); //一个赌场
        Player playerA = stud.appearPlayer(); //一个牌友出现
        Player playerB = stud.appearPlayer(); //第二个牌友出现
        List<Poker> newPokers = stud.pokers(); //拿出来一副新牌
        System.out.println("-------------------------------------------------------------展示一下新牌---------------------------------------------------------");
        stud.showPokers(newPokers); //展示一个这幅新牌是否正常
        System.out.println("");
        List<Poker> shuffledPokers = stud.shuffledPokers(newPokers);   //洗一下这副牌
        System.out.println("-------------------------------------------------------------展示一下洗好的牌---------------------------------------------------------");
        stud.showPokers(shuffledPokers); //偷摸看一下洗好的牌
        System.out.println("");
        for (int i=0; i<10; i++) {
            stud.dealPokers(playerA); //A抓牌
            stud.dealPokers(playerB); //B抓牌
        }
        System.out.println("-------------------------------------------------------------展示一下各自的牌---------------------------------------------------------");
        stud.showPokers(playerA.getPokerList()); //展示A手里有什么牌
        System.out.println("");
        stud.showPokers(playerB.getPokerList()); //展示B手里有什么牌
        System.out.println("");
        Collections.sort(playerA.getPokerList());  //A手里的牌整理一下
        Collections.sort(playerB.getPokerList());  //B手里的牌整理一下
        System.out.println("--------------------------------------------------整理下牌————————————————————————————————————————————————————————————");
        stud.showPokers(playerA.getPokerList());
        System.out.println("");
        stud.showPokers(playerB.getPokerList());
        System.out.println("");
        List<Poker> pokerList = new ArrayList<>();
        int playerAPokerLength = playerA.getPokerList().size();
        int playerBPokerLength = playerB.getPokerList().size();
        pokerList.add(new Poker(playerA.getPokerList().get(playerAPokerLength - 1).getSuit(), playerA.getPokerList().get(playerAPokerLength - 1).getCard()));
        pokerList.add(new Poker(playerB.getPokerList().get(playerBPokerLength - 1).getSuit(), playerB.getPokerList().get(playerBPokerLength - 1).getCard()));
        Collections.sort(pokerList);
        if (playerA.getPokerList().contains(pokerList.get(1))) {
            System.out.println(playerA.getName() + "是赢家");
        } else {
            System.out.println(playerB.getName() + "是赢家");
        }
    }
}
