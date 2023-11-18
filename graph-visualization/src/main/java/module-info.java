module xyz.zuner.graphvisualization {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.graphvisualization to javafx.fxml;
    exports xyz.zuner.graphvisualization;
}