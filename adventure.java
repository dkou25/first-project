import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        // Arguments
        String location = "north";
        Boolean hasKey = false;
        Boolean hasHammer = false;
        Boolean isWindowBroken = false;
        Boolean lampOn = false;
        Boolean safeOpen = false;
        Scanner console = new Scanner(System.in);
        String command;
        String lightColor;

        double r = Math.random() * 3;
        if (r < 1) {
            lightColor = "green";
        } else if (r < 2) {
            lightColor = "blue";
        } else {
            lightColor = "yellow";
        }

        // Main game loop
        System.out.println("You are in a locked room!");
        do {
            switch (location) {
                case "north":
                    System.out.println("You are facing the north wall.");
                    System.out.println("There is a door in front of you.");
                    System.out.println("What would you like to do?");
                    System.out.println("Options: open, west, east, south");
                    command = console.nextLine().toLowerCase().trim();

                    if (command.equals("open")) {
                        if (hasKey) {
                            location = "escaped!";
                        } else {
                            System.out.println("The door is locked!");
                        }
                    } else if (command.equals("west")) {
                        location = "west";
                    } else if (command.equals("east")) {
                        location = "east";
                    } else if (command.equals("south")) {
                        location = "south";
                    } else {
                        System.out.println("That is not an option!!!!!!!");
                    }
                    break;
                case "west":
                    System.out.println("You are in the west wing.");
                    System.out.println("There is a boarded up window.");
                    System.out.println("There is a dresser");
                    System.out.println("What would you like to do?");
                    System.out.print("Options: smash, open, north, east, south");
                    command = console.nextLine().toLowerCase().trim();

                    if (command.equals("smash")) {
                        if (isWindowBroken) {
                            System.out.println("You see three billboards.");
                            System.out.println("What does each say?");
                            System.out.println("The green billboard says HULK.");
                            System.out.println("The blue billboard says CAPT.");
                            System.out.println("The yellow billboard says THOR.");
                        } else {
                            if (hasHammer) {
                                System.out.println("You smash the window with your nifty hammer.");
                                System.out.println("Oh no! You are on the 20th floor. You can't escape from here but see three billboards in the distance.");
                                System.out.println("The green billboard says HULK.");
                                System.out.println("The blue billboard says CAPT.");
                                System.out.println("The yellow billboard says THOR.");
                            } else {
                                System.out.println("You don't have anything to pry open this window. Maybe you should open that dresser....");
                            }
                        }
                        System.out.println("You have nothing to smash board with. It is forever stuck");
                    } else if (command.equals("open")) {
                        System.out.println("You open the dresser.");
                        if (hasHammer) {
                            System.out.println("The dresser is empty");
                        } else {
                            System.out.println("You find a hammer! I wonder what you could do with that...");
                            hasHammer = true;
                        }
                    } else if (command.equals("north")) {
                        location = "north";
                    } else if (command.equals("east")) {
                        location = "east";
                    } else if (command.equals("south")) {
                        location = "south";
                    } else {
                        System.out.println("That is not an option!!!!!!!");
                    }
                    break;
                case "east":
                    System.out.println("You are in the east wing.");
                    System.out.println("There is a table with a lamp in front of you.");
                    System.out.println("What would you like to do?");
                    System.out.println("Options: on, north, west, south");
                    command = console.nextLine().toLowerCase().trim();

                    if (command.equals("on")) {
                        if (lampOn) {
                            System.out.println("The lamp is already on! The lightbulb is " + lightColor + "!");
                        } else {
                            System.out.println("You turn the lamp on. The light is " + lightColor +"!");
                            lampOn = true;
                        }
                    } else if (command.equals("north")) {
                        location = "north";
                    } else if (command.equals("west")) {
                        location = "west";
                    } else if (command.equals("south")) {
                        location = "south";
                    } else {
                        System.out.println("That is not an option!!!!!!!");
                    }
                    break;
                case "south":
                    // The safe
                    System.out.println("You are in the south wing.");
                    System.out.println("There is a safe in front of you.");
                    System.out.println("What would you like to do?");
                    System.out.println("Options: open, north, east, west");
                    command = console.nextLine().toLowerCase().trim();

                    if (command.equals("open")) {
                        if (safeOpen) {
                            System.out.println("The safe is already open!");
                        } else {
                            System.out.println("What is the password for the safe?");
                            command = console.nextLine().toLowerCase().trim();

                            if (lightColor.equals("green") && command.equals("hulk")) {
                                System.out.println("You open the safe and get a key!");
                                hasKey = true;
                            } else if (lightColor.equals("blue") && command.equals("capt")) {
                                System.out.println("You open the safe and get a key!");
                                hasKey = true;
                            } else if (lightColor.equals("yellow") && command.equals("thor")) {
                                System.out.println("You open the safe and get a key!");
                                hasKey = true;
                            } else {
                                System.out.println("That didn't work...");
                            }
                        }
                    } else if (command.equals("north")) {
                        location = "north";
                    } else if (command.equals("east")) {
                        location = "east";
                    } else if (command.equals("west")) {
                        location = "west";
                    } else {
                        System.out.println("That is not an option!!!!!!!");
                    }

                    break;
            }

        } while (!location.equals("escaped!"));
    }
}
