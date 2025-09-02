package com.example.calculadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML private Label lblAt;
    @FXML private Label lblBck;
    @FXML private Label lblRes;
    boolean reset_result = false;
    Operacoes operacoes = new Operacoes();


    /// /////
    @FXML
    private void btnAction(ActionEvent event) {

        if(reset_result) {
            lblRes.setText("");
            lblBck.setText("");
            lblAt.setText("");
            reset_result = false;
        }

        Button btn = (Button) event.getSource();
        String num = btn.getText();
        String numAt = lblAt.getText();
        String NUM = numAt + num;
        int intNum = Integer.parseInt(NUM);
        NUM = Integer.toString(intNum);
        lblAt.setText(NUM);
        LabelResultado();

    }


    private void LabelResultado(){

        if(!lblBck.getText().isEmpty() && !lblAt.getText().isEmpty()){

            String num = lblBck.getText();
            String auxnum = lblAt.getText();
            String strNum = operacoes.oprc(num, auxnum);
            lblRes.setText(strNum);

        }

    }


    @FXML
    private void btnDiv(ActionEvent event) {

        String strNum = Contas('/');
        lblBck.setText(strNum + " ÷");
        lblAt.setText("");
        reset_result = false;

    }

    @FXML
    private void btnMul(ActionEvent event) {

        String strNum = Contas('*');
        lblBck.setText(strNum + " *");
        lblAt.setText("");
        reset_result = false;

    }

    @FXML
    private void btnMin(ActionEvent event) {

        String strNum = Contas('-');
        lblBck.setText(strNum + " -");
        lblAt.setText("");
        reset_result = false;

    }

    @FXML
    private void btnSum(ActionEvent event) {

        String strNum = Contas('+');
        lblBck.setText(strNum + " +");
        lblAt.setText("");
        reset_result = false;

    }

    @FXML
    private void btnPow(ActionEvent event) {

        String strNum = Contas('^');
        lblBck.setText(strNum + " ^");
        lblAt.setText("");
        reset_result = false;

    }


    private String Contas(char x){

        String strNum;

        if(!lblBck.getText().isEmpty()){

            String num = lblBck.getText();
            String[] aux = num.split(" ");
            int num1 = Integer.parseInt(aux[0]);
            num = lblAt.getText();
            int num2 = Integer.parseInt(num);
            int NUM;
            boolean error_control = false;

            switch(x){
                case '+':
                    NUM = num1 + num2;
                    break;
                case '-':
                    NUM = num1 - num2;
                    break;
                case '*':
                    NUM = num1 * num2;
                    break;
                case '÷':
                    if(num2 == 0){
                        NUM = 0;
                        error_control = true;
                    } else{
                        NUM = num1 / num2;
                    }
                    break;
                case '^':
                    NUM = (int) Math.pow((double) num1, (double) num2);
                    break;
                default:
                    NUM = 0;
            }

            if(!error_control){
                strNum = String.valueOf(NUM);
            } else{

                strNum = "Error: Division by zero";

            }

        } else{

            strNum = lblAt.getText();

        }

        return strNum;

    }


    @FXML
    private void btnEq(ActionEvent event) {

        if(!lblBck.getText().isEmpty()){

            String strNum;
            String num = lblBck.getText();
            String auxnum = lblAt.getText();
            strNum = operacoes.oprc(num, auxnum);
            lblAt.setText(strNum);
            lblBck.setText("");
            lblRes.setText("");
            reset_result = true;

        }
    }


    @FXML
    private void btnC(ActionEvent event) {

        lblRes.setText("");
        lblBck.setText("");
        lblAt.setText("");
        reset_result = false;

    }

    @FXML
    private void btnCE(ActionEvent event) {
        lblAt.setText("");
        lblRes.setText("");
        reset_result = false;
    }

    @FXML
    private void btnApg(ActionEvent event) {
        if(!lblAt.getText().isEmpty()){

            StringBuilder str = new StringBuilder(lblAt.getText());
            str.delete(str.length() - 1, str.length());
            lblAt.setText(str.toString());
            reset_result = false;

        }
    }


}
