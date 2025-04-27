import java.rmi.Naming;

public class HotelClient {
    public static void main(String[] args) {
        try {
            HotelBooking hotelBooking = (HotelBooking) Naming.lookup("rmi://localhost/HotelBookingService");

            boolean booked = hotelBooking.bookRoom("John Doe");
            System.out.println(booked ? "Room successfully booked." : "Failed to book the room.");

            boolean available = hotelBooking.isRoomAvailable();
            System.out.println(available ? "Room is available." : "Room is not available.");

            boolean cancelled = hotelBooking.cancelBooking("John Doe");
            System.out.println(cancelled ? "Booking successfully canceled." : "Failed to cancel the booking.");

        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
