package com.example.zhoraapplication

import android.os.Parcel
import android.os.Parcelable

class Player(val name: String?, var points:Int, var pointsToPlus:Int) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readInt(), parcel.readInt())


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(points)
        parcel.writeInt(pointsToPlus)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }

}