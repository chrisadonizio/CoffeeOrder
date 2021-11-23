package com.adonizio.honorsmobileapps.coffeeorder

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

var quantity = 0
lateinit var quantity_text: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        quantity_text = findViewById(R.id.counter)
        val minusButton: Button = findViewById(R.id.button_minus)
        minusButton.setOnClickListener { view ->
            updateQuantity(-1)
        }
        val plusButton: Button = findViewById(R.id.button_plus)
        plusButton.setOnClickListener { view ->
            updateQuantity(1)
        }
        val submit: Button = findViewById(R.id.submit)
        submit.setOnClickListener { view ->
            submitOrder()
        }
    }

    fun updateQuantity(amount: Int) {
        if (quantity + amount < 1) {
            Toast.makeText(this, "Chill!!!You can't buy less than 1", Toast.LENGTH_LONG).show()
        } else if (quantity + amount > 10) {
            Toast.makeText(this, "Slow the roll only 10", Toast.LENGTH_LONG).show()
        } else {
            quantity += amount
        }
        quantity_text.text = quantity.toString()

    }

    fun submitOrder() {
        val name: EditText = findViewById(R.id.Name)
        val summary: TextView = findViewById(R.id.summary)
        var message = "Thanks ${name.text}!\n$quantity coffees"
        var total = quantity*5
        val whippedCream: CheckBox = findViewById(R.id.checkBox)
        val chocolate: CheckBox = findViewById(R.id.checkBox2)
        if (whippedCream.isChecked()) {
            message += "\n + Whipped Cream"
            total += quantity
        }
        if (chocolate.isChecked) {
            message += "\n + Chocolate"
            total += (quantity * 2)
        }
        summary.text = message +"\n Total: $${total}.00"
    }

}
