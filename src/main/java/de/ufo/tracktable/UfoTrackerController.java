package de.ufo.tracktable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class UfoTrackerController {
    @FXML
    private TableView<UFO> tableView = new TableView<>();
    @FXML
    private TableColumn<UFO, String> uuidCol;
    private final double UUID_LBL_DEFAULT_MIN_WIDTH = 59.0;
    @FXML
    private TableColumn<UFO, String> tempNameCol;
    private final double tempName_LBL_DEFAULT_MIN_WIDTH = 145.0;
    private Label tempNameLbl;
    @FXML
    private TableColumn<UFO, Boolean> isInRangeCol;
    private Label isInRangeLbl;
    @FXML
    private TableColumn<UFO, Double> latitudeCol;
    private Label latitudeLbl;
    @FXML
    private TableColumn<UFO, Double> longitudeCol;
    private Label longitudeLbl;
    @FXML
    private TableColumn<UFO, Double> altitudeCol;
    private Label altitudeLbl;
    @FXML
    private TableColumn<UFO, String> detectorCol;
    private Label detectionPlatformLbl;
    @FXML
    private TableColumn<UFO, String> lastUpdateCol;
    private Label lastUpdateLbl;
    @FXML
    private TableColumn<UFO, Long> usdValueCol;
    private Label usdValueLbl;
    private final ObservableList<UFO> data = FXCollections.observableArrayList(Utils.createDummyData());

    public void initialize() {
        System.out.println("------------init table------------");

        uuidCol.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        tempNameCol.setCellValueFactory(new PropertyValueFactory<>("tempName"));
        System.out.println(tempNameCol.getGraphic());

        isInRangeCol.setCellValueFactory(new PropertyValueFactory<>("isInRange"));
        latitudeCol.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        longitudeCol.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        altitudeCol.setCellValueFactory(new PropertyValueFactory<>("altitude"));
        detectorCol.setCellValueFactory(new PropertyValueFactory<>("detector"));
        lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        usdValueCol.setCellValueFactory(new PropertyValueFactory<>("usdValue"));

        tableView.setItems(data);
    }

}