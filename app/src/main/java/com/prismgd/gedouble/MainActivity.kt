package com.prismgd.gedouble

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private val gamePackage = "com.robtopx.geometryjump"
    private lateinit var statusText: TextView
    private lateinit var launchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(15, 17, 28)
        window.navigationBarColor = Color.rgb(15, 17, 28)
        window.decorView.setBackgroundColor(Color.rgb(15, 17, 28))

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(dp(28), dp(32), dp(28), dp(32))
            setBackgroundColor(Color.rgb(15, 17, 28))
        }

        val brand = TextView(this).apply {
            text = "GEDOUBLE"
            textSize = 32f
            letterSpacing = 0.12f
            setTextColor(Color.WHITE)
            typeface = Typeface.create("sans-serif-black", Typeface.NORMAL)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Geometry Dash • Android"
            textSize = 14f
            setTextColor(Color.rgb(157, 166, 190))
            gravity = Gravity.CENTER
        }

        val panel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(dp(20), dp(22), dp(20), dp(22))
            setBackgroundColor(Color.rgb(28, 32, 49))
        }

        val gameTitle = TextView(this).apply {
            text = "GEOMETRY DASH"
            textSize = 18f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }

        statusText = TextView(this).apply {
            textSize = 14f
            setTextColor(Color.rgb(184, 192, 212))
            gravity = Gravity.CENTER
            setPadding(0, dp(12), 0, dp(18))
        }

        launchButton = Button(this).apply {
            text = "Verificar jogo"
            isAllCaps = false
            setOnClickListener { launchGameIfAvailable() }
        }

        val version = TextView(this).apply {
            text = "Gedouble 0.1.0-dev"
            textSize = 12f
            setTextColor(Color.rgb(112, 122, 148))
            gravity = Gravity.CENTER
        }

        root.addView(brand, matchWrap())
        root.addView(subtitle, matchWrap().apply { bottomMargin = dp(36) })
        panel.addView(gameTitle, matchWrap())
        panel.addView(statusText, matchWrap())
        panel.addView(launchButton, matchWrap())
        root.addView(panel, matchWrap())
        root.addView(version, matchWrap().apply {
            topMargin = dp(28)
        })

        setContentView(root)
        refreshGameStatus()
    }

    override fun onResume() {
        super.onResume()
        if (::statusText.isInitialized) refreshGameStatus()
    }

    private fun refreshGameStatus() {
        val installed = isGameInstalled()
        statusText.text = if (installed) {
            "Geometry Dash foi encontrado neste dispositivo."
        } else {
            "Geometry Dash não foi encontrado. Instale o jogo pela loja oficial."
        }
        launchButton.text = if (installed) "Abrir Geometry Dash" else "Verificar novamente"
    }

    private fun isGameInstalled(): Boolean = try {
        packageManager.getPackageInfo(gamePackage, 0)
        true
    } catch (_: Exception) {
        false
    }

    private fun launchGameIfAvailable() {
        val intent = packageManager.getLaunchIntentForPackage(gamePackage)
        if (intent == null) {
            Toast.makeText(
                this,
                "Geometry Dash não está instalado.",
                Toast.LENGTH_LONG
            ).show()
            refreshGameStatus()
            return
        }

        try {
            startActivity(intent)
        } catch (_: ActivityNotFoundException) {
            Toast.makeText(this, "Não foi possível abrir Geometry Dash.", Toast.LENGTH_LONG).show()
        }
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

    private fun matchWrap() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
}
