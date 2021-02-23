package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalcular) {
            Calcular()
        }
    }

    private fun Calcular() {
        if (Validacao()) {
            try {
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAutonomia.text.toString().toFloat()
                val valor_total = (distancia * preco) / autonomia
                textValorTotal.text = "R$ ${"%.2f".format(valor_total)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(
                    this,
                    getString(R.string.notificacaoValoresValidos),
                    Toast.LENGTH_LONG
                ).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.notificacaoCampos), Toast.LENGTH_LONG).show()
        }
    }

    private fun Validacao(): Boolean {
        return (editDistancia.text.toString() != ""
                && editAutonomia.text.toString() != ""
                && editPreco.text.toString() != "")


    }
}