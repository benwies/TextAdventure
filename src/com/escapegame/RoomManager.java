package com.escapegame;

public class RoomManager {
    private static final int NUM_ROOMS = 5;

    public static void displayRooms() {
        System.out.println("List of Rooms:");
        for (int i = 0; i < NUM_ROOMS; i++) {
            System.out.println("Room " + i);
        }
    }

    public static void enterRoom(int roomNumber) {
        System.out.println("Entering Room " + roomNumber);
    }

    public static int getNumRooms() {
        return NUM_ROOMS;
    }
}
