package com.example.mibihi.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view:View){
        if(isNewOp){editShowNumber.setText("")}
        isNewOp=false
        val enteredData = editShowNumber.text
        val buttonSelected = view as Button
        var buClickValue:String =editShowNumber.text.toString()
        when(buttonSelected.id)
        {
            bu0.id->{buClickValue+="0"}
            bu1.id->{buClickValue+="1"}
            bu2.id->{buClickValue+="2"}
            bu3.id->{buClickValue+="3"}
            bu4.id->{buClickValue+="4"}
            bu5.id->{buClickValue+="5"}
            bu6.id->{buClickValue+="6"}
            bu7.id->{buClickValue+="7"}
            bu8.id->{buClickValue+="8"}
            bu9.id->{buClickValue+="9"}
            buac.id->{buClickValue=""}
            buplusminus.id->{buClickValue="-"+buClickValue
            }
            bupercent.id->{buClickValue="percent"}
            bu0.id->{buClickValue+="0"}
            bu0.id->{buClickValue+="0"}
            bu0.id->{buClickValue+="0"}
            bu0.id->{buClickValue+="0"}
            bu0.id->{buClickValue+="0"}
            bu0.id->{buClickValue+="0"}
            budot.id->{buClickValue+="."
            //todo prevent entering more than one dot
                if(buClickValue.contains(".")){return}
            }
        }
            editShowNumber.setText(buClickValue)
        //Toast.makeText(this,"you selected ::"+buClickValue,Toast.LENGTH_SHORT).show()
    }
    var op = "*"
    var oldnumbers=""
    var isNewOp = true
    fun buOpEvent(view:View){

        val buttonSelected = view as Button

        when(buttonSelected.id)
        {
            budivide.id->{op="/"}
            butimes.id->{op="*"}
            buminus.id->{op="-"}
            buplus.id->{op="+"}
            buequal.id->{op="="}
        }
        oldnumbers= editShowNumber.text.toString()
        isNewOp=true
    }
    fun buEqualEvent(view:View){

        val newNumber = editShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{finalNumber=oldnumbers.toDouble() * newNumber.toDouble()}
            "/"->{finalNumber=oldnumbers.toDouble() / newNumber.toDouble()}
            "+"->{finalNumber=oldnumbers.toDouble() + newNumber.toDouble()}
            "-"->{finalNumber=oldnumbers.toDouble() - newNumber.toDouble()}

        }
        editShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }
}
