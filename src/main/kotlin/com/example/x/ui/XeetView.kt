package com.example.x.ui

import com.example.x.model.Xeet
import com.vaadin.flow.component.Text
import com.vaadin.flow.component.html.Div
import java.time.format.DateTimeFormatter

class XeetView(xeet: Xeet) : Div() {
    init {
        val mainDiv = Div().apply {
            style.set("display", "flex")
            style.set("flex-direction", "column")
            style.set("width", "100%")
            style.set("margin", "2px auto 0 auto")
            style.set("border", "1px solid #ccc") // Borde
            style.set("border-radius", "10px") // Bordes redondeados
            style.set("padding", "15px") // Espaciado interno
            style.set("box-shadow", "0px 4px 8px rgba(0,0,0,0.1)")
        }

        val mainText = Div(Text(xeet.text)).apply {
            style.set("font-size", "24px")
            style.set("text-align", "center")
            style.set("margin-bottom", "10px")
        }

        val bottomTextDiv = Div().apply {
            style.set("display", "flex")
            style.set("justify-content", "space-between")
            style.set("width", "100%")
        }

        // Texto pequeño alineado a la izquierda
        val leftText = Div(Text(xeet.userName)).apply {
            style.set("font-size", "10px")
        }

        // Texto pequeño alineado a la derecha
        val rightText = Div(Text(xeet.createDate
            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")))).apply {
            style.set("font-size", "10px")
        }

        // Añadir los componentes al contenedor principal
        bottomTextDiv.add(leftText, rightText)
        mainDiv.add(mainText, bottomTextDiv)

        add(mainDiv)
    }
}
