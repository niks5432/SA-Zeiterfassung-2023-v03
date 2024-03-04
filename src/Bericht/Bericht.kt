package Bericht

class Bericht {
    var eintragid:  Int = 0                     // erstellen der benötigten Attribute
    var bericht:    String   =""

    fun berichteintrag() {
        eintragid = lesenEintragIdDB()                  // Abfrage der Letzten EintragsID in der Datenbanktabbelle Bericht
        EintragBerichgtDB(bericht, eintragid)           // Eintragen des ausgefüllten Berichts in die Datenbank
    }

}