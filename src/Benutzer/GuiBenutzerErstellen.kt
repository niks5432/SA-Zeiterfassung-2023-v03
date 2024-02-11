package Benutzer

import Archiv.guiMenue
import GuiMenueAdmin
import GuiMenueAdmin.guiStage
import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage


object GuiBenutzerErstellen {
    private val newUserid = 0
    private val newUserPassword = TextField()
    private val newVorname = TextField()
    private val newNachname = TextField()
    private val newEmail = TextField()
    private val newFunktion = TextField()
    private val adminRbn = RadioButton("Admin")

    private val nonAdminRbn = RadioButton("kein Admin")
    private val buttonBenutzerErstellen = Button("Erstellen")
    private val buttonZurückMenue = Button("Menü")

    private var titleLabel = Label("Menüpunkt Benutzer erstellen")
    private var hinweisLabel = Label("Wenn ein Benutzer mit leeren Zeilen erstellt wird, wird das Programm abgebrochen.\n" +
                                     "(Admin Zeile kann leer bleiben)")
    private var newVornameLabel = Label("Bitte den Vornamen des neuen Benutzer Eingeben")
    private var newNachnameLabel = Label("Bitte den Nachnamen des neuen Benutzer Eingeben")
    private var newPasswortLabel = Label("Bitte das Passwort des neuen Benutzer Eingeben")
    private var newEmailLabel = Label("Bitte die E-Mail Adresse des neuen Benutzer Eingeben")
    private var newFunktionLabel = Label("Bitte die Funktion des neuen Benutzer Eingeben")
    private var newAdminLabel = Label("Bitte Admin eintrgane falls der neue Benutzer Admin Rechte erhalten soll")
    private var rbnAdmIs = false

    fun start(stage: Stage) {

            val vbox = VBox().apply {

                spacing = 10.0
                padding = Insets(20.0, 15.0, 15.0, 10.0)


                with(children) {
                    addAll(
                        titleLabel.apply {
                            font = Font.font(25.0)
                            style = "-fx-font-weight: bold"
                        },
                        newVornameLabel.apply {
                            padding = Insets(0.0, 0.0, -5.0, 2.0)
                        },
                        newVorname.apply {
                            maxWidth = 200.0
                            promptText = "Vornamen"
                        },
                        newNachnameLabel.apply {
                            padding = Insets(0.0, 0.0, -5.0, 2.0)
                        },
                        newNachname.apply {
                            maxWidth = 200.0
                            promptText = "Nachnamen"
                        },
                        newPasswortLabel.apply {
                            padding = Insets(0.0, 0.0, -5.0, 2.0)
                        },
                        newUserPassword.apply {
                            maxWidth = 200.0
                            promptText = "Passwort"
                        },
                        newEmailLabel.apply {
                            padding = Insets(0.0, 0.0, -5.0, 2.0)
                        },
                        newEmail.apply {
                            maxWidth = 200.0
                            promptText = "Email"
                        },
                        newFunktionLabel.apply {
                            padding = Insets(0.0, 0.0, -5.0, 2.0)
                        },
                        newFunktion.apply {
                            maxWidth = 200.0
                            promptText = "Funktion"
                        },
                        newAdminLabel.apply {
                            padding = Insets(0.0, 0.0, -5.0, 2.0)
                        },
                        adminRbn.apply {

                            },
                        nonAdminRbn.apply {
                                VBox.setMargin(this, Insets(-28.0, 0.0, 0.0, 90.0))
                        },
                        buttonBenutzerErstellen.apply {
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

        adminRbn.setOnAction {
            eintageAdmin(adminRbn)
        }

        nonAdminRbn.setOnAction {
            eintageAdmin(nonAdminRbn)
        }

        buttonBenutzerErstellen.setOnAction {
            eintragBenutzerDb(newUserid, newUserPassword.text, newVorname.text, newNachname.text, newEmail.text, newFunktion.text, rbnAdmIs)
            textTflReset()
        }
        buttonZurückMenue.setOnAction {
            vbox.isVisible()
            GuiMenueAdmin.start(guiStage)
        }


            with(stage) {
                scene = javafx.scene.Scene(vbox, 700.0, 500.0)
                title = "Zeiterfassung"
                show()
            }
        }

    fun textTflReset() {
        newUserPassword.text = ""
        newVorname.text = ""
        newNachname.text = ""
        newEmail.text = ""
        newFunktion.text = ""
        nonAdminRbn.isSelected = false
        adminRbn.isSelected = false
    }

    private fun eintageAdmin(rbn: RadioButton) {
        if (rbn == adminRbn && rbn.isSelected) {
            nonAdminRbn.isSelected = false
            println("Admin")
            rbnAdmIs = true
        } else if (rbn == nonAdminRbn && rbn.isSelected) {
            adminRbn.isSelected = false
            println("kein Admin")
            rbnAdmIs = false
        }
    }

}