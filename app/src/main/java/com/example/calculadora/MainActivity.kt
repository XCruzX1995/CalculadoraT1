package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnDivision: Button
    private lateinit var btnMultiplicacion: Button
    private lateinit var textRespuesta: TextView
    private lateinit var editNumeroUno: EditText
    private lateinit var editNumeroDos: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textRespuesta = findViewById(R.id.respuesta)
        editNumeroUno = findViewById(R.id.numero1)
        editNumeroDos = findViewById(R.id.numero2)
        btnSuma = findViewById(R.id.button_suma)
        btnResta = findViewById(R.id.button_resta)
        btnMultiplicacion = findViewById(R.id.button_multiplicacion)
        btnDivision = findViewById(R.id.button_division)

        btnSuma.setOnClickListener(View.OnClickListener {
            val num1 = editNumeroUno.text.toString().toIntOrNull()
            val num2 = editNumeroDos.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = suma(num1, num2)
                textRespuesta.text = result.toString()
            } else {
                showError()
            }
        })

        btnResta.setOnClickListener(View.OnClickListener {
            val num1 = editNumeroUno.text.toString().toIntOrNull()
            val num2 = editNumeroDos.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = resta(num1, num2)
                textRespuesta.text = result.toString()
            } else {
                showError()
            }
        })

        btnMultiplicacion.setOnClickListener(View.OnClickListener {
            val num1 = editNumeroUno.text.toString().toIntOrNull()
            val num2 = editNumeroDos.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = multiplicacion(num1, num2)
                textRespuesta.text = result.toString()
            } else {
                showError()
            }
        })

        btnDivision.setOnClickListener(View.OnClickListener {
            val num1 = editNumeroUno.text.toString().toIntOrNull()
            val num2 = editNumeroDos.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                if (num2 != 0) {
                    val result = division(num1, num2)
                    textRespuesta.text = result.toString()
                } else {
                    showDivisionError()
                }
            } else {
                showError()
            }
        })
    }

    private fun suma(a: Int, b: Int): Double {
        return (a + b).toDouble()
    }

    private fun resta(a: Int, b: Int): Double {
        return (a - b).toDouble()
    }

    private fun multiplicacion(a: Int, b: Int): Double {
        return (a * b).toDouble()
    }

    private fun division(a: Int, b: Int): Double {
        return a.toDouble() / b.toDouble()
    }

    private fun showError() {
        Toast.makeText(this, "Ingrese dos números válidos", Toast.LENGTH_SHORT).show()
    }

    private fun showDivisionError() {
        Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
    }
}

