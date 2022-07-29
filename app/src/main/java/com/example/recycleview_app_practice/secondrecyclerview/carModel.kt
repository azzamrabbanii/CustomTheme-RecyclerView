package com.example.recycleview_app_practice.secondrecyclerview


object carModel {
    private val title = arrayOf(
        "BMW m2",
        "Mercedes Benz amg 63",
        "Ford Mustang Shelby gt500"
    )

    private val picture = arrayOf(
        "https://pict-b.sindonews.net/dyn/620/pena/news/2021/02/15/120/335674/bmw-m2-the-beast-modifikasi-anak-bangsa-raih-pengakuan-dunia-enm.jpeg",
        "https://static.carmudi.co.id/gsmSY2ZXP2LhyW-H4r5p-b4ZHSM=/900x405/https://trenotomotif.com/ncs/images/Mercedes-Benz/AMG%20G63/AMG_G63_thumbnail.jpg",
        "https://img.inews.co.id/media/822/files/inews_new/2019/01/17/ford.jpg"
    )

    val listCar : ArrayList<DataCar>
    get() {
        val list = arrayListOf<DataCar>()
        for (data in title.indices) {
            val dataList = DataCar(
                title = title[data],
                picture = picture[data]
            )
            list.add(dataList)
        }
        return list
    }
}