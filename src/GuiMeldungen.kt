import javafx.scene.control.Alert
import javafx.stage.Stage

fun logInFenster() {
    val loginStage = Stage()
    val loginGui = GuiLogIn()
    loginGui.start(loginStage)
}

private fun exit() {
    with(Alert(Alert.AlertType.INFORMATION)) {
        contentText = "App wird geschlossen..."
        showAndWait()
    }
}