package mentoringquiz;

import java.util.HashMap;
import java.util.Map;

public class 빅테크랭킹리더보드 {

    static Tree tree = new Tree();
    static Map<String, Integer> userList = new HashMap<>();

    public static void main(String[] args) {
        빅테크랭킹리더보드 board = new 빅테크랭킹리더보드();
        String[] name = {"a", "b", "c", "d", "e", "f", "g", "h"};
        int[] score = {32, 33, 29, 35, 22, 24, 34, 30};
        for (int i = 0; i < name.length; i++) {
            userList.put(name[i], score[i]);
            board.putUser(name[i], score[i]);
        }
        for (String i : name) {
            System.out.println("board = " + board.getRank(i));
        }
    }


    public void putUser(String name, int score) {
        tree.add(new Node(score, 1, name));
    }

    public int getRank(String name) {
        Integer score = userList.get(name);
        return tree.scoreByRankings(score);
    }

   /* public String getName(int rank) {


    }*/


    static class Tree {
        Node root;

        Node nextNode;
        int treeLength;

        void add(Node node) {
            treeLength++;
            if (root == null) {
                root = node;
                return;
            }
            nextNode = root;
            while (true) {
                if (nextNode.score < node.score) {
                    if (nextNode.rightNode == null) {
                        nextNode.rightNode = node;
                        break;
                    } else {
                        nextNode = nextNode.rightNode;
                    }
                } else {
                    nextNode.leftNodeCount += 1;
                    if (nextNode.leftNode == null) {
                        nextNode.leftNode = node;
                        break;
                    } else {
                        nextNode = nextNode.leftNode;
                    }
                }
            }


        }

        //자신보다작은 값의 leftnode들을 전체 크기에서 빼주면됌
        int scoreByRankings(int score) {
            int rank = 0;
            nextNode = root;
            while (nextNode != null && nextNode.score != score) {
                if (nextNode.score < score) {
                    rank += nextNode.leftNodeCount;
                    nextNode = nextNode.rightNode;
                } else {
                    nextNode = nextNode.leftNode;
                }
            }
            return treeLength - (rank + nextNode.leftNodeCount) + 1;
        }


      /*  String rankingByName(int rank) {


        }*/

    }

    static class Node {

        int score;

        int leftNodeCount;
        String name;
        Node leftNode;
        Node rightNode;

        //  동기화방법 ?
        int rank;

        public Node(int score, int leftNodeCount, String name) {
            this.score = score;
            this.leftNodeCount = leftNodeCount;
            this.name = name;
        }


    }
}
