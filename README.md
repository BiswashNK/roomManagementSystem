**MyBnb Rental Room Management**********
Overview

This Java project simulates a simple room rental management system. The program uses a class MyBnb to manage an array list of rental rooms represented by the RentalRoom class. The system allows you to check the number of rooms available with a specific bed count, book a room based on the number of beds required, and calculate the number of staff needed based on booked rooms.
Project Files

The project consists of the following files:

    MyBnb.java
        This class manages an array list of RentalRoom objects. It allows the user to perform the following:
            Load room data from a file.
            Check the number of available rooms with a specific number of beds.
            Book a room with at least a minimum number of beds.
            Calculate the number of staff required based on room bookings.

    RentalRoom.java
        This class represents a rental room with basic properties like:
            Room ID.
            Number of beds.
            Availability status.

    RoomsTest.java
        This class is a test program to demonstrate the functionality of the MyBnb class by loading room data from a file and performing operations like booking rooms and calculating staff requirements.

    rental1.txt
        A text file containing room data in the format:

roomID numBeds

Example:

        AB1213 3
        AB1212 1
        AB233 1
        AB234 2

        (This file must be created separately with data.)

Features

    Load Room Data
    The MyBnb constructor reads room data from a file and stores the information in an ArrayList of RentalRoom objects.

    Get Number of Rooms
    The numberOfRooms method returns the number of rooms with a specific number of beds.

    Choose a Room
    The chooseRoom method allows the user to book a room that has at least the required number of beds. The room is marked as unavailable once booked.

    Calculate Number of Staff
    The numberOfStaffNeeded method calculates how many staff are needed based on the rooms that are booked:
        For rooms with 3 or more beds, 2 staff are needed per room.
        For rooms with less than 3 beds, 1 staff is needed for every 3 rooms.

How to Run

    Prepare the Room Data File:
        Create a text file (e.g., rental1.txt) containing room data in the following format:

    roomID numBeds

    Each line represents a rental room with the room ID and the number of beds.

Compile and Run:

    Compile all the Java files:

    bash

javac MyBnb.java RentalRoom.java RoomsTest.java

Run the RoomsTest class:

bash

    java RoomsTest

Expected Output: The RoomsTest class will print the following expected outputs based on the test cases:

javascript

    Number of rooms with 2 bed(s): 3
    AB1213
    2
    AB1212
    3
    AB233
    3

Dependencies

    Java Development Kit (JDK) 8 or higher.
