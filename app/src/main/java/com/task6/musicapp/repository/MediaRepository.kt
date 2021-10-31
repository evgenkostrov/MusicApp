package com.task6.musicapp.repository

import androidx.lifecycle.LiveData
import com.task6.musicapp.room.RoomAudioModel
import com.task6.musicapp.room.RoomDao
import com.task6.musicapp.room.RoomFolderModel

class MediaRepository (private val mediaDao: RoomDao){

    //val musics : LiveData<List<RoomAudioModel>> = mediaDao.getMusics()
    //val folders: List<RoomFolderModel> = mediaDao.getFolders()
    //    suspend fun insertMusic(roomAudioModel: RoomAudioModel){
    //        mediaDao.insertMusic(roomAudioModel)
    //    }

    fun getFolders():LiveData<List<RoomFolderModel>> = mediaDao.getFolders()

    fun getMusics():LiveData<List<RoomAudioModel>> = mediaDao.getMusics()

    suspend fun getFoldersCount():Int = mediaDao.getFoldersCount()

    suspend fun checkForExist(newFolderName: String):Boolean = mediaDao.checkForExists(newFolderName)

    suspend fun getFolder(name: String): RoomFolderModel = mediaDao.getFolder(name)

    fun getMusic(position:Int) = mediaDao.getMusic(position)

    suspend fun setFavorite(intState:Int, position: Int){
        mediaDao.setFavorite(intState,position)
    }

    suspend fun insertMusics(musics:List<RoomAudioModel>){
        mediaDao.insertMusics(musics)
    }

    suspend fun updateFolder(folder: RoomFolderModel){
        mediaDao.updateFolder(folder)
    }

    suspend fun setNewFolderName(newFolderName: String, oldFolderName: String){
        mediaDao.setNewFolderName(newFolderName,oldFolderName)
    }

    suspend fun deleteFolder(roomFolderModel: RoomFolderModel){
        mediaDao.deleteFolder(roomFolderModel)
    }

    suspend fun insertFolder(roomFolderModel: RoomFolderModel){
        mediaDao.insertFolder(roomFolderModel)
    }


}