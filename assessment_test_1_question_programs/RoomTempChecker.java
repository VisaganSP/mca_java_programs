import java.util.Scanner;
import java.io.IOException;

class TemperatueOutOfRangeException extends IOException {
    TemperatueOutOfRangeException(String message) {
        super(message);
    }
}

class Room {
    private int temperature;

    Room(int temperature) {
        this.temperature = temperature;
    }

    public void checkRoomTemperature() throws TemperatueOutOfRangeException {
        if (temperature < 15 || temperature > 26) {
            throw new TemperatueOutOfRangeException("Temperature exceeds normal room temperature!...");
        } else {
            System.out.println("Room is in normal temperature.");
        }
    }
}

class RoomTempChecker {

    public static void main(String[] args) {
        int temperature;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the current temperature of your room: ");
        temperature = in.nextInt();

        Room room = new Room(temperature);

        try {
            room.checkRoomTemperature();
        } catch(TemperatueOutOfRangeException e) {
            System.out.println("Exception occurred: " + e);
        } finally {
            in.close();
        }
    }
}