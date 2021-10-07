import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String[] directions = {"n:", "e:", "s:", "w:"};
        List<Room> dungeonMap = new ArrayList<>();

        File fileWithMap = new File("dungeon_map.txt");
        Scanner scanner = new Scanner(fileWithMap);

        while (scanner.hasNextLine()) {

            String n = "wall";
            String e = "wall";
            String s = "wall";
            String w = "wall";

            String line = scanner.nextLine();
            String roomNo = line.substring(0, 2);

            for (String direction : directions) {

                Pattern pattern = Pattern.compile(direction);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String doorTo = line.substring(matcher.end(), matcher.end() + 2);
                    if (direction.equals("n:")) n = doorTo;
                    if (direction.equals("e:")) e = doorTo;
                    if (direction.equals("s:")) s = doorTo;
                    if (direction.equals("w:")) w = doorTo;
                }
            }

            Room room = new Room(roomNo, n, e, s, w);
            dungeonMap.add(room);
        }

        boolean endGame = false;

        Random random = new Random();
        int randomRoomIndex = random.nextInt(dungeonMap.size());
        Room currentRoom = dungeonMap.get(randomRoomIndex);
        System.out.println("You are in room " + currentRoom.getRoomNo());

        while (!endGame) {

            if (!currentRoom.getN().equals("wall"))
                System.out.println("Type N to go North to room " + currentRoom.getN());
            if (!currentRoom.getE().equals("wall"))
                System.out.println("Type E to go East to room " + currentRoom.getE());
            if (!currentRoom.getS().equals("wall"))
                System.out.println("Type S to go South to room " + currentRoom.getS());
            if (!currentRoom.getW().equals("wall"))
                System.out.println("Type W to go West to room " + currentRoom.getW());
            System.out.println("Or type Q to exit game\n--------------------------");

            System.out.print("Enter direction: ");
            Scanner inputScanner = new Scanner(System.in);
            String direction = inputScanner.nextLine();

            switch (direction) {
                case "N":
                    if (!currentRoom.getN().equals("wall")) {
                        for (int i = 0, j = 0; i < dungeonMap.size() && j < 1; i++) {
                            if (dungeonMap.get(i).getRoomNo().equals(currentRoom.getN())) {
                                currentRoom = dungeonMap.get(i);
                                j++;
                            }
                        }
                        System.out.println("Now you have moved to room " + currentRoom.getRoomNo());
                    } else {
                        noMove();
                    }
                    break;

                case "E":
                    if (!currentRoom.getE().equals("wall")) {
                        for (int i = 0, j = 0; i < dungeonMap.size() && j < 1; i++) {
                            if (dungeonMap.get(i).getRoomNo().equals(currentRoom.getE())) {
                                currentRoom = dungeonMap.get(i);
                                j++;
                            }
                        }
                        System.out.println("Now you have moved to room " + currentRoom.getRoomNo());
                    } else {
                        noMove();
                    }
                    break;

                case "S":
                    if (!currentRoom.getS().equals("wall")) {
                        for (int i = 0, j = 0; i < dungeonMap.size() && j < 1; i++) {
                            if (dungeonMap.get(i).getRoomNo().equals(currentRoom.getS())) {
                                currentRoom = dungeonMap.get(i);
                                j++;
                            }
                        }
                        System.out.println("Now you have moved to room " + currentRoom.getRoomNo());
                    } else {
                        noMove();
                    }
                    break;

                case "W":
                    if (!currentRoom.getW().equals("wall")) {
                        for (int i = 0, j = 0; i < dungeonMap.size() && j < 1; i++) {
                            if (dungeonMap.get(i).getRoomNo().equals(currentRoom.getW())) {
                                currentRoom = dungeonMap.get(i);
                                j++;
                            }
                        }
                        System.out.println("Now you have moved to room " + currentRoom.getRoomNo());
                    } else {
                        noMove();
                    }
                    break;

                case "Q":
                    System.out.println("Game is over");
                    endGame = true;
                    break;

                default:
                    System.out.println("Incorrect selection!");
            }
        }
    }

    public static void noMove() {
        System.out.println("You can't move to that direction!");
    }


}