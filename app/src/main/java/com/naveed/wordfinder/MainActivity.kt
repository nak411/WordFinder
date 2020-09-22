package com.naveed.wordfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.SearchView
import androidx.core.text.HtmlCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return  true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                onTextChanged(p0)
                return true
            }

        })
    }

    private fun onTextChanged(str: String?) {
        Log.d("TAG",  "Search String: $str")
        val textToProcess = tv_result.text.toString()
        if (!str.isNullOrEmpty()) {
            val resultText = textToProcess.replace("$str", "<span style='background-color:yellow;'>$str</span>", false)
            tv_result.text = HtmlCompat.fromHtml(resultText, HtmlCompat.FROM_HTML_MODE_LEGACY)
        } else {
            val resultText = textToProcess.replace( "<span style='background-color:yellow;'></span>", "", false)
            tv_result.text = HtmlCompat.fromHtml(resultText, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}