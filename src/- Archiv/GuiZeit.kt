//package `- Archiv`
//
//import AusgabeFenster
//import GuiElemente.GuiBenutzerErstellen
//import Benutzer.eintragBenutzerDb
//import GuiLogIn
//import GuiMenueAdmin
//import LogIn.logInAbfrage
//import SplitPlaneGenerator
//import com.sun.javafx.application.PlatformImpl
//import javafx.geometry.Insets
//import javafx.geometry.Orientation
//import javafx.geometry.Pos
//import javafx.scene.Scene
//import javafx.scene.control.Button
//import javafx.scene.control.RadioButton
//import javafx.scene.control.SplitPane
//import javafx.scene.layout.BorderPane
//import javafx.scene.layout.VBox
//import javafx.scene.text.Font
//import javafx.stage.Stage
//import zeiterfassungAbfrage
//import zustandZeitmessung
//import java.lang.Appendable
//
//object GuiZeit {
//    private val splitPane = SplitPane()
//    val btnStart = Button("Zeiterfassung Start")
//    val btnEnde = Button("Zeiterfassung Stopp")
//    val btnBack = Button("Ansicht Schliessen")
//    var btnZeiterfassung = VBox()
//    var firstCall = true
//    private val guiMenueAdmin = GuiMenueAdmin()
//    private val ausgabeFenster = AusgabeFenster()
//    fun start() {
//
//        val root = BorderPane()
//
////        ausgabeFenster.ausgabeFensterAnzeigen()
////        ausgabeFenster.ausgabeTextHinzufügen("Menüpunkt: Zeitmessung")
//
//        btnZeiterfassung = VBox().apply {
//            spacing = 10.0
//            padding = Insets(20.0, 15.0, 15.0, 10.0)
//            with(children) {
//                addAll(
//                    btnStart.apply {
//                        prefWidth = 160.0
//                        VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 50.0))
//                    },
//                    btnEnde.apply {
//                        prefWidth = 160.0
//                        VBox.setMargin(this, Insets(-25.0, 0.0, 0.0, 270.0))
//                    },
//                    btnBack.apply {
//                        prefWidth = 160.0
//                        VBox.setMargin(this, Insets(-25.0, 55.0, 0.0, 485.0))
//                    }
//                )
//            }
//        }
//
//
//        btnStart.setOnAction {
//            zeiterfassungAbfrage(true)
//
//        }
//
//        btnEnde.setOnAction {
//            zeiterfassungAbfrage(false)
//
//        }
//
//        btnBack.setOnAction {
////            stage.close()
////            guiMenueAdminStage.close()
////            val guiMenueAdmin = GuiMenueAdmin()
////            guiMenueAdmin.start(stage)
//            btnZeiterfassung.isVisible = false
//        }
//
//
//
//
//
//
////          with(stage) {
////              scene = Scene(root, 700.0, 500.0)
////              title = "Zeiterfassung"
//////            setOnCloseRequest { PlatformImpl.exit() }
////              show()
//    }
//
//
//    fun reset() {
//
//    }
//
//    fun textWeitergabe(text: String) {
//        ausgabeFenster.ausgabeTextHinzufügen(text)
//    }
//
//}