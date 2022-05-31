package Problems.String;

import Common.Problem;
import Utils.StringUtils;

import java.util.Arrays;
import java.util.HashSet;

public class Boggle extends Problem {
    @Override
    public void run() {
        System.out.println("Running Boggle");
        char[][][] grids = {{{'c', 'a', 't'}, {'r', 'r', 'e'}, {'t', 'o', 'n'}},
                {{'o', 'a', 'a'}, {'e', 't', 'a'}, {'i', 'h', 'k'}},
                {{'a', 'b', 'i'}, {'e', 'g', 'a'}, {'r', 'r', 'o'}},
                {{'m', 'o', 'q'}, {'e', 'l', 'z'}, {'z', 'r', 'o'}}};

        String[][] dictionaries =
                        {{"cat", "cater", "cartoon", "toon", "moon", "not", "tone", "apple", "ton", "art"},
                         {"oath", "pea", "ate", "the", "iot"},
                         {"ago", "ego", "bear", "gear", "rear", "big", "roar", "rig", "bar"},
                         {"zoo", "zoom", "zoz"}};
        this.execute(grids, dictionaries);
    }

    private void execute(char[][][] grids, String[][] dictionaries) {
        for (int i = 0; i < grids.length; i++) {
            char[][] grid = grids[i];
            HashSet<String> dictionary = new HashSet<String>(Arrays.asList(dictionaries[i]));
            System.out.print("Grid of characters: ");
            StringUtils.gridPrint(grid);
            System.out.println("Dictionary: ");
            StringUtils.arrPrint(dictionary);
            System.out.println("Words: ");
            StringUtils.arrPrint(this.findWords(grid, dictionary));
        }
    }

    private HashSet<String> findWords(char[][] grid, HashSet<String> dictionary) {
        BoggleData boggleData = new BoggleData(grid, dictionary);
        HashSet<String> words = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boggleData.findWords(i, j, new StringBuilder(), words);
            }
        }
        return words;
    }

    class BoggleData {
        char[][] grid;
        HashSet<String> dictionary;
        boolean[][] state;

        public BoggleData(char[][] grid, HashSet<String> dictionary) {
            this.grid = grid;
            this.dictionary = dictionary;
            this.state = new boolean[grid.length][grid.length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    this.state[i][j] = false;
                }
            }
        }

        public void findWords (int x, int y, StringBuilder current, HashSet<String> words) {

        }

    }
}
