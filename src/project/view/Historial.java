/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Andryut Huertas
 */
public class Historial {

    private GridPane grid;

    private TableView tableView;

    private Button backBttn;

    public Historial() {
        this.grid = new GridPane();
        String style = "-fx-background-color: rgb(255, 255, 255);";
        Text title = new Text("MapUN");
        title.setFill(Color.BLACK);
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 70));
        this.grid.setStyle(style);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        this.grid.setHgap(100);
        this.grid.setVgap(50);
        this.grid.add(title, 0, 0);

        this.tableView = new TableView();
        TableColumn product = new TableColumn("Producto");
        TableColumn hour = new TableColumn("Hora");
        TableColumn place = new TableColumn("Lugar");

        //Esto se realiza en el controlador de la vista.
//        ObservableList<Person> data = FXCollections.observableArrayList(
//                new Person("Jacob", "Smith", "jacob.smith@example.com"),
//                new Person("Isabella", "Johnson",
//                        "isabella.johnson@example.com"),
//                new Person("Ethan", "Williams", "ethan.williams@example.com"),
//                new Person("Emma", "Jones", "emma.jones@example.com"),
//                new Person("Michael", "Brown", "michael.brown@example.com")
//        );
        product.setCellValueFactory(new PropertyValueFactory<>("producto"));
        hour.setCellValueFactory(new PropertyValueFactory<>("hora"));
        place.setCellValueFactory(new PropertyValueFactory<>("lugar"));

        tableView.getColumns().addAll(product, hour, place);
        //También en el controlador.
//        tableView.setItems(data);

//        ObservableList selectedCells = tableView.getSelectionModel().getSelectedCells();
//        selectedCells.addListener(new ListChangeListener() {
//            @Override
//            public void onChanged(ListChangeListener.Change c) {
//                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
//                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
//                System.out.println("Selected Value" + val);
//            }
//        });
        Label label = new Label("Historial");
        this.backBttn = new Button("Volver");
        VBox vbox = new VBox(label, this.tableView, this.backBttn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(25);
        this.grid.add(vbox, 0, 1);

    }

    public void show(Stage primaryStage) {
        primaryStage.setTitle("Titulo de la ventana");
        primaryStage.getScene().setRoot(this.grid);
        primaryStage.show();
    }

    //getter and setter only for dynamic and modified elements
    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

    public Button getBackBttn() {
        return backBttn;
    }

    public void setBackBttn(Button backBttn) {
        this.backBttn = backBttn;
    }

}
