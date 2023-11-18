module xyz.zuner.contentrenderer {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.contentrenderer to javafx.fxml;
    exports xyz.zuner.contentrenderer;
}