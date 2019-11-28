package com.example.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String operador = "", datos = "", datoAnterior = "", dato1 = "", dato2 = "", operador2 = "", result = "", resultadoFinal = "",  memoria = "";

    int estado = 1;
    //Declaracion del TextView que mostrara los resultados
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.textResultado);

        if (savedInstanceState != null) {
            dato1 = savedInstanceState.getString("memoria");
            operador2 = savedInstanceState.getString("operador");
            dato2 = savedInstanceState.getString("mostrar");
            resultadoFinal = savedInstanceState.getString("resultado");
            resultado.setText(savedInstanceState.getString("ultimo"));
            memoria = savedInstanceState.getString("resultadoGuardado");

        }
    }

    //Definicion de los numeros
    //Numero 9
    public void onNine(View view) {
        datos = resultado.getText().toString();
        datos = datos + "9";
        resultado.setText(datos);
    }

    //Numero 8
    public void onEight(View view) {
        datos = resultado.getText().toString();
        datos = datos + "8";
        resultado.setText(datos);
    }

    //Numero 7
    public void onSeven(View view) {
        datos = resultado.getText().toString();
        datos = datos + "7";
        resultado.setText(datos);
    }

    //Numero 6
    public void onSix(View view) {
        datos = resultado.getText().toString();
        datos = datos + "6";
        resultado.setText(datos);
    }

    //Numero 5
    public void onFive(View view) {
        datos = resultado.getText().toString();
        datos = datos + "5";
        resultado.setText(datos);
    }

    //Numero 4
    public void onFour(View view) {
        datos = resultado.getText().toString();
        datos = datos + "4";
        resultado.setText(datos);
    }

    //Numero 3
    public void onThree(View view) {
        datos = resultado.getText().toString();
        datos = datos + "3";
        resultado.setText(datos);
    }

    //Numero 2
    public void onTwo(View view) {
        datos = resultado.getText().toString();
        datos = datos + "2";
        resultado.setText(datos);
    }

    //Numero 1
    public void onOne(View view) {
        datos = resultado.getText().toString();
        datos = datos + "1";
        resultado.setText(datos);
    }

    //Numero 0
    public void onZero(View view) {
        datos = resultado.getText().toString();
        datos = datos + "0";
        resultado.setText(datos);
    }

    //Definicion de los operadores
    //Suma
    public void onSum(View view) {
        estado = 1;
        datoAnterior = resultado.getText().toString();
        operador = "+";
        resultado.setText("");
    }

    //Resta
    public void onRest(View view) {
        estado = 1;
        datoAnterior = resultado.getText().toString();
        operador = "-";
        resultado.setText("");
    }

    //Multiplicacion
    public void onMult(View view) {
        estado = 1;
        datoAnterior = resultado.getText().toString();
        operador = "x";
        resultado.setText("");
    }

    //Division
    public void onDiv(View view) {
        estado = 1;
        datoAnterior = resultado.getText().toString();
        operador = "÷";
        resultado.setText("");
    }

    //Potencia
    public void onPow(View view) {
        estado = 1;
        datoAnterior = resultado.getText().toString();
        operador = "^";
        resultado.setText("");
    }

    //Raiz
    public void onRoot(View view) {
        estado = 1;
        datoAnterior = resultado.getText().toString();
        operador = "√";
        resultado.setText("");
    }

    //Definicion del caracter punto
    //Punto
    public void onPoint(View view) {
        datos = resultado.getText().toString();
        datos = datos + ".";
        resultado.setText(datos);
    }

    //Metodo de limpiar pantalla
    public void onReset(View view) {
        estado = 1;
        if(datoAnterior != "" && operador != "" && datos != "" && result != ""){
            dato1 = datoAnterior;
            dato2 = datos;
            operador2 = operador;
            resultadoFinal = result;
        }
        datos = "";
        datoAnterior = "";
        operador = "";
        result = "";
        resultado.setText("");
    }

    //Metodo cuando se presiona igual
    public void onEqual(View view){
        datos = resultado.getText().toString();
        if(datos == ""){
            resultado.setText("");
        }
        else if(datoAnterior != "" && operador !=""){
            onOperaciones();
        }else if(datoAnterior == "" && operador =="√"){
            onOperaciones();
        }
    }

    //Método para validar si el resultado de la operacion es decimal o entero
    public String validarResultado(String resultadoOperacion){
        String resultadoValidado;
        if(Double.parseDouble(resultadoOperacion) % 1 == 0){
           resultadoValidado = String.valueOf((int)Double.parseDouble(resultadoOperacion));
        }else{
            resultadoValidado = String.valueOf(resultadoOperacion);
        }

        return resultadoValidado;
    }

    //Metodo para calcular las operaciones
    public void onOperaciones() {
        dato1 = datoAnterior;
        dato2 = datos;
        operador2 = operador;
        datos = resultado.getText().toString();
        switch (operador) {
            case "+":
                result = String.valueOf(Double.parseDouble(datoAnterior) + Double.parseDouble(datos));
                resultado.setText(String.valueOf(validarResultado(result)));
                break;
            case "-":
                result =  String.valueOf(Double.parseDouble(datoAnterior) - Double.parseDouble(datos));
                resultado.setText(String.valueOf(validarResultado(result)));
                break;
            case "x":
                result = String.valueOf(Double.parseDouble(datoAnterior) * Double.parseDouble(datos));
                resultado.setText(String.valueOf(validarResultado(result)));
                break;
            case "÷":
                if (Double.parseDouble(datos) == 0) {
                    Toast.makeText(MainActivity.this, "No es posible dividir entre cero", Toast.LENGTH_SHORT).show();
                } else {
                    result = String.valueOf(Double.parseDouble(datoAnterior) / Double.parseDouble(datos));
                    resultado.setText(String.valueOf(validarResultado(result)));
                }
                break;
            case "^":
                result = String.valueOf(Math.pow(Double.parseDouble(datoAnterior), Double.parseDouble(datos)));
                resultado.setText(String.valueOf(validarResultado(result)));
                break;
            case "√":
                if (datoAnterior == "") {
                    result = String.valueOf(Math.sqrt(Double.parseDouble(datos)));

                } else {
                    result = String.valueOf(Double.parseDouble(datoAnterior) * Math.sqrt(Double.parseDouble(datos)));
                }
                resultado.setText(String.valueOf(validarResultado(result)));
                break;
        }
        estado = 2;
        resultadoFinal = result;

    }

    public void onMemory(View view){
        if (estado == 1){
            resultado.setText(validarResultado(memoria));
        }else if (estado == 2){
            memoria = result;
        }
    }

    //Metodo para que nos manda a la segunda vista con la ultima operacion realizada
    public void onMostra(View view) {
        if (dato1.equals("") || operador2.equals("") || dato2.equals("") || resultadoFinal.equals("")) {
            Toast.makeText(MainActivity.this, "No hay registros guardados", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("EXTRA_INFO", String.valueOf(dato1 + " " + operador2 + " " + dato2 + " = " + validarResultado(resultadoFinal)));
            startActivity(intent);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("ultimo", resultado.getText().toString());
        outState.putString("memoria", dato1);
        outState.putString("operador", operador2);
        outState.putString("mostrar", dato2);
        outState.putString("resultado", resultadoFinal);
        outState.putString("resultadoGuardado", memoria);

    }

}
