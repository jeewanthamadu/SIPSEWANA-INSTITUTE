package controller;

import bo.BOFactory;
import bo.custom.impl.ProgrammeBOImpl;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import dao.custom.impl.ProgrammeDAOImpl;
import dto.ProgrammeDTO;
import dto.StudentDTO;
import entity.Programme;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.tm.ProgrammeTM;
import view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class ManageStudentRegistrationFormController {
    public AnchorPane srContext;
    public Label lblDate;
    public Label lblTime;
    public TableView tblRegister;
    public TableColumn colRegNo;
    public TableColumn colName;
    public TableColumn colAge;
    public TableColumn colNic;
    public TableColumn colContactNumber;
    public TableColumn colAddress;
    public TableColumn colDob;
    public TableColumn colEmail;
    public TableColumn colGender;
    public JFXTextField txtRegNo;
    public JFXTextField txtName;
    public JFXTextField txtDob;
    public JFXTextField txtContactNumber;
    public JFXTextField txtAddress;
    public JFXTextField txtAge;
    public JFXTextField txtEmail;
    public JFXComboBox<String> cmbProgrammeID01;
    public JFXTextField txtProgramme01;
    public JFXTextField txtFee01;
    public JFXTextField cmbDuration01;
    public JFXComboBox<String> cmbProgrammeID02;
    public JFXTextField txtProgramme02;
    public JFXTextField txtFee02;
    public JFXTextField cmbDuration02;
    public JFXComboBox<String> cmbProgrammeID03;
    public JFXTextField txtProgramme03;
    public JFXTextField txtFee03;
    public JFXTextField cmbDuration03;
    public JFXTextField txtNic;
    public RadioButton rdMale;
    public RadioButton rdFemale;
    public ToggleGroup gender;
    public CheckBox cb;
    public CheckBox cb1;
    public CheckBox cb2;

    StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);
    ProgrammeBOImpl programmeBO = (ProgrammeBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAMME);

    public void initialize(){
        loadDateAndTime();
        loadProgramId();
        setDisableChoose();
        showProgrammesOnTable();

        cmbProgrammeID01.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgrammeData(txtProgramme01,cmbDuration01,txtFee01,newValue);
        });

        cmbProgrammeID02.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgrammeData(txtProgramme02,cmbDuration02,txtFee02,newValue);
        });

        cmbProgrammeID03.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgrammeData(txtProgramme03,cmbDuration03,txtFee03,newValue);
        });


    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour()+ " : "+currentTime.getMinute()+ " : "+currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) srContext.getScene().getWindow();
        window.setScene(new Scene(load));
        window.centerOnScreen();
        window.setResizable(false);
    }

    public void txtSearch(KeyEvent keyEvent) {
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }

    public String selectedGender(){
        if (rdMale.isSelected()){
            return "Male";
        }else if(rdFemale.isSelected()){
            return  "Female";
        }else {
            return null;
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {

        StudentDTO studentDTO = new StudentDTO(
                txtRegNo.getText(),
                txtName.getText(),
                Integer.parseInt(txtAge.getText()),
                txtContactNumber.getText(),
                txtAddress.getText(),
                txtDob.getText(),
                txtEmail.getText(),
                txtNic.getText(),
                selectedGender()
        );

        if(studentBO.add(studentDTO)){
           showProgrammesOnTable();
            new Alert(Alert.AlertType.CONFIRMATION,"Student Add Successfully").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Something Went Wrong").show();
        }

    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void tblOnClicked(MouseEvent mouseEvent) {
    }

    private void loadProgramId(){
        List<String> allProgramIds = programmeBO.getAllProgramIds();
        cmbProgrammeID01.getItems().addAll(allProgramIds);
        cmbProgrammeID02.getItems().addAll(allProgramIds);
        cmbProgrammeID03.getItems().addAll(allProgramIds);
    }

    public void cbOnClick(MouseEvent mouseEvent) {
        if(cb1.isSelected()){
            cmbProgrammeID02.setDisable(false);
            txtProgramme02.setDisable(false);
            cmbDuration02.setDisable(false);
            txtFee02.setDisable(false);
      }else {
            cmbProgrammeID02.setDisable(true);
            txtProgramme02.setDisable(true);
            cmbDuration02.setDisable(true);
            txtFee02.setDisable(true);
        }

        if(cb2.isSelected()){
            cmbProgrammeID03.setDisable(false);
            txtProgramme03.setDisable(false);
            cmbDuration03.setDisable(false);
            txtFee03.setDisable(false);
        }else {
            cmbProgrammeID03.setDisable(true);
            txtProgramme03.setDisable(true);
            cmbDuration03.setDisable(true);
            txtFee03.setDisable(true);
        }
    }

    public void setDisableChoose(){
        cmbProgrammeID02.setDisable(true);
        txtProgramme02.setDisable(true);
        cmbDuration02.setDisable(true);
        txtFee02.setDisable(true);

        cmbProgrammeID03.setDisable(true);
        txtProgramme03.setDisable(true);
        cmbDuration03.setDisable(true);
        txtFee03.setDisable(true);
    }

    private void setProgrammeData(JFXTextField enterProgramme, JFXTextField enterDuration, JFXTextField enterFee, String ProgrammeID) {
        ProgrammeDTO programmeDetails = programmeBO.getProgrammeDetails(ProgrammeID);

        if (programmeDetails == null) {
        } else {
            enterProgramme.setText(programmeDetails.getProgrammeName());
            enterDuration.setText(programmeDetails.getDuration());
            enterFee.setText(programmeDetails.getFee() + "");
        }
    }

    public void showProgrammesOnTable() {
        ObservableList<StudentTM> list = studentBO.find();

        colRegNo.setCellValueFactory(new PropertyValueFactory<>("regNumber"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tblRegister.setItems(list);
    }

}
