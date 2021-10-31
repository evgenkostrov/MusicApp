package com.task6.musicapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.task6.musicapp.room.RoomAudioModel
import java.io.Serializable

@Entity()
data class RoomFolderModel (
    @ColumnInfo(name = "folderName")
        var folderName :String,
    @ColumnInfo(name = "audioList")
        var audioList:List<RoomAudioModel>,
):Serializable{
        @PrimaryKey(autoGenerate = true)
        var id :Int =0
}