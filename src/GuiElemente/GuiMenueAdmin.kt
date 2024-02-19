package GuiElemente

import angemeldet
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.SplitPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage
import vorname
import zustandZeitmessung

class GuiMenueAdmin{
    var root = BorderPane()
    val splitPane = SplitPane()
    val splitPaneZeitmessung = SplitPane()
    var vbox = VBox()
    val buttonZeitmessung = Button("Zeitmessung")
    val buttonArchiv = Button("Stunden Archiv")
    val buttonVisieren = Button("Zeiten Visieren")
    val buttonErstellen = Button("Benutzer erstellen")
    val buttonLogOut = Button("Log Out")


     fun start(stage: Stage){

         vbox = VBox().apply {
            spacing = 30.0
            padding = Insets(0.0, 0.0, 0.0, 70.0)
            children.addAll(
                Label("Herzlich Wilkommen $vorname").apply {
                    font = Font.font(20.0)
                    style = "-fx-font-weight: bold"
                    VBox.setMargin(this, Insets(20.0, 0.0, 0.0, -40.0))
                                                           },
                    Label("Menü").apply {
                    font = Font.font(18.0)
                    style = "-fx-font-weight: bold"
                    VBox.setMargin(this, Insets(-20.0, 0.0, 0.0, 35.0))
                                            },
                    buttonZeitmessung.apply {
                        prefWidth = 120.0
                                            },
                    buttonArchiv.apply {
                        prefWidth = 120.0
                                       },
                    buttonVisieren.apply {
                        prefWidth = 120.0
                                         },
                    buttonErstellen.apply {
                        prefWidth = 120.0
                                          },
                    buttonLogOut.apply {
                    prefWidth = 120.0
                    }
                )
            }

         GuiZeit.btnZeitmessung()
         GuiZeit.btnFlaecheZusammen.isVisible = false
         GuiAusgabeFenster.ausgabeFensterAnzeigen()
         GuiAusgabeFenster.ausgabeFenster.apply {
             prefWidth = 400.0
             prefHeight = 360.0
         }

        root = BorderPane().apply {
            left = vbox
            right = GuiAusgabeFenster.vbox
            bottom = GuiZeit.btnFlaecheZusammen
        }

        buttonZeitmessung.setOnAction {
            GuiZeit.btnFlaecheZusammen.isVisible = true
            GuiZeit.wilkommen()
        }

            buttonArchiv.setOnAction {
                stage.close()
                GuiZeitArchiv.start(stage)
            }
            buttonVisieren.setOnAction { }
            buttonErstellen.setOnAction {
                stage.close()
                GuiBenutzerErstellen.start(stage)
            }
            buttonLogOut.setOnAction {
                angemeldet = false
                zustandZeitmessung = 0
                println("Sie wurden Abgemeldet")
                stage.close()
                val loginGui = GuiLogIn()
                loginGui.start(stage)
            }

            with(stage) {
                scene = javafx.scene.Scene(root, 700.0, 500.0)
                title = "Zeiterfassung"
                show()
            }

    }
}
