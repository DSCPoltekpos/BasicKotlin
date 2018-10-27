package com.sumadireja.workshopkotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Gravity
import com.sumadireja.workshopkotlin.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {

                imageView(R.drawable.android).lparams(width = 100, height = 100) {
                    padding = dip(20)
                    margin = dip(15)
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                val name = editText {
                    hint = "Siapa nama kamu?"
                }

                button("Click here") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE


                    onClick { toast("Hello, ${name.text}!") }

                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Progress Bar") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        indeterminateProgressDialog("Hello, ${name.text}! Please wait...").show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Second Activity") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
            }
        }
    }
}
