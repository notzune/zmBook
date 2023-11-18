module xyz.zuner.scriptexecutor {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.scriptexecutor to javafx.fxml;
    exports xyz.zuner.scriptexecutor;
}