module com.example.pruebaut02_ritikpunjabithadani {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.pruebaut02_ritikpunjabithadani to javafx.fxml,java.sql,mysql.connector.j,javafx.controls;
    exports com.example.pruebaut02_ritikpunjabithadani;
}