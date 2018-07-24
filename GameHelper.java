/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinkadotcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author ander
 */
class GameHelper {

    private static final String alphabet = "abcdefg";
    private final int gridLenght = 7;
    private final int gridSize = 49;
    private final int[] grid = new int[gridSize];
    private int comCount = 0;

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCell = new ArrayList<>();
        String temp = null;
        int coords[] = new int[comSize];
        int attemps = 0;
        boolean sucess = false;
        int location = 0;
        comCount++;
        int incr = 1;

        if ((comCount % 2) == 1) {
            incr = gridLenght;
        }
        while (!sucess && attemps++ < 200) {
            location = (int) (Math.random() * gridSize);
            //System.out.println("Try: " + location);
            int x = 0;
            sucess = true;
            while (sucess && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;

                    if (location >= gridSize) {
                        sucess = false;
                    }
                    if (x > 0 && (location % gridLenght == 0)) {
                        sucess = false;
                    }
                } else {
                    //System.out.println("used" + location);
                    sucess = false;
                }
            }

        }
        int x = 0;
        int ronw = 0;
        int column = 0;
        System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1;
            ronw = (int) (coords[x] / gridLenght);
            column = coords[x] % gridLenght;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCell.add(temp.concat(Integer.toString(ronw)));
            x++;
            
        }
        //System.out.println("\n");
        return alphaCell;
    }

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();

            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
        return inputLine.toLowerCase();
    }

}
