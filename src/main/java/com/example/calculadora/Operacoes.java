package com.example.calculadora;

public class Operacoes {

    public String oprc(String num, String auxnum){

        String[] aux = num.split(" ");
        return Contas_Operacoes(aux[1], aux, auxnum);

    }

    public String Contas_Operacoes(String c, String[] ArrStr, String auxnum){

        String strNum;
        int num1 = Integer.parseInt(ArrStr[0]);
        int num2 = Integer.parseInt(auxnum);
        int NUM;
        boolean error_control = false;

        switch(c){
            case "+":
                NUM = num1 + num2;
                break;
            case "-":
                NUM = num1 - num2;
                break;
            case "*":
                NUM = num1 * num2;
                break;
            case "÷":
                if(num2 == 0){
                    NUM = 0;
                    error_control = true;
                } else{
                    NUM = num1 / num2;
                }
                break;
            case "^":
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

        return String.valueOf(strNum);

    }

}
