import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Calendar;

public class CalendarApp extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Show the calendar for November 2024
        GridPane grid = new GridPane();
        displayCalendar(2024, 11, grid); // This will display the calendar directly on the grid

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void displayCalendar(int year, int month, GridPane grid) {
        // Adjust month for 0-based indexing in Calendar (0 = January)
        month--;

        // Create a calendar instance
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);

        // Print calendar header
        Label header = new Label("   Calendar for " + year + ", " + getMonthName(month));
        grid.add(header, 0, 0, 7, 1); // Calendar header across 7 columns

        // Print weekday names (Su, Mo, Tu, ...)
        String[] weekdays = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
        for (int i = 0; i < 7; i++) {
            Label dayLabel = new Label(weekdays[i]);
            grid.add(dayLabel, i, 1);
        }

        // Get the first day of the month and number of days in the month
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Add spaces for the first day of the week
        int row = 2;
        int col = firstDayOfWeek - 1;
        for (int day = 1; day <= daysInMonth; day++) {
            Label dayLabel = new Label(String.valueOf(day));
            grid.add(dayLabel, col, row);

            // Move to the next column
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
    }

    public static String getMonthName(int month) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[month];
    }
}
