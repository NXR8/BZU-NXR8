# Hotel Management System

This project is a Java-based Hotel Management System designed to manage hotel rooms, including functionalities like displaying room details, reserving rooms, updating room information, and saving/loading room data from files.

## Project Overview

The project consists of three main classes:

1. **Room.java**: Represents a single room in the hotel. It contains details such as room number, floor number, room type, occupancy status, capacity, price per night, and customer name (if occupied).

2. **RoomManagement.java**: Manages an array of `Room` objects. It provides functionalities to display all rooms, show available rooms, change room details, search rooms by type or capacity, sort rooms by price, reserve rooms, and read/save room data from/to files.

3. **Driver.java**: The main driver class that interacts with the user through a command-line interface. It displays a menu and allows the user to perform various operations on the rooms.

## Features

- **Show All Rooms**: Displays details of all rooms in the hotel.
- **Show Available Rooms**: Displays details of rooms that are not occupied.
- **Change Room Details**: Allows the user to modify room details such as room type, occupancy status, capacity, and price per night.
- **Search by Room Type**: Searches for rooms based on their type (Standard, Family, Suite).
- **Search by Capacity**: Searches for rooms based on their capacity.
- **Sort and Display Rooms by Price**: Sorts rooms by their price per night in ascending order and displays them.
- **Reserve a Room**: Allows the user to reserve a specific room by entering the customer's first and last name.
- **Read Room Details from File**: Reads room details from a file and updates the room data accordingly.
- **Save Rooms Data to File**: Saves the current room data to a file for future use.

## File Formats

### Reading from a File
The file should contain room details in the following format:
```
roomNo RoomType isOccupied Capacity pricePerNight
```
Example:
```
201 Standard false 2 150.0
301 Family true 4 200.0
```

### Saving to a File
The program will save room details in the same format as the reading file:
```
roomNo RoomType isOccupied Capacity pricePerNight
```

## Example Usage

1. **Show All Rooms**:
   - Select option `a` from the menu to display all rooms.

2. **Reserve a Room**:
   - Select option `g` from the menu, then enter the room number and customer details.

3. **Save Rooms Data to File**:
   - Select option `i` from the menu, then enter the filename to save the room data.

## Project Structure

```
hotel-management-system/
├── Room.java
├── RoomManagement.java
├── Driver.java
├── README.md
└── rooms.txt (example file for reading/saving room data)
```

## Requirements

- Java Development Kit (JDK) 8 or higher.
- A text editor or IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

**Note**: This project was developed as part of the Comp1331 course at the Computer Science Department. It is intended for educational purposes.
```
