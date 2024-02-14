package Zeit

import Benutzer.GuiBenutzerErstellen
import Benutzer.eintragBenutzerDb
import GuiLogIn
import GuiMenueAdmin
import com.sun.javafx.application.PlatformImpl
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.control.SplitPane
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage

object GuiZeit {
    private val btnStart = Button("Zeiterfassung Start")
    private val btnEnde = Button("Zeiterfassung Stopp")
    private val btnBack = Button("Ansicht Schliessen")

    fun start(stage: Stage) {

        val splitPane = SplitPane()
        val guiMenueAdmin = GuiMenueAdmin()
        guiMenueAdmin.start(stage)

        val btnZeiterfassung = VBox().apply {
            spacing = 10.0
            padding = Insets(20.0, 15.0, 15.0, 10.0)
            with(children) {
                addAll(
                    btnStart.apply {
                        prefWidth = 160.0
                        VBox.setMargin(this, Insets(0.0, 0.0, 0.0, 50.0))
                    },
                    btnEnde.apply {
                        prefWidth = 160.0
                        VBox.setMargin(this, Insets(-35.0, 0.0, 0.0, 270.0))
                    },
                    btnBack.apply {
                        prefWidth = 160.0
                    VBox.setMargin(this, Insets(-35.0, 55.0, 0.0, 485.0))
                    }
                )
            }
        }

        splitPane.apply {
            orientation = Orientation.VERTICAL
            items.addAll(guiMenueAdmin.splitPane, btnZeiterfassung)
            setDividerPositions(0.8) // Set initial divider position
        }

        with(stage) {
            scene = Scene(splitPane, 700.0, 500.0)
            title = "Zeiterfassung"
            setOnCloseRequest { PlatformImpl.exit() }
            show()
        }
    }
    fun reset() {

    }

}
