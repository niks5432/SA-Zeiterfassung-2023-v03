package GuiElemente

import ZeitArchiv.ZeitArchiv
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage


object GuiZeitArchiv {

    private val zeitArchiv = ZeitArchiv()
    var newUserid = TextField()
    var startDatum = TextField()
    var endDatum = TextField()

    private val buttonSuchen= Button("Suchen")
    private val buttonZurückMenue = Button("Menü")
    private var hinweisLabel = Label("Datum im folgendem Format (YYYY-MM-DD)")

    private var titleLabel = Label("Menüpunkt Archiv erstellen")
    private var startDatumLabel = Label("Geben Sie ein Startdatum ein")
    private var userIDLabel = Label("Geben Sie das User Id im Format ein")
    private var endDatumLabel = Label("Geben Sie ein Enddatum ein")


    fun start(stage: Stage) {
        val splitPane = SplitPane()
        GuiAusgabeFenster.ausgabeFensterAnzeigen()
        GuiAusgabeFenster.ausgabeFenster.apply {
            prefWidth = 700.0
            prefHeight = 360.0
        }
        val vbox = VBox().apply {
            spacing = 10.0
            padding = Insets(20.0, 15.0, 15.0, 10.0)
            with(children) {
                addAll(
                    titleLabel.apply {
                        font = Font.font(20.0)
                        style = "-fx-font-weight: bold"
                    },
                    hinweisLabel.apply {
                        font = Font.font(13.0)
                        style = "-fx-font-weight: bold"
                    },
                    userIDLabel.apply {
                        padding = Insets(0.0, 0.0, -5.0, 2.0)
                    },
                    newUserid.apply {
                        maxWidth = 200.0
                        promptText = "User ID"
                    },
                    startDatumLabel.apply {
                        padding = Insets(0.0, 0.0, -5.0, 2.0)
                    },
                    startDatum.apply {
                        maxWidth = 200.0
                        promptText = "Startdatum"
                    },
                    endDatumLabel.apply {
                        padding = Insets(0.0, 0.0, -5.0, 2.0)
                    },
                    endDatum.apply {
                        maxWidth = 200.0
                        promptText = "Enddatum"
                    },
                    buttonSuchen.apply {
                        prefWidth = 80.0
                        VBox.setMargin(this, Insets(0.0, 0.0, 0.0, 90.0))
                    },
                    buttonZurückMenue.apply {
                        prefWidth = 80.0
                        VBox.setMargin(this, Insets(-35.0, 0.0, 0.0, 0.0))
                    }
                )

            }
        }

        splitPane.apply {
            orientation = Orientation.HORIZONTAL
            items.addAll(vbox, GuiAusgabeFenster.vbox)
            setDividerPositions(0.28)
        }


        buttonSuchen.setOnAction {
            zeitArchiv.startDatumStr = startDatum.text
            zeitArchiv.endDatumStr = endDatum.text
            zeitArchiv.abfrageUserId = newUserid.text
            println(startDatum.text)
            zeitArchiv.archiveAbfrage()
            reset()
        }
        buttonZurückMenue.setOnAction {
            stage.close()
            val guiMenueAdmin = GuiMenueAdmin()
            guiMenueAdmin.start(stage)
            GuiAusgabeFenster.clear()
        }

        with(stage) {
            scene = javafx.scene.Scene(splitPane, 1100.0, 500.0)
            title = "Zeiterfassung"
            show()
        }
    }

    fun reset() {
         newUserid.text = ""
         startDatum.text = ""
         endDatum.text = ""

           }

    }
