package com.eros.gestariwastebank.data

import com.eros.gestariwastebank.main.home.artikel.Artikel
import com.eros.gestariwastebank.main.notification.notification.Notification
import com.eros.gestariwastebank.main.wallet.history.History

object Util {

    val allArtikel = arrayListOf(
        Artikel("Bencana 1", "Adalah bencana 1"),
        Artikel("Bencana 2", "Adalah bencana 2"),
        Artikel("Bencana 3", "Adalah bencana 3"),
        Artikel("Bencana 4", "Adalah bencana 4"),
        Artikel("Bencana 5", "Adalah bencana 5"),
        Artikel("Bencana 6", "Adalah bencana 6"),
        Artikel("Bencana 7", "Adalah bencana 7"),
        Artikel("Bencana 8", "Adalah bencana 8"),
        Artikel("Bencana 9", "Adalah bencana 9"),
        Artikel("Bencana 10", "Adalah bencana 10"),
    )

    val allNotification = arrayListOf(
        Notification("09 November 2022", "20.00", "Permintaan anda sudah berhasil diproses"),
        Notification("09 November 2022", "20.00", "Permintaan anda gagal"),
        Notification("09 November 2022", "20.00", "Permintaan anda sudah berhasil diproses"),
        Notification("09 November 2022", "20.00", "Permintaan anda gagal"),
        Notification("09 November 2022", "20.00", "Permintaan anda sudah berhasil diproses"),
        Notification("09 November 2022", "20.00", "Permintaan anda gagal"),
        Notification("09 November 2022", "20.00", "Permintaan anda sudah berhasil diproses"),
        Notification("09 November 2022", "20.00", "Permintaan anda gagal"),
        Notification("09 November 2022", "20.00", "Permintaan anda sudah berhasil diproses"),
    )

    val allHistory = arrayListOf(
        History("Penyetoran", "20 Oktober 2022", 3.500),
        History("Penarikan", "20 Oktober 2022", 7.500),
        History("Penyetoran", "20 Oktober 2022", 3.500),
        History("Penarikan", "20 Oktober 2022", 7.500),
        History("Penyetoran", "20 Oktober 2022", 3.500),
        History("Penarikan", "20 Oktober 2022", 7.500),
        History("Penyetoran", "20 Oktober 2022", 3.500),
        History("Penarikan", "20 Oktober 2022", 7.500),
        History("Penyetoran", "20 Oktober 2022", 3.500),
        History("Penarikan", "20 Oktober 2022", 7.500),
    )
}