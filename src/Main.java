import com.capstone.dao.BookingDao;
import com.capstone.dao.UserDao;
import com.capstone.dao.arraydataaccess.BookingArrayDataAccess;
import com.capstone.dao.arraydataaccess.UserArrayDataAccess;
import com.capstone.screens.BookCarScreen;
import com.capstone.screens.BookingByUserScreen;
import com.capstone.screens.IScreen;
import com.capstone.service.BookingService;
import com.capstone.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final BookingDao bookingDao = new BookingArrayDataAccess();
    private static final BookingService bookingService = new BookingService(bookingDao);
    private static final UserDao userDao = new UserArrayDataAccess();
    private static final UserService userService = new UserService(userDao);
    private static final Scanner scanner = new Scanner(System.in);
    static IScreen[] screens = {
            new BookCarScreen(),
            new BookingByUserScreen(bookingService, userService)
    };

    public static void main(String[] args) {
        Integer choice = 0;

        while (choice != 7) {
            displayMenu();
            choice = getChoice(scanner);
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
        if (choice < 1 && choice > 7) {
            System.out.println("Invalid choice, please try again.");
            return 0;
        }
        return choice;
    }
}