package cristhian.lopez.examen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtnumber2 = findViewById<EditText>(R.id.number2)
        val resultado1 = findViewById<Button>(R.id.id_resultado)
        val refrescar = findViewById<Button>(R.id.id_refres)
        val textran1 = findViewById<TextView>(R.id.ran1)
        var resul: Long? = null
        var resultado: Long? = null

        refrescar.setOnClickListener {
            var num1 = (1..10).random()
            val num2 = (1..10).random()
            val signo = mutableListOf("-","+","*")
            val rango = signo.random()

            textran1.text = num1.toString() + "  " + rango.toString() + "  " + num2.toString()

            resultado1.setOnClickListener {
                val snack = Snackbar.make(it, "es obligatorio llenar el espacio", Snackbar.LENGTH_LONG).setAction("Action",null)
                if (txtnumber2.text.isNotEmpty()) {
                    resul = txtnumber2.text.toString().toLong()
                    if (rango == "+") {
                        resultado = num1.toLong() + num2.toLong()
                    }
                    if (rango == "-") {
                        resultado = num1.toLong() - num2.toLong()
                    }
                    if (rango == "*") {
                        resultado = num1.toLong() * num2.toLong()
                    }
                    if (resultado == resul) {
                        val snack2 = Snackbar.make(it, "CORRECTO", Snackbar.LENGTH_LONG)
                        snack2.setBackgroundTint(getColor(R.color.yellow))
                        snack2.show()
                    } else {
                        val snack3 = Snackbar.make(it, "INCORRECTO", Snackbar.LENGTH_LONG)
                        snack3.setBackgroundTint(getColor(R.color.salmon))
                        snack3.show()
                    }
                } else {
                    snack.setActionTextColor(getColor(R.color.teal_200))
                    snack.setBackgroundTint(getColor(R.color.rojo))
                    snack.show()
                }
            }
        }
    }
}