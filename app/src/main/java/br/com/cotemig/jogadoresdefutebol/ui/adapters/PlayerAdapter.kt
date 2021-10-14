package br.com.cotemig.jogadoresdefutebol.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.jogadoresdefutebol.R
import br.com.cotemig.jogadoresdefutebol.models.Player
import coil.load

class PlayerAdapter(var context: Context, var players: List<Player>) : BaseAdapter() {
    override fun getCount(): Int {
        return players.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_player, null)

        var photo = view.findViewById<ImageView>(R.id.photo)
        var name = view.findViewById<TextView>(R.id.name)
        var team = view.findViewById<TextView>(R.id.team)
        players[position]?.let {
            photo.load(it.photoUrl)
            name.text = it.name
            team.text = it.team
        }

        return view
    }
}