package com.example.savedatainfile

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var edata:EditText
    private lateinit var efile:EditText
    private lateinit var bsubmit:Button
    private lateinit var pro:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edata = findViewById(R.id.edtdata)
        efile = findViewById(R.id.edtfile)
        bsubmit = findViewById(R.id.submitButton)
        pro = findViewById(R.id.progressBar)

        bsubmit.setOnClickListener {
            pro.visibility = View.VISIBLE
            var file = efile.text.toString()
            var data = edata.text.toString()
            savedatatofile(this,file,data)

        }

    }

    private fun savedatatofile( context:Context, fileName:String, data:String) {
        try {
            val fileOutputStream:FileOutputStream = context.openFileOutput(fileName,Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
            fileOutputStream.close()
        }catch (e: IOException){
            e.printStackTrace()
        }
        pro.visibility = View.GONE



    }
}