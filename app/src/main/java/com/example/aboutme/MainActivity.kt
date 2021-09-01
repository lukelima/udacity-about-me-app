package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var doneButton: Button
    lateinit var nicknameEditText: EditText
    lateinit var nicknameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doneButton = findViewById(R.id.done_button)
        nicknameEditText = findViewById(R.id.nickname_edit)
        nicknameTextView = findViewById(R.id.nickname_text)
        doneButton.setOnClickListener { addNickName(it) }
    }

    private fun addNickName(view: View) {
        nicknameTextView.text = nicknameEditText.text
        changeVisibilities()
        hideKeyboard(view)
    }

    private fun changeVisibilities() {
        doneButton.visibility = View.GONE
        nicknameEditText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}