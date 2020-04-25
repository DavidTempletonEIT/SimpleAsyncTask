package com.example.simpleasynctask

import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference
import kotlin.random.Random


private var mTextView: WeakReference<TextView> = TODO()

class SimpleAsyncTask : AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg params: Void?): String {
        val r = Random
        val n: Int = r.nextInt(11)

        val s = n * 200
        try {
            Thread.sleep(s.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return "Awake at last after sleeping for $s milliseconds!";
    }

    fun SimpleAsyncTask(tv: TextView) {
        mTextView = WeakReference(tv)
    }
    override fun onPostExecute(result: String?) {
        mTextView.get()!!.text = result
    }

}