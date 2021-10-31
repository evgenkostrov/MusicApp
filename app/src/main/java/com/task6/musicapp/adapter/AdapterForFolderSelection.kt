package com.task6.musicapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task6.musicapp.interfaces.OnFolderForSelection
import com.task6.musicapp.room.RoomFolderModel
import com.task6.musicapp.databinding.FolderItemViewBinding
import java.io.Serializable

class AdapterForFolderSelection(val listener: OnFolderForSelection, var folders:List<RoomFolderModel>): RecyclerView.Adapter<AdapterForFolderSelection.ViewHolderHomeFragment>() , Serializable {

//    private val itemCallback = object : DiffUtil.ItemCallback<RoomFolderModel>(){
//        override fun areItemsTheSame(oldItem: RoomFolderModel, newItem: RoomFolderModel): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem: RoomFolderModel, newItem: RoomFolderModel): Boolean {
//            return  oldItem.folderName == newItem.folderName
//        }
//    }

    //val differ = AsyncListDiffer(this,itemCallback)



    inner class ViewHolderHomeFragment(private  var binding: FolderItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(model: RoomFolderModel, position: Int){
            binding.folderName.text = model.folderName

            //do mentioned
            binding.folderSongs.text = "${model.audioList?.size} tracks"
            binding.cardMenu.visibility = View.GONE

            binding.root.setOnClickListener {
                listener.onFolderForSelectionClick(model,position)
            }
            if (model.folderName == "Your musics"||model.folderName=="Favorites"){
                binding.cardMenu.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeFragment {
        return  ViewHolderHomeFragment(
                FolderItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int = folders.size

    override fun onBindViewHolder(holder: ViewHolderHomeFragment, position: Int) {
        holder.onBind(folders[position],position)
    }

}