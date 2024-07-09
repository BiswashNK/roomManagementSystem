import java.util.*;
import java.io.*;

/**
 * Date: October 4, 2023
 * Course: CSCI 2073
 * Description: MyBnb class is written to use and manage an ArrayList of
 * RentalRoom objects. It has a MyBnb constructor to create an array list to use
 * all the rental room and it contains numberOfRooms(), chooseRoom() and
 * numberOfStaffNeeded() methods to manage the rental rooms.
 * On my honor, I have neither given nor received unauthorized help while
 * completing this assignment.
 * Name - Biswash Kunwar CWID- 30158447
 */

public class MyBnb {
  /**
   * List of rental rooms.
   */
  private ArrayList<RentalRoom> arrList = new ArrayList<>();

  /**
   * Constructs a new MyBnb and loads room data from a file.
   * 
   * @param filename name of file containing room data
   */
  public MyBnb(String filename) {
    try {
      File file = new File(filename);
      Scanner stdin = new Scanner(file);
      while (stdin.hasNextLine()) {
        String line = stdin.nextLine();
        Scanner input = new Scanner(line);
        String id = input.next().trim();
        int beds = Integer.parseInt(input.next().trim());
        RentalRoom room = new RentalRoom(id, beds);
        arrList.add(room);
        input.close();
      }
      stdin.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

  }

  /**
   * Gets the number of rooms with the given number of beds.
   * 
   * @param beds number of beds
   * @return number of rooms with this bed count
   */
  public int numberOfRooms(int beds) {
    int numRooms = 0;
    for (RentalRoom each : arrList) {
      if (each.getNumBeds() == beds) {
        numRooms++;
      }
    }
    return numRooms;
  }

  /**
   * Chooses an available room with at least the given number of beds.
   * Marks the room as unavailable.
   * 
   * @param minBeds minimum number of beds
   * @return ID of chosen room or "NONE" if none available
   */

  public String chooseRoom(int minBeds) {
    String roomID = "NONE";

    for (int i = 0; i < arrList.size(); i++) {
      if (arrList.get(i).getNumBeds() >= minBeds && arrList.get(i).isAvailable()) {
        roomID = arrList.get(i).getID();
        arrList.get(i).setAvailable(false);
        return roomID;
      }

    }
    return roomID;

  }

  /**
   * Calculates the number of staff needed based on booked rooms.
   * 
   * @return number of staff needed
   */
  public int numberOfStaffNeeded() {
    int numStaff = 0;
    int countOneBed = 0;
    for (RentalRoom each : arrList) {
      if (!each.isAvailable() && each.getNumBeds() >= 3) {
        numStaff = numStaff + 2;

      } else if (!each.isAvailable()) {
        countOneBed++;
      }
    }
    if (countOneBed % 3 == 0) {
      numStaff = numStaff + (countOneBed / 3);
    } else if (countOneBed % 3 != 0) {
      numStaff = numStaff + 1 + (countOneBed / 3);
    }
    return numStaff;
  }

}
