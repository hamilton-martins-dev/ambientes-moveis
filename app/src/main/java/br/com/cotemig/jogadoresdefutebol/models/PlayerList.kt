package br.com.cotemig.jogadoresdefutebol.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PlayerList : Serializable {

    @SerializedName("lista")
    var listPlayers: List<Player>? = null;
}