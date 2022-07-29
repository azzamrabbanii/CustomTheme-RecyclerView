package com.example.recycleview_app_practice.secondrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class DataCar (
    var title: String?,
    var picture: String?
):Parcelable

