package pao.homework;
/* . Write a program to create a Room object, the attributes of this object are room number, room
type and room floor. Define a constructor for this class as well as accessors and mutators for all
the attributes. Create two objects of type and display the information for them on separate
lines. */


public class Room {

    private int roomNumber;
    private String roomType;
    private int floor;

    public Room(){

        this.roomNumber = 0;
        this.roomType = "";
        this.floor = 0;

    }

    public Room(int roomNumber, String roomType, int floor) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floor = floor;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public String toString(){
        return   "Room number: " + roomNumber
                + ", Type: " + this.roomType
                + ", Floor: " + this.floor;
    }
}



