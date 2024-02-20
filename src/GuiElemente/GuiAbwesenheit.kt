package GuiElemente

import Bericht.Bericht
import Zeit.abwesenheit
import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage
import java.util.ArrayList


object GuiAbwesenheit {

    private var titleLabel = Label("Abwesenheit Melden")
    private var grundLabel = Label("Bitte Grund der Abwesenheit angeben")
    private var dauerLabel = Label("Bitte Pensum bei Abwesenheit angeben")
    private var datumLabel = Label("Bitte Dauer der Abwesenheit angeben")

    val rbnKrank = RadioButton("Krankheit")
    val rbnFeiertag = RadioButton("Feiertag")
    val rbnHalbertag = RadioButton("Halbtags Abwesend")
    val rbnGanzerTag = RadioButton("Ganztags Abwesend")

    val strDatum = TextField()
    val endDatum = TextField()

    private val buttonAbsenden = Button("Speichern")
    private val buttonBack = Button("Fenster schliessen")
    fun start(stage: Stage) {

        val hboxGrund = HBox().apply {
            spacing = 20.0
            with(children) {
                addAll(
                    rbnKrank.apply {

                    },
                    rbnFeiertag.apply {

                    },
                )
            }
        }

        val hboxDauer = HBox().apply {
            spacing = 20.0
            with(children) {
                addAll(
                    rbnHalbertag.apply {

                    },
                    rbnGanzerTag.apply {

                    },
                )
            }
        }

        val hboxDatum = HBox().apply {
            spacing = 20.0
//            padding = Insets(10.0, 10.0, 10.0, 10.0)
            with(children) {
                addAll(
                    strDatum.apply {
                        maxWidth = 200.0
                        promptText = "Format: YYYY-MM-DD"
                    },
                    endDatum.apply {
                        maxWidth = 200.0
                        promptText = "Format: YYYY-MM-DD"
                    }
                )
            }
        }

        val hboxBtn = HBox().apply {
            spacing = 20.0
//            padding = Insets(10.0, 10.0, 10.0, 10.0)
            with(children) {
                addAll(
                    buttonAbsenden.apply {
                        prefWidth = 120.0
                        VBox.setMargin(this, Insets(0.0, 0.0, 0.0, 0.0))
                    },
                    buttonBack.apply {
                        prefWidth = 120.0
                        VBox.setMargin(this, Insets(0.0, 0.0, 0.0, 0.0))
                    }
                )
            }
        }

        val vboxAll = VBox().apply {
            spacing = 10.0
            padding = Insets(10.0, 20.0, 10.0, 20.0)
            with(children) {
                addAll(
                    titleLabel.apply {
                        font = Font.font(25.0)
                        style = "-fx-font-weight: bold"
                                     },
                    grundLabel,
                    hboxGrund,
                    dauerLabel,
                    hboxDauer,
                    datumLabel,
                    hboxDatum,
                    hboxBtn
                )
            }
        }

        rbnKrank.setOnAction {
            println("1")
            rbnGrund(rbnKrank)
        }
        rbnFeiertag.setOnAction {
            rbnGrund(rbnFeiertag)

        }

        rbnHalbertag.setOnAction {
            rbnDauer(rbnHalbertag)

        }
        rbnGanzerTag.setOnAction {
            rbnDauer(rbnGanzerTag)
        }

        buttonAbsenden.setOnAction {
            abwesenheit()
        }
        buttonBack.setOnAction {
            stage.close()
        }


        with(stage) {
            scene = javafx.scene.Scene(vboxAll, 400.0, 280.0)
            title = "Zeiterfassung"
            show()
        }
    }
    private fun rbnGrund(rbn: RadioButton) {
        if (rbn == rbnKrank && rbn.isSelected) rbnFeiertag.isSelected = false
        else if (rbn == rbnFeiertag && rbn.isSelected)  rbnKrank.isSelected = false
    }

    private fun rbnDauer(rbn: RadioButton) {
        if (rbn == rbnHalbertag && rbn.isSelected) rbnGanzerTag.isSelected = false
        else if (rbn == rbnGanzerTag && rbn.isSelected)  rbnHalbertag.isSelected = false
    }

    fun textTflReset() {
           }

    }
