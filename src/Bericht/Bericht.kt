package Bericht

class Bericht {
    var eintragid:  Int = 0
    var bericht:    String   =""

    fun berichteintrag() {

//        println("Bitte heutige Arbeit zusammenfassen")
//        bericht = readln()
        eintragid = lesenEintragIdDB()
        EintragBerichgtDB(bericht, eintragid)
    }

}