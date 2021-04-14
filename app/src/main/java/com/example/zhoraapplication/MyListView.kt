import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.zhoraapplication.Player
import com.example.zhoraapplication.R

class MyListView(context: Context, list: MutableList<*>) : BaseAdapter() {
    private var context: Context = context
    private val list: MutableList<Player> = list as MutableList<Player>
    var mInflater: LayoutInflater? = null
    override fun getCount(): Int {
        // TODO Auto-generated method stub
        return list.size
    }

    override fun getItem(arg0: Int): Any {
        // TODO Auto-generated method stub
        return arg0
    }

    override fun getItemId(arg0: Int): Long {
        // TODO Auto-generated method stub
        return arg0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        val holder: ViewHolder
        convertView = null
        if (convertView == null) {
            holder = ViewHolder()
            val mInflater = context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = mInflater!!.inflate(R.layout.listview_adapter, null)
            holder.editText = convertView!!.findViewById(R.id.number) as EditText?
            holder.editText!!.text.clear()
            var textView : TextView = convertView.findViewById(R.id.name)
            textView.text = list[position].name.toString() +" " + list[position].points.toString()
            convertView.tag = holder
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }

        holder.editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence?, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable?) {
                if (holder.editText!!.text.toString() == " "){
                    list[position].pointsToPlus = 0
                }else{
                list[position].pointsToPlus = (holder.editText!!.text.toString().toInt())
                    }
            }
        })

        return convertView
    }

    private class ViewHolder {
        var editText: EditText? = null
    }
}

    /*
    override fun getView(position: Int, convertView: View?, arg2: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        convertView = null
        if (convertView == null) {
            holder = ViewHolder()
            mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
            convertView = mInflater!!.inflate(R.layout.listview_adapter, null)
            holder.caption = convertView
                    .findViewById<View>(R.id.number) as EditText
            var textView : TextView = convertView.findViewById(R.id.name)
            textView.setText(list[position].name.toString())
            holder.caption!!.tag = position
            //holder.caption!!.setText(list[position].toString())
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        val tag_position = holder.caption!!.tag as Int
        holder.caption!!.id = tag_position
        holder.caption!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int,
                                       count: Int) {
                val position2 = holder.caption!!.id
                val Caption = holder.caption
                if (Caption!!.text.toString().length > 0) {
                    list[position2].points = Caption.text.toString().toInt()
                } else {
                    Toast.makeText(context, "Please enter some value", Toast.LENGTH_SHORT).show()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int,
                                           after: Int) {
            }

            override fun afterTextChanged(s: Editable) {}
        })
        return convertView
    }

    init {
        this.context = context
        this.list = list as MutableList<Player>
    }
}

internal class ViewHolder {
    var caption: EditText? = null

     */
