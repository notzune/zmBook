module xyz.zuner.sync {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.sync to javafx.fxml;
    exports xyz.zuner.sync;
}