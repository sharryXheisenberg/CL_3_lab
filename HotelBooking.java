import java.rmi.*;
import java.rmi.RemoteException;

public interface HotelBooking extends Remote {
    // Method to book a room
    boolean bookRoom(String guestName) throws RemoteException;

    // Method to cancel a booking
    boolean cancelBooking(String guestName) throws RemoteException;

    // Method to check if a room is available
    boolean isRoomAvailable() throws RemoteException;
}
