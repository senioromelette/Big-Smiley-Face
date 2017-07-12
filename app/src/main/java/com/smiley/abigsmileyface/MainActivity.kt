package com.smiley.abigsmileyface

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var unicode = 0x1F603

    fun getEmojiByUnicode(unicode: Int): String = String(Character.toChars(unicode))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById(R.id.imageView) as ImageView
        image.setOnClickListener { Toast.makeText(this, getEmojiByUnicode(unicode), Toast.LENGTH_SHORT).show() }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.show_info -> {
                showInfoDialog()
                true
            }
            R.id.show_changelog -> {
                showChangelog()
                true
            }
            else -> false
        }
    }

    private fun showChangelog() {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.changelog_dialog, null)

        val builder = AlertDialog.Builder(this)
                .setTitle("Changelog")
                .setView(view)
                .setPositiveButton("Dismiss", {dialogInterface, _ -> dialogInterface.dismiss() })
                .create()
        builder.show()

    }

    private fun showInfoDialog() {
        AlertDialog.Builder(this)
                .setTitle("About Smiley!")
                .setMessage(R.string.about)
                .setPositiveButton(R.string.dismiss,  { dialog, _ -> dialog.dismiss() })
                .create()
                .show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
