package momonyan.roomstudy.recycler_view_content

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import momonyan.roomstudy.R
import momonyan.roomstudy.database.Users

class RecyclerAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var mRecyclerView: RecyclerView? = null

    private var itemList: List<Users> = emptyList()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.let {
            it.nameTextView.text = itemList[position].name
            it.ageTextView.text = itemList[position].age.toString()
            it.genderTextView.text = if (itemList[position].gender) {
                "男"
            } else {
                "女"
            }
            it.hobbyTextView.text = itemList[position].hobby ?: ""
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(itemList: List<Users>){
        this.itemList = itemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.recycler_once_item_layout, parent, false)

        return RecyclerViewHolder(mView)
    }
}