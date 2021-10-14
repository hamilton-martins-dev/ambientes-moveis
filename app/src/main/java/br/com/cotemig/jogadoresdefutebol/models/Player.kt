package br.com.cotemig.jogadoresdefutebol.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Player : Serializable {

    @SerializedName("foto")
    var photoUrl: String? = null;

    @SerializedName("nome")
    var name: String? = null;

    @SerializedName("time")
    var team: String? = null;
}