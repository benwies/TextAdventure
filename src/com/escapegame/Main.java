package com.escapegame;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        String playerName = Commands.loadPlayerName(); 

        if (playerName.isEmpty()) {
            System.out.println("Welcome new Player. Please enter your name to start the game:");
            playerName = scanner.nextLine();
            System.out.println("Your name is set to " + playerName + "! Press [ENTER] to continue");
            scanner.nextLine(); 
            System.out.println("You can list all commands with <!commands>. [ENTER]");
            scanner.nextLine();
            System.out.println("!IMPORTANT! Don't forget to save the progress with <!save>. [ENTER]");
            scanner.nextLine();
        } else {
            System.out.println("Do you want to load the saved game? New game will delete the old saves! (y/n)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("Loading saved game...");
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Welcome back, " + playerName + "! <!help> for help");
            } else if (input.equalsIgnoreCase("n")) {
                String filePath = "diary.txt"; 
                ClearFileContent.clearContent(filePath);
                System.out.println("Starting new game...");
                System.out.println("Please enter your name to start the game:");
                playerName = scanner.nextLine(); 
                System.out.println("Your name is set to " + playerName + "! Press [ENTER] to continue");
                scanner.nextLine();
                System.out.println("You can list all commands with <!commands>. [ENTER]");
                scanner.nextLine();
                System.out.println("IMPORTANT! Don't forget to save the progress with <!save>. [ENTER]");
                scanner.nextLine();
            }
        }

        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.startsWith("!commands")) {
                Commands.displayCommands();
            }
            if (input.startsWith("!name")) {
                Commands.displayPlayerName("Your name is " + playerName);
            }
            if (input.startsWith("!changename")) {
                playerName = Commands.updatePlayerName(scanner, playerName);
            }
            if (input.startsWith("!save")) {
                Commands.savePlayerName(playerName);
                System.out.println("Progress saved!");
            }
            if (input.startsWith("!help")) {
                System.out.println("Press <!commands> to get some help");
            }
            if (input.startsWith("!rooms")) {
                RoomManager.displayRooms();
            }
            if (input.startsWith("!clear")) {
            	Commands.clearConsole();
            }
            if (input.startsWith("!level")) {
                String[] tokens = input.split(" ");
                if (tokens.length == 2) {
                    try {
                        int levelNumber = Integer.parseInt(tokens[1]);
                        if (levelNumber == 0) {
                            System.out.println("Entering Level 0...");
                            isRunning = false;
                        } else {
                            System.out.println("Invalid level number!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid command format!");
                    }
                } else {
                    System.out.println("Invalid command format!");
                }
            }
            if (!isRunning) {
                Level0.setupLevelZero(scanner);
            }
		}
    }
}