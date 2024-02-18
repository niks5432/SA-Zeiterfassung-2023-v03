package GuiElemente

import javafx.scene.control.Alert
import javafx.stage.Stage



private fun exit() {
    with(Alert(Alert.AlertType.INFORMATION)) {
        contentText = "App wird geschlossen..."
        showAndWait()
    }
}