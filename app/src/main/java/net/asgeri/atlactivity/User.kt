package net.asgeri.atlactivity

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String, @DrawableRes val image: Int) : Parcelable
