import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;




public class LoginPage extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // UI elements for login
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(usernameField.getText(), passwordField.getText(), primaryStage));

        VBox layout = new VBox(10, usernameField, passwordField, loginButton);
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Handle the login logic
    private void handleLogin(String username, String password, Stage primaryStage) {
        String correctUsername = "user";
        String correctPassword = "password";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            // Show success message
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("Login successful! Redirecting to calendar...");
            alert.showAndWait();

            // Now show the calendar after successful login
            // Create an instance of CalendarApp
            CalendarApp calendarApp = new CalendarApp();
            // Create a GridPane to display the calendar
            GridPane grid = new GridPane();
            // Pass the GridPane to the displayCalendar method
            calendarApp.displayCalendar(2024, 11, grid);

            // Create a scene for the calendar
            Scene calendarScene = new Scene(grid, 400, 400);
            Stage calendarStage = new Stage();
            calendarStage.setTitle("Calendar");
            calendarStage.setScene(calendarScene);
            calendarStage.show();

            // Close the login window
            primaryStage.close();
        } else {
            // Show error message
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }
    }
}
