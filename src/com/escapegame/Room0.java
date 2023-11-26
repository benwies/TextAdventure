package com.escapegame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Room0 {
    public static boolean isEntryExists(String picture) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("diary.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(picture)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
        
    public static void saveToDiary(String picture, String number) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("diary.txt", true));
            if (!isEntryExists(picture)) {
                writer.write(picture + ": " + number + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayDiaryContents() {
        System.out.println("_________________Diary_________________");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("diary.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("_______________________________________");
    }
    
    public static boolean lock(Scanner scanner) {
        int maxTries = 3;
        int attempts = 0;

        while (attempts < maxTries) {
            System.out.println(TextChange.ANSI_BOLD + "Enter a 3-digit code: " + TextChange.ANSI_RESET);

            int enteredCode = scanner.nextInt();
            scanner.nextLine();

            if (enteredCode == 497) {
                System.out.println(TextChange.ANSI_BOLD + "Congrats! Unlocked the door." + TextChange.ANSI_RESET);
                return true;
            } else {
                attempts++;
                int remainingTries = maxTries - attempts;
                if (remainingTries > 0) {
                    System.out.println(
                            TextChange.ANSI_BOLD + "Wrong code. " + remainingTries + " tries remaining. Try a new combination!" + TextChange.ANSI_RESET);
                } else {
                    System.out.println(
                            TextChange.ANSI_BOLD + "Out of tries. Exiting..." + TextChange.ANSI_RESET
                    );
                    return false;
                }
            }
        }
        return false;
    }

    public static void room1(Scanner scanner) {
    	boolean isLocked = true;
        try (Scanner scanner1 = new Scanner(System.in)) {
        	Commands.clearConsole();
			System.out.println(TextChange.ANSI_BOLD +"You wake up in a room"+ TextChange.ANSI_RESET);  
			try {
			    Thread.sleep(2000); 
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			System.out.println( TextChange.ANSI_ITALIC + "All the player commands start wirth </>.  [ENTER]"+ TextChange.ANSI_RESET);
			scanner1.nextLine();
			System.out.println( TextChange.ANSI_ITALIC + "Try </look> to look around in this room. Try it!   [ENTER]"+ TextChange.ANSI_RESET);
			scanner1.nextLine();
			Commands.clearConsole();
			boolean isRunning = true;
			while (isRunning) {
			    System.out.print("> ");
			    String input = scanner1.nextLine();

			    if (input.startsWith("/look")) {
			    	System.out.println(TextChange.ANSI_BOLD +"You look around and the Room. You see 3 " + TextChange.ANSI_RED + "pictures" + TextChange.ANSI_RESET + TextChange.ANSI_BOLD + " hanging on a wall. In front of you is a " + TextChange.ANSI_RESET+ TextChange.ANSI_RED + "table" + TextChange.ANSI_RESET + ".");
			    	System.out.println(TextChange.ANSI_BOLD +"The door to the next room is closed with a digital " + TextChange.ANSI_RED + "lock" + TextChange.ANSI_RESET + ".");
			        isRunning = false;
			    }
			    try {
			        Thread.sleep(3000); 
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }    
			System.out.println( TextChange.ANSI_ITALIC + "The red text are objects you can interact with."+ TextChange.ANSI_RESET);
			try {
			    Thread.sleep(3000); 
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}  
			System.out.println( TextChange.ANSI_ITALIC + "In the future, the clues will not be marked so pay attention the the text!"+ TextChange.ANSI_RESET);
			try {
			    Thread.sleep(3000); 
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}  
			System.out.println(  TextChange.ANSI_ITALIC + "Do </inspect <object>> to get a closer look at something"+ TextChange.ANSI_RESET);
			try {
			    Thread.sleep(1000); 
			} catch (InterruptedException e) {
			    e.printStackTrace();
			} 
			System.out.println(  TextChange.ANSI_ITALIC +  "(If there a multiple objects with the same name they are named with numbers like book1, book2 and book3.)"+ TextChange.ANSI_RESET);
			isRunning = true;
			try {
			    Thread.sleep(3000); 
			} catch (InterruptedException e) {
			    e.printStackTrace();
			} 
			while (isRunning) {
			    System.out.print("> ");
			    String coms = scanner1.nextLine();
			    if (coms.startsWith("/look")) {
			        System.out.println(TextChange.ANSI_BOLD +"You look around the room. You see 3 pictures hanging on a wall. In front of you is a table."+ TextChange.ANSI_RESET);
			        System.out.println(TextChange.ANSI_BOLD +"The door to the next room is closed with a digital lock."+ TextChange.ANSI_RESET);
			    } else if (coms.startsWith("/inspect picture1")) {
			        saveToDiary("picture1", "7");
			        System.out.println(TextChange.ANSI_BOLD +"You inspect picture 1 and find a hidden number. It was saved to your diary!"+ TextChange.ANSI_RESET);
			    } else if (coms.startsWith("/inspect picture2")) {
			        saveToDiary("picture2", "4");
			        System.out.println(TextChange.ANSI_BOLD +"You inspect picture 2 and find a hidden number. It was saved to your diary!"+ TextChange.ANSI_RESET);
			    } else if (coms.startsWith("/inspect picture3")) {
			        saveToDiary("picture3", "9");
			        System.out.println(TextChange.ANSI_BOLD +"You inspect picture 3 and find a hidden number. It was saved to your diary!"+ TextChange.ANSI_RESET);
			    } else if (coms.startsWith("/inspect table")) {
			        System.out.println(TextChange.ANSI_BOLD +"You inspect the table and find a diary." + TextChange.ANSI_ITALIC + "Do </diary> to open it!"+ TextChange.ANSI_RESET);
			    
			    }if (coms.startsWith("/inspect lock") && isLocked) {
			            boolean isLockOpened = lock(scanner1);
			            if (isLockOpened) {
			                isLocked = false; 
			                System.out.println(TextChange.ANSI_ITALIC +  "You enter the next room"+ TextChange.ANSI_RESET);

			                isRunning = false;
			                break; 
			            }
			        }
				else if (coms.startsWith("/diary")) {
			        displayDiaryContents();
			    } else if (coms.startsWith("/exit")) {
			        isRunning = false;
			    } else if (coms.startsWith("!clear")) {
			        Commands.clearConsole();
			    		}
			    	}		
				}		
				
			}
        }		
    

    public static void setupLevelZero(Scanner scanner) {
    	room1(scanner);
    	
    	

        }		
    }


