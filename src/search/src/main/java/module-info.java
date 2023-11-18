module xyz.zuner.search {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens xyz.zuner.search to javafx.fxml;
    exports xyz.zuner.search;
}