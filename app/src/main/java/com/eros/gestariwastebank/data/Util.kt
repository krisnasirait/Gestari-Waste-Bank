package com.eros.gestariwastebank.data

import com.eros.gestariwastebank.main.home.artikel.Artikel
import com.eros.gestariwastebank.main.notification.notification.Notification
import com.eros.gestariwastebank.main.wallet.history.History

object Util {

    const val apiKey = "52a1b6b4382749eda3567e187c1772ea"

    val allArtikel = arrayListOf(
        Artikel("How to create a valueable compose waste", "Adalah bencana 1"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 2"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 3"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 4"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 5"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 6"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 7"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 8"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 9"),
        Artikel("How to create a valueable compose waste", "Adalah bencana 10"),
    )

    val allNotification = arrayListOf(
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
        Notification("09 November 2022", "20.00", "Permintaanmu sudah terkirim, silahkan tunggu sampai admin mengkonfirmasi"),
    )

    val allHistory = arrayListOf(
        History("Penyetoran", "20 Oktober 2022", 31500),
        History("Penarikan", "20 Oktober 2022", 72500),
        History("Penyetoran", "20 Oktober 2022", 33500),
        History("Penarikan", "20 Oktober 2022", 74500),
        History("Penyetoran", "20 Oktober 2022", 35500),
        History("Penarikan", "20 Oktober 2022", 76500),
        History("Penyetoran", "20 Oktober 2022", 35500),
        History("Penarikan", "20 Oktober 2022", 78500),
        History("Penyetoran", "20 Oktober 2022", 39500),
        History("Penarikan", "20 Oktober 2022", 70500),
    )
}