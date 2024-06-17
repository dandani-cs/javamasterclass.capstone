import com.capstone.dao.BookingDao;
import com.capstone.dao.CarDao;
import com.capstone.dao.UserDao;
import com.capstone.dao.csvdataaccess.BookingCSVDataAccess;
import com.capstone.dao.csvdataaccess.CarCSVDataAccess;
import com.capstone.dao.csvdataaccess.UserCSVDataAccess;
import com.capstone.screens.*;
import com.capstone.service.BookingService;
import com.capstone.service.CarService;
import com.capstone.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final UserDao userDao = new UserCSVDataAccess();
    private static final UserService userService = new UserService(userDao);
    private static final CarDao carDao = new CarCSVDataAccess();
    private static final CarService carService = new CarService(carDao);
    private static final BookingDao bookingDao = new BookingCSVDataAccess();
    private static final BookingService bookingService = new BookingService(bookingDao, userService, carService);
    private static final Scanner scanner = new Scanner(System.in);
    static IScreen[] screens = {
            new BookCarScreen(bookingService),
            new BookingByUserScreen(bookingService, userService),
            new BookingsScreen(bookingService),
            new CarsScreen(carService),
            new ElectricCarsScreen(carService),
            new UsersScreen(userService)
    };

    public static void main(String[] args) {
        Integer choice;

        while (true) {
            displayMenu();
            choice = getChoice(scanner);
            if (choice == 0) {
                continue;
            }
            if (choice == 7) {
                System.out.println("Exiting application...");
                return;
            }
            IScreen screen = screens[choice - 1];
            screen.display(scanner);
        }
    }

    public static void displayMenu() {
        System.out.println("""
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View all users
                7️⃣ - Exit
                """);
    }

    public static Integer getChoice(Scanner scanner) {
        int choice;
        System.out.print("Enter choice: ");
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again.");
            return 0;
        }
        if (choice < 1 || choice > 7) {
            System.out.println("Invalid choice, please try again.");
            return 0;
        }
        return choice;
    }
}

// GENERAL TODO
// extract file read and write
// check for other methods that can be streamlined
// remove lots of booking to booking entity and vice versa conversion