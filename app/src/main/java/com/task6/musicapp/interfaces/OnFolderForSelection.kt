package com.task6.musicapp.interfaces

import com.task6.musicapp.room.RoomFolderModel

interface OnFolderForSelection {
    fun onFolderForSelectionClick(model: RoomFolderModel, position: Int)
}