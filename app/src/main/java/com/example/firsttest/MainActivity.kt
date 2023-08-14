package com.example.firsttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.*
import kotlin.math.pow
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val goButton = findViewById<Button>(R.id.goButton)
        goButton.setOnClickListener{
            Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT).show()
        }

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
        fun quadEq(a:Double, b:Double, c:Double){
            if(a == 0.0){
                println("\"A\" cannot be 0 in a quadratic equation. Please enter a new value not equal to 0")
            }else{
                var dt = (b.pow(2) - 4*a*c)
                var x1 = (-b+ sqrt(dt))/(2*a)
                var x2 = (-b- sqrt(dt))/(2*a)
                if(dt<0){
                    "There are no real roots to this equation. Here are the imaginary roots"
                    println("x1= $x1")
                    println("x2 = $x2")
                }else{
                    rounds(x1)
                    rounds(x2)
                    println("x1= $x1")
                    println("x2 = $x2")
                }
            }
        }
        fun cubicEq(a:Double, b:Double, c:Double, d:Double):MutableList<Double>{
            var xs:MutableList<Double> = mutableListOf(1.0, 2.0, 3.0)
            if(a==0.0){
                while(a==0.0){
                    println("In a cubic equation, \"A\" cannot be equal to 0. Please input another value not equal to 0")
                }
            }
            var f = ((3 * c / a) - ((b.pow(2)) / (a.pow(2)))) / 3
            var g = ((2 * (b.pow(3)) / (a.pow(3))) - ((9 * b * c) / (a.pow(2))) + (27 * d / a)) / 27
            var h = ((g.pow(2)) / 4) + ((f.pow(3)) / 27)
            if(h>0){
                var i = (((g.pow(2)) / 4) - h).pow(1 / 2)
                var r = -(g / 2) + (h).pow(1 / 2)
                if(r>0){
                    s = -((-r).pow(1/3))

                }else{
                    s = r.pow(1/3)
                }
                var t =  -(g / 2) - (h).pow(1/2)
                if(t>0){
                    u = -((-t).pow(1 / 3))
                }else{
                    u = t.pow(1/3)
                }
                var x1 = (s + u) - (b / (3 * a))
                x1 = rounds(x1)
                var x2 = -(s + u)/2 - (b / (3 * a)) + ((s - u) * (3.0.pow(0.5)) / 2)*(sqrt(-1.0))
                var x3 = -(s + u)/2 - (b / (3 * a)) - ((s - u) * (3.0.pow(0.5)) / 2)*(sqrt(-1.0))
                xs = mutableListOf(x1, x2, x3)
            }else if(f==0.0 && g==0.0 && h==0.0){
                var x1 = ((d/a).pow(1 / 3))*(-1)
                var x2 = ((d/a).pow(1 / 3))*(-1)
                var x3 = ((d/a).pow(1 / 3))*(-1)
                xs = mutableListOf(x1, x2, x3)

            }else if( h<=0){
                var i = (((g.pow(2))/4) - h).pow(1/2)
                var j = (i).pow(1/3)
                var k = acos((-(g / (2 * i))))
                var l = j*(-1)
                var m = cos(k/3)
                var n = sqrt(3.0)* sin(k/3)
                var p = (b / (3 * a)) * (-1)
                var x1 = (2*j)*cos(k/3)-(b/(3*a))
                var x2 = l * (m + n) + p
                var x3 = l * (m - n) + p
                xs = mutableListOf(x1, x2, x3)
            }
            return xs
        }
        fun quartEq(aa:Double, bb:Double, cc:Double, dd:Double, ee:Double){
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
            if(True){
                var x1 = p + q + r - s
                var x2 = p - q - r - s
                var x3 = -p + q - r - s
                var x4 = -p - q + r - s
                println("x1 = $x1")
                println("x2 = $x2")
                println("x3 = $x3")
                println("x4 = $x4")
            }
        }


    }
}