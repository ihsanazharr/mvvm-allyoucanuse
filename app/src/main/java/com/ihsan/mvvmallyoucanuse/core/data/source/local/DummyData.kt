package com.ihsan.mvvmallyoucanuse.core.data.source.local

import com.ihsan.mvvmallyoucanuse.R
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Barang
import com.ihsan.mvvmallyoucanuse.core.data.source.model.Ruangan

object DummyData {

    val listBarang = listOf(
        Barang(
            id = "1",
            name = "Proyektor",
            image = R.drawable.projector,
            stok = 4,
            deskripsi = "Pluto Projector uhuy lorem ipsum ini adalah deskripsi fdsknfsnjfjsnakfnksdnfjsdnksffs"
        ),
       Barang(
            id = "2",
            name = "Microfon Wireless",
            image = R.drawable.mic,
            stok = 6,
            deskripsi = "Mikrofon pelunas hutang biasa digunakan untuk berbagai macam kegiatan janfsdjfbsdbkdbjfkvsfnd"
       ),
        Barang(
            id = "3",
            name = "Bola Voli",
            image = R.drawable.bola_voli,
            stok = 3,
            deskripsi = "Bola voli ini sering digunakan untuk bermain voli di lapang voli jsfkjfsdnfsdfsfs"
        ),
        Barang(
            id = "4",
            name = "Laptop",
            image = R.drawable.laptop,
            stok = 7,
            deskripsi = "Laptop Asus Berspesifikasi tinggi tapi bukan buat main game yah, ini buat dipakai intuk keperluan yang lain"
        ),
        Barang(
            id = "5",
            name = "Kipas Angin",
            image = R.drawable.electric_fan,
            stok = 2,
            deskripsi = "Kipas Angin Standing sangat bermanfaat untuk pendingan ruangan agar sejuk, cocok dipakai untuk acara formal di dalam ruangan"
        )
    )

    val listRuangan = listOf(
        Ruangan(
            id = "1",
            name = "Masjid Ulul Albab",
            image = R.drawable.masjidululalbab,
            deskripsi = "Pluto Projector uhuy lorem ipsum ini adalah deskripsi fdsknfsnjfjsnakfnksdnfjsdnksffs"
        ),
        Ruangan(
            id = "2",
            name = "Gedung Aula",
            image = R.drawable.gedungaula,
            deskripsi = "Mikrofon pelunas hutang biasa digunakan untuk berbagai macam kegiatan janfsdjfbsdbkdbjfkvsfnd"
        ),
        Ruangan(
            id = "3",
            name = "Lapang 1",
            image = R.drawable.lapang1,
            deskripsi = "Bola voli ini sering digunakan untuk bermain voli di lapang voli jsfkjfsdnfsdfsfs"
        ),
        Ruangan(
            id = "4",
            name = "Lapang 2",
            image = R.drawable.lapang2,
            deskripsi = "Laptop Asus Berspesifikasi tinggi tapi bukan buat main game yah, ini buat dipakai intuk keperluan yang lain"
        ),
        Ruangan(
            id = "5",
            name = "Ruang UKS",
            image = R.drawable.masjidululalbab,
            deskripsi = "Kipas Angin Standing sangat bermanfaat untuk pendingan ruangan agar sejuk, cocok dipakai untuk acara formal di dalam ruangan"
        )
    )
}