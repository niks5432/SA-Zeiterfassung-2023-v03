package Bericht

import GuiAusgabeFenster
import GuiMenueAdmin
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage


object GuiBericht {

    val tagesBericht = TextArea()


    private val buttonAbsenden= Button("Absenden")

    private var titleLabel = Label("Bitte Tagesbericht eintragen")



    fun start(stage: Stage) {

        val vbox = VBox().apply {
            spacing = 10.0
            padding = Insets(10.0, 10.0, 10.0, 10.0)
            with(children) {
                addAll(
                    titleLabel.apply {
                        font = Font.font(13.0)
                        style = "-fx-font-weight: bold"
                    },
                    tagesBericht.apply {
                        promptText = "Tagesbericht"
                        prefWidth = 350.0
                        prefHeight = 350.0
                        maxWidth = Double.MAX_VALUE
                        maxHeight = Double.MAX_VALUE
                    },
                    buttonAbsenden.apply {
                        prefWidth = 80.0
                        VBox.setMargin(this, Insets(0.0, 0.0, 0.0, 0.0))
                    }
                )
            }
        }

        buttonAbsenden.setOnAction {
            val heutigerBericht = Bericht()
            heutigerBericht.bericht = tagesBericht.text
            heutigerBericht.berichteintrag()
            stage.close()


        }


        with(stage) {
            scene = javafx.scene.Scene(vbox, 400.0, 400.0)
            title = "Zeiterfassung"
            show()
        }
    }

    fun textTflReset() {
           }

    }
