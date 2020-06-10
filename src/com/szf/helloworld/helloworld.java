package com.szf.helloworld;
import java.awt.*;
import java.util.Scanner;
public class helloworld {
    static int[][] twodArr = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2}
    };

    public static void main(String[] args){
        while(true) {
            printTable();
            System.out.println("Spieler 1 ist am Zug");
            setMove1(getCoords());
            if(winCondition(twodArr, 1, 2) != true){
                System.out.println("Spieler 1 hat gewonnen");
                break;
            }
            printTable();
            System.out.println("Spieler 2 ist am Zug");
            setMove2(getCoords());
            if(winCondition(twodArr, 1, 2) != true){
                System.out.println("Spieler 2 hat gewonnen");
                break;
            }
        }
    }

    public static void printTable(){
        for(int i = 0; i < twodArr.length; i++){
            for(int j = 0;j < twodArr[i].length; j++){
                System.out.print(twodArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] getCoords(){
        String input1 = new String();
        String input2 = new String();
        Scanner reader = new Scanner(System.in);
        do {
            System.out.println("X Achse: ");
            input1 = reader.nextLine();
        }while(!(Integer.parseInt(input1)>=0 && Integer.parseInt(input1)<=7));
        do {
            System.out.println("Y Achse: ");
            input2 = reader.nextLine();
        }while(!(Integer.parseInt(input2)>=0 && Integer.parseInt(input2)<=7));
        int[] arr = {Integer.parseInt(input1),Integer.parseInt(input2)};
        return arr;
    }

    public static void setMove2(int[] arr) {
        if (twodArr[arr[0]][arr[1]] != 2) {
            System.out.println("Auf dieser Position hast du keine Figur");
        } else {
            twodArr[arr[0]][arr[1]] = 0;
            System.out.println("Wohin möchtest du ziehen?");
            int[] newpos = getCoords();
            if (twodArr[newpos[0]][newpos[1]] == 2) {
                System.out.println("Du steht bereits auf dieser Position");
            } else {
                twodArr[newpos[0]][newpos[1]] = 2;
            }
        }
    }

    public static void setMove1(int[] arr) {
        if(twodArr[arr[0]][arr[1]] != 1){
            System.out.println("Auf dieser Position hast du keine Figur");
        }else{
            twodArr[arr[0]][arr[1]] = 0;
            System.out.println("Wohin möchtest du ziehen?");
            int[] newpos =  getCoords();
            if(twodArr[newpos[0]][newpos[1]] == 1){
                System.out.println("Du steht bereits auf dieser Position");
            }else{
                twodArr[newpos[0]][newpos[1]] = 1;
            }
        }
    }

    public static boolean winCondition(final int[][] arr, final int x, final int y){
        boolean result = false;
        boolean foundX = false;
        boolean foundY = false;

        for(int i = 0; i< arr.length;i++){
            for(int j = 0;j<arr[i].length;j++)
                if(arr[i][j] == x){
                    foundX = true;
                }
                else if(arr[i][j] == x){
                    foundY = true;
                }
        }
        if((foundY == true && foundX == false) || (foundX == true && foundY == false)){
            result = true;
        }
        return result;
    }
}