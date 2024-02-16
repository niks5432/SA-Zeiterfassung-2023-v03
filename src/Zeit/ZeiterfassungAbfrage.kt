

fun zeiterfassungAbfrage(state: Boolean){
    val heutigeZeit = Zeiterfassung()

    if (state) {
        when (zustandZeitmessung) {
            0 -> heutigeZeit.zeitEruieren(1)
            2 -> heutigeZeit.zeitEruieren(3)
        }
    } else {
        when (zustandZeitmessung) {
            1 -> heutigeZeit.zeitEruieren(2)
            3 -> heutigeZeit.zeitEruieren(4)
        }
    }
}

