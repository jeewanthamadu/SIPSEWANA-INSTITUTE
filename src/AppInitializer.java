import entity.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
     /*   Student student = new Student();
        student.setRegNumber("112");
        student.setAddress("fevrkbjgnf");
        student.setAge(23);
        student.setDob("jfef");
        student.setEmail("ejfflef");
        student.setGender("efje");
        student.setContactNumber("ff");
        student.setNic("dwfw");
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student1 = session.get(Student.class, "112");
        session.delete(student1);
        session.save(student);

        transaction.commit();
        session.close();*/
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/LoginForm.fxml"))));
        primaryStage.setTitle("SipSewana Institute ");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

}
