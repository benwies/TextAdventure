package com.escapegame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Commands {

    public static String updatePlayerName(Scanner scanner, String playerName) {
        String newName = changeName(scanner); 
        if (newName != null) {
            playerName = newName; 
            System.out.println("Name set to " + newName);
        }
        return playerName; 
    }

    public static String changeName(Scanner scanner) {
        String input;
        do {
            System.out.println("Do you want to change the name? (y/n)");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("Enter new name:");
                return scanner.nextLine();
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("No changes were made");
                return null; 

                }else {
                System.out.println("Invalid input!");
            }
        } while (true); 
    }

    public static void savePlayerName(String playerName) {
        try (FileWriter fileWriter = new FileWriter("saves.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(playerName); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadPlayerName() {
        String playerName = "";
        try (FileReader fileReader = new FileReader("saves.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            playerName = bufferedReader.readLine();
            if (playerName == null) {
                playerName = "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playerName;
    }

    public static void displayCommands() {
        System.out.println("___________________CommandList_____________________");
        System.out.println("!help = help");
        System.out.println("!save = save the progress");
        System.out.println("!commands = opens this");
        System.out.println("!exit = leave the game");
        System.out.println("!clear = clear the command lines");
        System.out.println("!name = display character name");
        System.out.println("!changename = change character name");
        System.out.println("!rooms = displays the levels");
        System.out.println("!level <number> = change character name");
        System.out.println("___________________________________________________");
	}

	public static void displayPlayerName(String playerName) {
        System.out.println(playerName);
		
	}
	
	public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println(); 
        }
	}   
}





