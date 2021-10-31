package com.task6.musicapp.interfaces

import android.view.View
import com.task6.musicapp.room.RoomFolderModel
import java.io.Serializable

interface OnFolderListener:Serializable {
    fun onFolderItemClick(view:View, folder: RoomFolderModel, position:Int)
    fun onFolderClick(folder: RoomFolderModel)
}