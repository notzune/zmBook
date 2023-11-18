module xyz.zuner.security {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.security to javafx.fxml;
    exports xyz.zuner.security;
}