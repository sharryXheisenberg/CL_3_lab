import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class HotelServer extends UnicastRemoteObject implements HotelBooking {

    private boolean roomAvailable;

    public HotelServer() throws RemoteException {
        super();
        roomAvailable = true;
    }

    public boolean bookRoom(String guestName) throws RemoteException {
        if (roomAvailable) {
            roomAvailable = false;
            System.out.println("Room booked successfully for guest: " + guestName);
            return true;
        } else {
            System.out.println("Room is already booked.");
            return false;
        }
    }

    public boolean cancelBooking(String guestName) throws RemoteException {
        if (!roomAvailable) {
            roomAvailable = true;
            System.out.println("Booking canceled for guest: " + guestName);
            return true;
        } else {
            System.out.println("No booking found to cancel.");
            return false;
        }
    }

    public boolean isRoomAvailable() throws RemoteException {
        return roomAvailable;
    }

    public static void main(String[] args) {
        try {
            // **Start RMI registry programmatically**
            LocateRegistry.createRegistry(1099);

            HotelServer server = new HotelServer();
            Naming.rebind("HotelBookingService", server);
            System.out.println("Hotel Booking Server is running...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
