module xyz.zuner.filemanagement {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.filemanagement to javafx.fxml;
    exports xyz.zuner.filemanagement;
}