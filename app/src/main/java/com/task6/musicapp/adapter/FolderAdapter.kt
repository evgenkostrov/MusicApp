package com.task6.musicapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task6.musicapp.interfaces.OnFolderListener
import com.task6.musicapp.room.RoomFolderModel
import com.task6.musicapp.databinding.FolderItemViewBinding
import java.io.Serializable


class FolderAdapter(val listener: OnFolderListener, var folders : List<RoomFolderModel>): RecyclerView.Adapter<FolderAdapter.ViewHolderHomeFragment>() ,Serializable{

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
        fun onBind(model: RoomFolderModel){
            binding.folderName.text = model.folderName

            //do mentioned
            binding.folderSongs.text = "${model.audioList?.size} tracks"
            binding.cardMenu.elevation = 0F

            binding.root.setOnClickListener {
                listener.onFolderClick(model)
            }
            if (model.folderName == "Your musics"||model.folderName=="Favorites"){
                binding.cardMenu.visibility = View.GONE
            }

            binding.cardMenu.setOnClickListener {
                listener.onFolderItemClick(binding.cardMenu,model,adapterPosition)
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
        holder.onBind(folders[position])
    }
}