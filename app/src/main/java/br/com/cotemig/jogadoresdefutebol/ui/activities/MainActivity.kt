package br.com.cotemig.jogadoresdefutebol.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import br.com.cotemig.jogadoresdefutebol.R
import br.com.cotemig.jogadoresdefutebol.models.Player
import br.com.cotemig.jogadoresdefutebol.models.PlayerList
import br.com.cotemig.jogadoresdefutebol.services.RetrofitInitializer
import br.com.cotemig.jogadoresdefutebol.ui.adapters.PlayerAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPlayers();
    }

    fun getPlayers() {
        var initializer = RetrofitInitializer().servicePlayer()
        var call = initializer.getPlayers()

        call.enqueue(object : retrofit2.Callback<PlayerList> {
            override fun onResponse(call: Call<PlayerList>, response: Response<PlayerList>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        it.listPlayers?.let { list ->
                            showPlayers(list)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<PlayerList>, t: Throwable) {
                Toast.makeText(this@MainActivity, "deu erro amigo" + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showPlayers(list: List<Player>) {
        var players = findViewById<ListView>(R.id.players)
        players.adapter = PlayerAdapter(this, list)
    }
}