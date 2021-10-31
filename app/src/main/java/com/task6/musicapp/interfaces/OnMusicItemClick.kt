package com.task6.musicapp.interfaces

import android.view.View
import com.task6.musicapp.room.RoomAudioModel
import java.io.Serializable

interface OnMusicItemClick : Serializable {
    fun onMenuItemClick(model: RoomAudioModel, position: Int, view:View)
    fun onMusicModelLongClick(position: Int)

}