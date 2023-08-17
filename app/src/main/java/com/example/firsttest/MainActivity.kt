package com.example.firsttest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.apache.commons.math3.complex.Complex
import kotlin.math.*


class MainActivity : AppCompatActivity() {
    var i = 1.0
    var a = 1.0
    var b =1.0
    var c =1.0
    var d =1.0
    var e =1.0
    var p = 1.0
    var q = 1.0
    var r = 1.0
    var s = 1.0
    var u = 1.0
    var zx = 1.0
    var True = false
    fun rounds(zx: Double): Double{
        var rv = zx * 10000
        rv = round(rv)
        rv = rv.toDouble()
        rv /= 10000
        return(rv)
    }
    fun negativeRoot(x: Double): Complex {
        return Complex(0.0, sqrt(abs(x)))
    }


    fun quadEq(a:Double, b:Double, c:Double): MutableList<Double>{
        var xs:MutableList<Double> =  mutableListOf(1.0, 2.0, 3.0)
        if(a == 0.0){
            println("\"A\" cannot be 0 in a quadratic equation. Please enter a new value not equal to 0")
        }else{
            var dt = (b.pow(2) - 4*a*c)
            var x1 = (-b+ sqrt(dt))/(2*a)
            var x2 = (-b- sqrt(dt))/(2*a)
            Log.d("Quadratic function", "$x1, $x2")
            if(dt<0){
                xs = mutableListOf(x1, x2)

            }else{
                rounds(x1)
                rounds(x2)
                xs = mutableListOf(x1, x2)
            }
        }
        return(xs)
    }
    fun cubicEq(a:Double, b:Double, c:Double, d:Double):MutableList<Double>{
        var xs:MutableList<Double> = mutableListOf(1.0, 2.0, 3.0)
        var f = ((3 * c / a) - ((b.pow(2)) / (a.pow(2)))) / 3
        Log.d("Cubic", "f = $f")
        var g = ((2 * (b.pow(3)) / (a.pow(3))) - ((9 * b * c) / (a.pow(2))) + (27 * d / a)) / 27
        Log.d("Cubic", "g = $g")
        var h = ((g.pow(2)) / 4) + ((f.pow(3)) / 27)
        if(abs(h)<0.0000001){
            h = 0.0
        }
        Log.d("Cubic", "h = $h")

        if(h>0){
            var i = (((g.pow(2)) / 4) - h).pow(0.5)
            Log.d("Cubic", "I = $i")
            var r = -(g / 2) + (h).pow(0.5)
            Log.d("Cubic", "R = $r")
            if(r>0){
                s = -((-r).pow((1.0/3.0)))

            }else{
                s = r.pow((1.0/3.0))
            }
            Log.d("Cubic", " s = $s" )
            var t =  -(g / 2) - (h).pow(0.5)
            Log.d("Cubic", "t = $t")
            if(t>0){
                u = -((-t).pow((1.0/3.0)))
            }else{
                u = t.pow((1.0/3.0))
            }

            var x1 = (s + u) - (b / (3 * a))
            x1 = rounds(x1)
            var x2 = -(s + u)/2 - (b / (3 * a)) + ((s - u) * (3.0.pow(0.5)) / 2)*(sqrt(-1.0))
            var x3 = -(s + u)/2 - (b / (3 * a)) - ((s - u) * (3.0.pow(0.5)) / 2)*(sqrt(-1.0))
            xs = mutableListOf(x1, x2, x3)
        }else if(f==0.0 && g==0.0 && h==0.0){
            var x1 = ((d/a).pow((1.0 / 3.0)))*(-1)
            var x2 = ((d/a).pow((1.0 / 3.0)))*(-1)
            var x3 = ((d/a).pow((1.0 / 3.0)))*(-1)
            xs = mutableListOf(x1, x2, x3)

        }else if( h<=0){

            var i = (((g*g)/4) - h).pow(0.5)
            var j = i.pow(1.0/3.0)
            var k = acos((-(g / (2 * i))))
            Log.d("CUBIC", "k = $k")
            var l = j*(-1)
            Log.d("CUBIC", "l = $l")
            var m = cos(k/3)
            Log.d("CUBIC", "m = $m")
            var n = sqrt(3.0)* sin(k/3)
            Log.d("CUBIC", "n = $n")
            var p = (b / (3 * a)) * (-1)
            Log.d("CUBIC", "p = $p")
            var x1 = (2*j)*cos(k/3)-(b/(3*a))
            var x2 = l * (m + n) + p
            var x3 = l * (m - n) + p
            if(abs(x3)<0.00000000001){
                x3 = 0.0
            }
            if(abs(x2) < 0.00000001){
                x2 = 0.0
            }
            if(abs(x1) < 0.0000001){
                x1 = 0.0
            }
            xs = mutableListOf(x1, x2, x3)
        }
        return xs
    }
    fun quartEq(aa:Double, bb:Double, cc:Double, dd:Double, ee:Double):List<Double>{
        if(a==0.0){
            while(a==0.0){
                println("\"A\" cannot be 0 in a quartic equation. Please enter another value that isn't 0")
            }
        }
        b = bb/aa
        c = cc/aa
        d = dd/aa
        e = ee/aa
        a = aa/aa

        var f = c-((3 * b.pow(2))/8)
        var g = d+(b.pow(3)/8)-((b*c)/2)
        var h = e-((3*b.pow(4)/256))
        var i = f/2
        var j = ((f.pow(2)-4*h)/16)
        var k = -(g.pow(2)/64)
        var Xs = cubicEq(1.0, i, j, k)
        var y1:Double = Xs[0]
        var y2:Double = Xs[1]
        var y3:Double = Xs[2]
        if(y1!=0.0 && y2!=0.0){
            p = sqrt(y1)
            q = sqrt(y2)
            r = -g / (8 * p * q)
            s = b / (4 * a)
            True = true
        }else if(y1!=0.0 && y3!=0.0){
            p = sqrt(y1)
            q = sqrt(y3)
            r = -g / (8 * p * q)
            s = b / (4 * a)
            True = true
        }else if(y2!=0.0 && y3!=0.0){
            p = sqrt(y2)
            q = sqrt(y3)
            r = -g / (8 * p * q)
            s = b / (4 * a)
            True = true
        }
        var xs : List<Double> = listOf()
        if(True){
            var x1 = p + q + r - s
            var x2 = p - q - r - s
            var x3 = -p + q - r - s
            var x4 = -p - q + r - s
            xs = listOf(x1, x2, x3, x4)
        }
        return(xs)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.degreeSpinner)
        val degrees = listOf<String>("Second degree (x^2)", "Third degree (x^3)", "Fourth degree (x^4)")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, degrees)
        val viewOption1 = findViewById<TextView>(R.id.textViewOption1)
        val viewOption2 = findViewById<TextView>(R.id.textViewOption2)
        val viewOption3 = findViewById<TextView>(R.id.textViewOption3)
        val inputText1 = findViewById<EditText>(R.id.inputEditText)
        val inputText2 = findViewById<EditText>(R.id.inputEditText2)
        val inputText3 = findViewById<EditText>(R.id.inputEditText3)
        val inputText4 = findViewById<EditText>(R.id.inputEditText4)
        val inputText5 = findViewById<EditText>(R.id.inputEditText5)
        val inputText6 = findViewById<EditText>(R.id.inputEditText6)
        val inputText7 = findViewById<EditText>(R.id.inputEditText7)
        val inputText8 = findViewById<EditText>(R.id.inputEditText8)
        val inputText9 = findViewById<EditText>(R.id.inputEditText9)
        val inputText10 = findViewById<EditText>(R.id.inputEditText10)
        val inputText11 = findViewById<EditText>(R.id.inputEditText11)
        val inputText12 = findViewById<EditText>(R.id.inputEditText12)
        fun changeView(selectedItem: String){
            when(selectedItem) {
                "Second degree (x^2)" -> {
                    viewOption1.visibility = View.VISIBLE
                    viewOption2.visibility = View.GONE
                    viewOption3.visibility = View.GONE
                    inputText1.visibility = View.VISIBLE
                    inputText2.visibility = View.VISIBLE
                    inputText3.visibility = View.VISIBLE
                    inputText4.visibility = View.GONE
                    inputText5.visibility = View.GONE
                    inputText6.visibility = View.GONE
                    inputText7.visibility = View.GONE
                    inputText8.visibility = View.GONE
                    inputText9.visibility = View.GONE
                    inputText10.visibility = View.GONE
                    inputText11.visibility = View.GONE
                    inputText12.visibility = View.GONE

                }
                "Third degree (x^3)" -> {
                    viewOption1.visibility = View.GONE
                    viewOption2.visibility = View.VISIBLE
                    viewOption3.visibility = View.GONE
                    inputText1.visibility = View.GONE
                    inputText2.visibility = View.GONE
                    inputText3.visibility = View.GONE
                    inputText4.visibility = View.VISIBLE
                    inputText5.visibility = View.VISIBLE
                    inputText6.visibility = View.VISIBLE
                    inputText7.visibility = View.VISIBLE
                    inputText8.visibility = View.GONE
                    inputText9.visibility = View.GONE
                    inputText10.visibility = View.GONE
                    inputText11.visibility = View.GONE
                    inputText12.visibility = View.GONE

                }
                "Fourth degree (x^4)" -> {
                    viewOption1.visibility = View.GONE
                    viewOption2.visibility = View.GONE
                    viewOption3.visibility = View.VISIBLE
                    inputText1.visibility = View.GONE
                    inputText2.visibility = View.GONE
                    inputText3.visibility = View.GONE
                    inputText4.visibility = View.GONE
                    inputText5.visibility = View.GONE
                    inputText6.visibility = View.GONE
                    inputText7.visibility = View.GONE
                    inputText8.visibility = View.VISIBLE
                    inputText9.visibility = View.VISIBLE
                    inputText10.visibility = View.VISIBLE
                    inputText11.visibility = View.VISIBLE
                    inputText12.visibility = View.VISIBLE
                }



            }

        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter= adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position) as String
                changeView(selectedItem)
                val goButton = findViewById<Button>(R.id.goButton)
                goButton.setOnClickListener{
                    when(selectedItem) {

                        "Second degree (x^2)"-> {
                            val input1 = inputText1.text.toString()
                            val input2 = inputText2.text.toString()
                            val input3 = inputText3.text.toString()
                            try{
                                val i1 = input1.toDouble()
                                val i2 = input2.toDouble()
                                val i3 = input3.toDouble()
                                val xs = quadEq(i1, i2, i3)
                                val x1 = xs[0]
                                val x2 = xs[1]
                                Log.d("idk", "$xs")
                                Toast.makeText(this@MainActivity, "The answers to this equation are $x1 and $x2", Toast.LENGTH_LONG).show()
                            }catch(e: NumberFormatException){
                                Toast.makeText(this@MainActivity, "Please make sure that all the values are numbers", android.widget.Toast.LENGTH_LONG).show()
                            }


                        }
                        "Third degree (x^3)" ->{
                            val input1 =inputText4.text.toString()
                            val input2 = inputText5.text.toString()
                            val input3 = inputText6.text.toString()
                            val input4 = inputText7.text.toString()
                            try{
                                val i1 = input1.toDouble()
                                val i2 = input2.toDouble()
                                val i3 = input3.toDouble()
                                val i4 = input4.toDouble()
                                Log.d("VALUES", "$i1, $i2, $i3, $i4")
                                val xs = cubicEq(i1, i2, i3, i4)
                                val x1 = xs[0]
                                val x2 = xs[1]
                                val x3 = xs[2]
                                Log.d("CUBIC", "$xs")
                                Toast.makeText(this@MainActivity, "The answers to this equation are $x1 , $x2 and $x3", Toast.LENGTH_LONG).show()
                            }catch(e: NumberFormatException){
                                Toast.makeText(this@MainActivity, "Please make sure that all the values are numbers", android.widget.Toast.LENGTH_LONG).show()
                            }

                        }
                        "Fourth degree (x^4)" -> {
                            val input1 =inputText8.text.toString()
                            val input2 = inputText9.text.toString()
                            val input3 = inputText10.text.toString()
                            val input4 = inputText11.text.toString()
                            val input5 = inputText12.text.toString()
                            try{
                                val i1 = input1.toDouble()
                                val i2 = input2.toDouble()
                                val i3 = input3.toDouble()
                                val i4 = input4.toDouble()
                                val i5 = input5.toDouble()

                                val xs = quartEq(i1, i2, i3, i4, i5)
                                val x1 = xs[0]
                                val x2 = xs[1]
                                val x3 = xs[2]
                                val x4 = xs[3]
                                Toast.makeText(this@MainActivity, "The answers to this equation are $x1 , $x2, $x3 and $x4", Toast.LENGTH_LONG).show()
                            }catch(e: NumberFormatException){
                                Toast.makeText(this@MainActivity, "Please make sure that all the values are numbers", android.widget.Toast.LENGTH_LONG).show()
                            }

                        }
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

    }
}