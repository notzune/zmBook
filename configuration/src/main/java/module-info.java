module xyz.zuner.configuration {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.configuration to javafx.fxml;
    exports xyz.zuner.configuration;
}