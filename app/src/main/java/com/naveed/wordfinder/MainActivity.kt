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
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                onTextChanged(p0)
                return true
            }
        })
    }

    private fun onTextChanged(str: String?) {
        val textToProcess = tv_result.text.toString()
        val toSearch = if (str.isNullOrEmpty()) "" else str
        val highlighter = "<span style='background-color:yellow;'>$toSearch</span>"
        val resultText = if (!str.isNullOrEmpty()) {
            textToProcess.replace(toSearch, highlighter, false)
        } else {
            textToProcess.replace(highlighter, "", false)
        }
        tv_result.text = HtmlCompat.fromHtml(resultText, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}