module xyz.zuner.markdownprocessor {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.markdownprocessor to javafx.fxml;
    exports xyz.zuner.markdownprocessor;
}