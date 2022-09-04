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
        tree.add(new Tree.Node(score, name));
    }

    public int getRank(String name) {
        Integer score = userList.get(name);
        return tree.scoreByRankings(score);
    }

   /* public String getName(int rank) {


    }*/


    static class Tree {
        Node root;

        int treeLength;

        void add(Node node) {
            treeLength++;
            if (root == null) {
                root = node;
                return;
            }
            Node nextNode;
            nextNode = root;
            while (true) {
                if (nextNode.score < node.score) {
                    if (nextNode.rightNode == null) {
                        nextNode.increaseCount();
                        nextNode.rightNode = node;
                        break;
                    } else {
                        nextNode.increaseCount();
                        nextNode = nextNode.rightNode;
                    }
                } else {
                    if (nextNode.leftNode == null) {
                        nextNode.increaseCount();
                        nextNode.leftNode = node;
                        break;
                    } else {
                        nextNode.increaseCount();
                        nextNode = nextNode.leftNode;
                    }
                }
            }


        }
        //자신보다작은 값의 leftnode들을 전체 크기에서 빼주면됌

        int scoreByRankings(int score) {
            int rank = 0;
            Node nextNode;
            nextNode = root;
            while (nextNode != null && nextNode.score != score) {
                if (nextNode.score < score) {
                    nextNode = nextNode.rightNode;
                } else {
                    nextNode = nextNode.leftNode;
                }
            }
            return 1;


        }

        static class Node {

            int score;

            String name;
            Node leftNode;
            Node rightNode;
            int count;

            //  동기화방법 ?
            int rank;

            public Node(int score, String name) {
                this.score = score;
                count = 1;
                this.name = name;
            }

            public void increaseCount() {
                this.count++;
            }

        }
    }
}
