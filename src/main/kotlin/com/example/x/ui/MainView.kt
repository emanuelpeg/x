package com.example.x.ui

import com.example.x.service.XeetService
import com.vaadin.flow.component.Text
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Route("xui")
class MainView(val service : XeetService) : VerticalLayout() {

    val log: Logger = LoggerFactory.getLogger(MainView::class.java)

    init {
        callServerMethod(this::startup)
    }

    private fun callServerMethod(fx: () -> Unit) {
        try {
            fx()
        } catch (ex: Exception) {
            log.error(ex.message, ex)
            Notification.show("Error: " + ex.message)
        }
    }

    private fun startup() {
        val centerDiv = Div().apply {
            style.set("display", "flex")
            style.set("flex-direction", "column")
            style.set("width", "80%")
            style.set("margin", "0 auto")
        }

        val xeetsDiv = Div()
        setSizeFull()
        add(centerDiv)
        expand(centerDiv)
        centerDiv.add(xeetsDiv)

        service.get().subscribe {
            ui.ifPresent { xui ->
                xui.access {
                    xeetsDiv.add(XeetView(it!!))
                }
            }
        }
    }
}