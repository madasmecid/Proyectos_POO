module cl.duoc.listatareas {
    requires javafx.controls;
    requires javafx.fxml;


    opens cl.duoc.listatareas to javafx.fxml;
    exports cl.duoc.listatareas;
}