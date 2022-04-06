package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        //Acessando o spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //Acessando a caixa de idade
        val text_idade = findViewById<EditText>(R.id.txt_idade)

        //Acessando o botão de calcular
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //Acessando o texto de resultado
        val text_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("Masculino", "Feminino"))

        btn_calcular.setOnClickListener {
            // Aqui vai o código que será executado quando houver um click do botão

            //Capturando o sexo selecionado
            val sexo = spn_sexo.selectedItem as String

            //Capturando a idade digitada
            val idade = text_idade.text.toString().toInt()

            //Variável para guardar o resultado do cálculo
            var resultado = 0

            //Verificando o sexo da pessoa
            if (sexo == "Masculino"){
                resultado = 65 - idade
            }else {
                resultado = 60 - idade
            }

            //Atualizando a tela de acordo com resultado do cáculo
            text_resultado.text = "Faltam $resultado anos para você se aposentar."

        }
    }
}