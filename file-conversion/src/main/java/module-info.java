module xyz.zuner.fileconversion {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.fileconversion to javafx.fxml;
    exports xyz.zuner.fileconversion;
}