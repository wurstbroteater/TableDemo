package de.ufo.tracktable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.NestedTableColumnHeader;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.control.skin.TableViewSkin;
import javafx.scene.input.MouseButton;

import java.util.HashMap;
import java.util.Map;

public class UfoTrackerController {
    @FXML
    private CustomTableView tableView;
    @FXML
    private TableColumn<UFO, String> uuidCol;
    @FXML
    private TableColumn<UFO, String> tempNameCol;
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
    @FXML
    private Button addBtn;
    @FXML
    private Button clearBtn;
    private final ObservableList<UFO> data = FXCollections.observableArrayList(Utils.createDummyData());
    private final double DEFAULT_SHRINK_SIZE = 50;
    private final Map<TableColumn<UFO, ?>, Width> columnToWidth = new HashMap<>();

    private record Width(double min, double pref, double max) {
    }

    @FXML
    public void initialize() {
        System.out.println("------------init table------------");

        uuidCol.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        tempNameCol.setCellValueFactory(new PropertyValueFactory<>("tempName"));
        isInRangeCol.setCellValueFactory(new PropertyValueFactory<>("isInRange"));
        latitudeCol.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        longitudeCol.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        altitudeCol.setCellValueFactory(new PropertyValueFactory<>("altitude"));
        detectorCol.setCellValueFactory(new PropertyValueFactory<>("detector"));
        lastUpdateCol.setCellValueFactory(new PropertyValueFactory<>("lastUpdate"));
        usdValueCol.setCellValueFactory(new PropertyValueFactory<>("usdValue"));
        addBtn.setOnAction(e -> {
            if (tableView.getItems().isEmpty()) {
                tableView.setItems(data);
            }
        });
        clearBtn.setOnAction(e -> {
            tableView.setItems(FXCollections.observableArrayList());
        });



        tableView.setTableMenuButtonVisible(true);
        tableView.getColumns().forEach(c -> c.getContextMenu().setOnAction(e -> {
            System.out.println("hee " + e.getSource() + " " + e.getEventType());
        }));
        //prepare custom click listeners for TableColumn
        //tableView.getColumns().forEach(this::createMappingFor);
        //tableView.setOnMouseClicked(e -> setHeaderClickListeners());

    }


    private void createMappingFor(final TableColumn<UFO, ?> column) {
        columnToWidth.put(column, new Width(column.getMinWidth(), column.getPrefWidth(), column.getMaxWidth()));
    }

    /**
     * <a href="https://stackoverflow.com/questions/42436119/javafx-tableview-click-on-header">Link to Solution</a>
     * TODO: Fix bug: The "old" Listener is still active which causes the table to reorder its items on right click
     */
    private void setHeaderClickListeners() {
        // Step 1: Get the table header row.
        TableHeaderRow headerRow = null;
        for (Node n : ((TableViewSkin<?>) tableView.getSkin()).getChildren()) {
            if (n instanceof TableHeaderRow) {
                headerRow = (TableHeaderRow) n;
                break;
            }
        }
        if (headerRow == null) {
            return;
        }

        // Step 2: Get the list of the header columns.
        final NestedTableColumnHeader ntch = (NestedTableColumnHeader) headerRow.getChildren().get(1);
        ObservableList<TableColumnHeader> headers = ntch.getColumnHeaders();

        // Step 3: Add click listener to the header columns.
        headers.forEach(header -> header.setOnMouseClicked(mouseEvent -> {
            // Optional:
            // Get the TableColumnBase (which is the object responsible
            // for displaying the content of the column.)
            var column = header.getTableColumn();
            System.out.println(column);

            // Step 4: Handle double mouse click event.
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                System.err.printf("%s min=%.2f pref=%.2f max=%.2f", column.getId(), column.getMinWidth(), column.getPrefWidth(), column.getMaxWidth());
                if (column.getMinWidth() == DEFAULT_SHRINK_SIZE
                        && column.getPrefWidth() == DEFAULT_SHRINK_SIZE
                        && column.getMaxWidth() == DEFAULT_SHRINK_SIZE) {
                    column.setMinWidth(columnToWidth.get(column).min());
                    column.setPrefWidth(columnToWidth.get(column).pref());
                    column.setMaxWidth(columnToWidth.get(column).max());
                } else {
                    column.setMinWidth(DEFAULT_SHRINK_SIZE);
                    column.setMaxWidth(DEFAULT_SHRINK_SIZE);
                    column.setPrefWidth(DEFAULT_SHRINK_SIZE);
                }
            }
        }));
    }
}