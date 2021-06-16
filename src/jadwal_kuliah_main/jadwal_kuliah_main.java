package jadwal_kuliah_main;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import jadwal_kuliah.connectdb.database;
import jadwal_kuliah.model.model;


public class jadwal_kuliah_main extends Application {


    public TableView tblView;
    private Text txtInfo;
    private Label lblTitle, lblData, lblid_jadwal_kuliah, lblmatkul, lblwaktu, lblgkb, lblruangan, lblnama_dosen, lblCari;
    public TextField txtid_jadwal_kuliah, txtmatkul, txtwaktu, txtgkb, txtruangan, txtnama_dosen, txtCARI;
    public TableColumn tblColumn1, tblColumn2, tblColumn3, tblColumn4, tblColumn5, tblColumn6;
    private SplitPane splitPaneH;
    private VBox panevbox, panevbox2;
    private AnchorPane pane;
    private GridPane grid;
    private HBox panehbox, searchbox;
    private Button btnAdd, btnUpdate, btnDelete, btnClear, btnClose, btnRefresh;
    model modelDb;
    ObservableList data = FXCollections.observableArrayList();

    public void initComponent ( ) {
        //========================================================================

        lblData = new Label("MASUKKAN DATA");
        lblTitle = new Label("DATA JADWAL KULIAH");
        lblid_jadwal_kuliah = new Label("ID");
        lblmatkul = new Label("Mata Kuliah");
        lblwaktu = new Label("Waktu");
        lblgkb = new Label("GKB");
        lblruangan = new Label("Ruangan");
        lblnama_dosen = new Label("Nama Dosen");

        lblCari = new Label("CARI :");

        txtInfo = new Text("Tidak Ada Data");

        tblColumn1 = new TableColumn("ID");
        tblColumn2 = new TableColumn("Matkul");
        tblColumn3 = new TableColumn("Waktu");
        tblColumn4 = new TableColumn("GKB");
        tblColumn5 = new TableColumn("Ruangan");
        tblColumn6 = new TableColumn("Nama Dosen");

        txtid_jadwal_kuliah = new TextField();
        txtmatkul = new TextField();
        txtwaktu = new TextField();
        txtgkb = new TextField();
        txtruangan = new TextField();
        txtnama_dosen = new TextField();

        txtCARI = new TextField();
        splitPaneH = new SplitPane();
        pane = new AnchorPane();
        panevbox = new VBox();
        panevbox2 = new VBox();
        grid = new GridPane();
        panehbox = new HBox(5);
        searchbox = new HBox(5);
        tblView = new TableView();
        btnAdd = new Button("Buat");
        btnUpdate = new Button("Update");
        btnDelete = new Button("Hapus");
        btnClear = new Button("Clear");
        btnClose = new Button("Tutup");
        btnRefresh = new Button("Refresh");

        //========================================================================

        tblColumn1.setCellValueFactory(new PropertyValueFactory("ID"));
        tblColumn2.setCellValueFactory(new PropertyValueFactory("Mata Kuliah"));
        tblColumn3.setCellValueFactory(new PropertyValueFactory("Waktu"));
        tblColumn4.setCellValueFactory(new PropertyValueFactory("GKB"));
        tblColumn5.setCellValueFactory(new PropertyValueFactory("Ruangan"));
        tblColumn6.setCellValueFactory(new PropertyValueFactory("Nama Dosen"));

        txtid_jadwal_kuliah.setPromptText("Masukkan ID");
        txtmatkul.setPromptText("Masukkan Mata Kuliah");
        txtwaktu.setPromptText("Masukkan Waktu");
        txtgkb.setPromptText("Masukkan GKB");
        txtruangan.setPromptText("Masukkan Ruangan");
        txtnama_dosen.setPromptText("Masukkan Nama Dosen");

        txtCARI.setPromptText("Pencarian dengan Mata Kuliah");

        lblCari.setPadding(new Insets(10));
        lblCari.setFont(Font.font("Consolas", FontWeight.BOLD, 12));
        lblCari.setAlignment(Pos.CENTER);

        lblData.setPadding(new Insets(10));
        lblData.setFont(Font.font("Consolas", FontWeight.BOLD, 22));
        lblData.setAlignment(Pos.CENTER);

        lblTitle.setPadding(new Insets(10));
        lblTitle.setFont(Font.font("Consolas", FontWeight.BOLD, 22));
        lblTitle.setAlignment(Pos.CENTER);

        lblid_jadwal_kuliah.setPrefSize(100, 30);
        lblmatkul.setPrefSize(100, 30);
        lblwaktu.setPrefSize(100, 30);
        lblgkb.setPrefSize(100, 30);
        lblruangan.setPrefSize(100, 30);
        lblnama_dosen.setPrefSize(100, 30);

        txtid_jadwal_kuliah.setPrefSize(250, 30);
        txtmatkul.setPrefSize(250, 30);
        txtwaktu.setPrefSize(250, 30);
        txtgkb.setPrefSize(250, 30);
        txtruangan.setPrefSize(250, 30);
        txtnama_dosen.setPrefSize(250, 30);

        txtCARI.setPrefSize(250, 30);

        tblView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        tblView.setPlaceholder(txtInfo);
        tblView.setPadding(new Insets(10));
        tblView.getColumns().addAll(tblColumn1, tblColumn2, tblColumn3, tblColumn4, tblColumn5, tblColumn6);
        tblView.setPrefHeight(250);
        tblView.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
        //tblView.setText(Color.WHITE);

        panehbox.setAlignment(Pos.CENTER);
        panehbox.setPadding(new Insets(10));
        panehbox.setLayoutX(40);
        panehbox.setLayoutY(254);
        panehbox.getChildren().addAll(btnAdd, btnUpdate, btnDelete, btnClear, btnClose);

        searchbox.setAlignment(Pos.CENTER_LEFT);
        searchbox.setPadding(new Insets(5));
        searchbox.getChildren().addAll(lblCari, txtCARI, btnRefresh);
        searchbox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setLayoutX(5);
        grid.setLayoutY(5);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.addRow(0, lblid_jadwal_kuliah, txtid_jadwal_kuliah);
        grid.addRow(1, lblmatkul, txtmatkul);
        grid.addRow(2, lblwaktu, txtwaktu);
        grid.addRow(3, lblgkb, txtgkb);
        grid.addRow(4, lblruangan, txtruangan);
        grid.addRow(5, lblnama_dosen, txtnama_dosen);
        grid.setGridLinesVisible(false);


        pane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), Insets.EMPTY)));
        pane.getChildren().addAll(grid, panehbox);

        panevbox.getChildren().addAll(lblTitle, tblView, searchbox);
        panevbox.setPadding(new Insets(5));
        panevbox.setSpacing(5);

        panevbox2.getChildren().addAll(lblData, pane);
        panevbox2.setPadding(new Insets(5));
        panevbox2.setSpacing(5);

        splitPaneH.setOrientation(Orientation.VERTICAL);
        splitPaneH.getItems().addAll(panevbox2,panevbox);
        splitPaneH.setPadding(new Insets(2));
        splitPaneH.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        splitPaneH.setDividerPositions(1);

    }

    /**
     * =======================================================================================
     * UNTUK MENAMPUNG DATA DARI DATABASE
     * =======================================================================================
     *
     * @return
     **/
    private ObservableList loadData ( ) {
        ObservableList listData = FXCollections.observableArrayList();
        try {
            Connection c = database.tryConnect();
            String sql1 = "select * from jadwal_kuliah;";
            ResultSet rs1 = c.createStatement().executeQuery(sql1);
            while (rs1.next()) {
                modelDb = new model(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jadwal_kuliah_main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;

    }

    private ObservableList searchBymatkul (String n) {
        ObservableList listData = FXCollections.observableArrayList();
        try {
            Connection c = database.tryConnect();
            String sql2 = " select * from jadwal_kuliah where matkul like '%" + n + "%';";
            ResultSet rs2 = c.createStatement().executeQuery(sql2);
            while (rs2.next()) {
                modelDb = new model(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jadwal_kuliah_main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
    //=======================================================================================

    /**
     * ======================================================================================
     * UNTUK MELAKUKAN INSERT, DELETE DAN UPDATE
     * DIMANA DATA DIAMBIL DARI FORM KEMUDIAN DIKUMPULKAN DI MODEL
     * ======================================================================================
     **/

    private void insert (model m) {
        Connection c = database.tryConnect();
        PreparedStatement ps;
        try {
            String sql = "insert into jadwal_kuliah values (?,?,?,?,?,?);";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getid_jadwal_kuliah());
            ps.setString(2, m.getmatkul());
            ps.setString(3, m.getwaktu());
            ps.setString(4, m.getgkb());
            ps.setString(5, m.getruangan());
            ps.setString(6, m.getnama_dosen());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(jadwal_kuliah_main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }

    private void delete (model m) {
        try {
            Connection c = database.tryConnect();
            PreparedStatement ps;
            String sql = "delete from jadwal_kuliah where id_jadwal_kuliah = ?;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getid_jadwal_kuliah());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(jadwal_kuliah_main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void update (model m) {
        try {
            Connection c = database.tryConnect();
            PreparedStatement ps;
            String sql = "update jadwal_kuliah set matkul = ? , waktu = ? , gkb = ? , ruangan = ? , nama_dosen = ? where id_jadwal_kuliah = ? ;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getmatkul());
            ps.setString(2, m.getwaktu());
            ps.setString(3, m.getgkb());
            ps.setString(4, m.getruangan());
            ps.setString(5, m.getnama_dosen());
            ps.setString(6, m.getid_jadwal_kuliah());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(jadwal_kuliah_main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //=======================================================================================

    /**
     * ======================================================================================
     * ACTIONEVENT
     * ======================================================================================
     **/

    private void selectData ( ) {
        modelDb = (model) tblView.getSelectionModel().getSelectedItems().get(0);
        txtid_jadwal_kuliah.setText(modelDb.getid_jadwal_kuliah());
        txtmatkul.setText(modelDb.getmatkul());
        txtwaktu.setText(modelDb.getwaktu());
        txtgkb.setText(modelDb.getgkb());
        txtruangan.setText(modelDb.getruangan());
        txtnama_dosen.setText(modelDb.getnama_dosen());
        txtid_jadwal_kuliah.setDisable(true);
        btnAdd.setDisable(true);
    }

    private void deleteData ( ) {
        modelDb = new model(txtid_jadwal_kuliah.getText(), "", "", "", "", "");
        delete(modelDb);
        clearData();
        showData();
    }

    private void updateData ( ) {
        modelDb = new model(txtid_jadwal_kuliah.getText(), txtmatkul.getText(), txtwaktu.getText(), txtgkb.getText(), txtruangan.getText(), txtnama_dosen.getText());
        update(modelDb);
        clearData();
        showData();
    }

    private void searchbymatkul ( ) {
        data.clear(); // <- menghapus data pada penampung data
        data = searchBymatkul(txtCARI.getText().trim());
        tblView.setItems(data); // <- menaruh data pada tabel agar bisa tampil
        tblView.getSelectionModel().clearSelection(); // <- menghapus seleksi baris pada tabel
    }

    private void refresh ( ) {
        showData();
        clearData();
        txtCARI.clear();
    }

    private void showData ( ) {

        data = loadData();
        tblView.setItems(data);
        tblView.getSelectionModel().clearSelection();
    }

    private void clearData ( ) {
        txtid_jadwal_kuliah.clear();
        txtmatkul.clear();
        txtwaktu.clear();
        txtgkb.clear();
        txtruangan.clear();
        txtnama_dosen.clear();
        txtid_jadwal_kuliah.setDisable(false);
        btnAdd.setDisable(false);
        tblView.getSelectionModel().clearSelection();
    }

    private void addData ( ) {
        // mengambil data dari form, kemudian disusun seperti array
        modelDb = new model(txtid_jadwal_kuliah.getText(), txtmatkul.getText(), txtwaktu.getText(), txtgkb.getText(), txtruangan.getText(), txtnama_dosen.getText());
        insert(modelDb); //<- data dikirim ke SQL
        showData();
        clearData();
    }

    //====================================================================================
    @Override
    public void start (Stage primaryStage) {

        initComponent(); // <- VIEW
        showData();     // <- MENAMPILKAN DATA
        tblView.setOnMousePressed((MouseEvent event) -> {
            selectData(); // <- EVENT BARIS KETIKA DIPILIH
        });
        btnAdd.setOnAction((ActionEvent e) -> {
            addData(); // <- INSERT DATA
        });
        btnClear.setOnAction((ActionEvent e) -> {
            clearData(); // <- CLEAR FIELD INPUT DATA
        });
        btnClose.setOnAction((ActionEvent e) -> {
            primaryStage.close(); // <- CLOSE SCENE WINDOW
        });
        btnUpdate.setOnAction((ActionEvent e) -> {
            updateData(); // <- UPDATE DATA
        });
        btnDelete.setOnAction((ActionEvent e) -> {
            deleteData(); // <- DELETE DATA
        });
        btnRefresh.setOnAction((ActionEvent e) -> {
            refresh(); // <- MENGEMBALIKAN TAMPILAN SEPERTI SEMULA
        });
        txtCARI.setOnKeyTyped((KeyEvent ke) -> {
            searchbymatkul(); // <- SEARCH DATA BY Mata Kuliah
        });

        Scene scene = new Scene(splitPaneH, 1280, 600);

        primaryStage.setTitle("APLIKASI JADWAL KULIAH");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {

        launch(args);
    }

}
