package br.com.etec.aula20240609;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private CheckBox chkCasado;

    @FXML
    private ToggleGroup grpSexo;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private TextArea txtAreaDados;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFone;

    @FXML
    private TextField txtNome;
    private Cliente cliente;
    private List<Cliente> listaClientes = new ArrayList<>();



    @FXML
    protected void onClickCadastrar() {

        if (txtNome.getText().equals("")){
            avisoBranco("Nome em Branco");
            txtNome.requestFocus();
            return;
        }

        if (txtFone.getText().equals("")){
            avisoBranco("Telefone em Branco");
            txtFone.requestFocus();
            return;
        }

        if (txtEmail.getText().equals("")){
            avisoBranco("Email em Branco");
            txtEmail.requestFocus();
            return;
        }



        String sexo = rbMasculino.isSelected()? "Masculino" : "Feminino";
        int id = listaClientes.size() + 1;
        cliente = new Cliente(id, txtNome.getText(), txtEmail.getText(), txtFone.getText(), sexo, chkCasado.isSelected());

        listaClientes.add(cliente);
        txtAreaDados.setText((listaClientes.toString()));
        limparCampos();
    }

    private void limparCampos(){
        txtNome.setText("");
        txtFone.setText("");
        txtEmail.setText("");
        rbMasculino.setSelected(false);
        rbFeminino.setSelected(false);
        chkCasado.requestFocus();
    }
    private void avisoBranco(String msg) {
        Alert alertaErro = new Alert(Alert.AlertType.ERROR);
        alertaErro.setTitle("Erro");
        alertaErro.setHeaderText("Campo em Branco");
        alertaErro.setContentText(msg);
        alertaErro.show();
    }
}