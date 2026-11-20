package com.traxx.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {
    private val bg = Color.rgb(8, 13, 25)
    private val panel = Color.rgb(17, 27, 47)
    private val blue = Color.rgb(35, 130, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun base() = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(22, 28, 22, 24)
        setBackgroundColor(bg)
    }

    private fun label(text: String, size: Float, color: Int = Color.WHITE) =
        TextView(this).apply {
            this.text = text
            textSize = size
            setTextColor(color)
            gravity = Gravity.CENTER
            setPadding(8, 12, 8, 12)
        }

    private fun button(text: String, action: () -> Unit) = Button(this).apply {
        this.text = text
        setTextColor(Color.WHITE)
        setBackgroundColor(panel)
        isAllCaps = false
        setOnClickListener { action() }
    }

    private fun showHome() {
        val root = base()
        root.addView(label("TRAXX", 34f, blue))
        root.addView(label("PAINEL DE APOIO", 13f, Color.LTGRAY))
        root.addView(label("Ferramentas de organização para sua experiência no Oxide.", 16f))
        root.addView(button("MAPA E ANOTAÇÕES") { showNotes("Mapa e anotações", "Registre locais importantes, rotas e observações manualmente.") })
        root.addView(button("GUIA DE CONSTRUÇÃO") { showNotes("Guia de construção", "Planeje materiais, etapas e ideias para suas construções.") })
        root.addView(button("INVENTÁRIO") { showNotes("Inventário", "Anote itens, quantidades e recursos que deseja acompanhar.") })
        root.addView(button("GUIA DE MOVIMENTAÇÃO") { showNotes("Guia de movimentação", "Consulte suas próprias dicas e estratégias legítimas de movimentação.") })
        root.addView(button("SEGURANÇA E INTEGRIDADE") { showNotes("Segurança", "O TRAXX é um aplicativo companheiro. Não altera o jogo, não injeta código e não contorna sistemas antitrapaça.") })
        root.addView(label("TRAXX • Versão 1.0", 12f, Color.GRAY))
        setContentView(ScrollView(this).apply { addView(root) })
    }

    private fun showNotes(title: String, hintText: String) {
        val root = base()
        root.addView(label("TRAXX", 28f, blue))
        root.addView(label(title, 22f))
        root.addView(label(hintText, 14f, Color.LTGRAY))
        val input = EditText(this).apply {
            setTextColor(Color.WHITE)
            setHintTextColor(Color.GRAY)
            hint = "Escreva suas anotações aqui"
            minLines = 5
            gravity = Gravity.TOP
            setPadding(12, 12, 12, 12)
            setBackgroundColor(panel)
        }
        root.addView(input)
        root.addView(button("VOLTAR") { showHome() })
        setContentView(ScrollView(this).apply { addView(root) })
    }
}
