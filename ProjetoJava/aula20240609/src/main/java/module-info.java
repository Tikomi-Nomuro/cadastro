module br.com.etec.aula20240609 {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.etec.aula20240609 to javafx.fxml;
    exports br.com.etec.aula20240609;
}