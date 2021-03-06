package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Lucas Silva")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener { addNickName(it) }
    }

    private fun addNickName(view: View) {
        myName?.nickname = binding.nicknameEdit.text.toString()
        changeVisibilities()
        hideKeyboard(view)
    }

    private fun changeVisibilities() {
        binding.apply {
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            binding.doneButton.visibility = View.GONE
            binding.nicknameEdit.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}