module xyz.zuner.ui {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.ui to javafx.fxml;
    exports xyz.zuner.ui;
}