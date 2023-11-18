module xyz.zuner.linkmanagement {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.linkmanagement to javafx.fxml;
    exports xyz.zuner.linkmanagement;
}