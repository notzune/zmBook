module xyz.zuner.database {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.database to javafx.fxml;
    exports xyz.zuner.database;
}