package com.example.simpleasynctask

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
     private var mTextView: TextView? = textView1
     private val textState = "currentText"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextView = findViewById(R.id.textView1)
        if (savedInstanceState != null) {
            mTextView!!.text = savedInstanceState.getString(textState)
        }
    }
    fun startTask(view: View) {

        mTextView!!.setText(R.string.napping)
        SimpleAsyncTask(mTextView).execute()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(textState,
            mTextView!!.text.toString());
    }
    }

