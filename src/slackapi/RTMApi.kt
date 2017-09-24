package slackapi

import com.neovisionaries.ws.client.*
import org.json.JSONObject
import utility.WebUtils
import utility.log
import java.net.URI
import javax.jws.WebParam
import java.io.BufferedReader
import org.omg.CORBA.TIMEOUT
import slackapi.types.MessageListener
import sun.net.sdp.SdpSupport.createSocket
import java.io.IOException
import java.util.*


class RTMApi private constructor(uri: URI) {
    private var messageListeners : List<MessageListener> = ArrayList<MessageListener>()

    companion object {
        public fun Connect(ctx : SlackContext) : RTMApi? {
            val json = JSONObject(WebUtils.getHTML("https://slack.com/api/rtm.connect",
                    WebUtils.UrlParam("token", ctx.config.token)))

            if ( !json.getBoolean("ok" ) ) return null

            return try {
                RTMApi(URI(json.getString("url")))
            } catch ( ex : Exception ) {
                log(ex)
                null
            }
        }
    }

    init {
        WebSocketFactory()
                .setConnectionTimeout(2000)
                .createSocket(uri)
                .addListener(object : WebSocketAdapter() {
                    private var receivedFirstMessage = false
                    override fun onTextMessage(websocket: WebSocket, message: String) {
                        val json = JSONObject(message)
                        log(message)
                        if ( json.getString("type").equals("message") ) {
                            //Slack auto sends the last message sent as the first message here, so we ignore that
                            if ( !receivedFirstMessage ) {
                                receivedFirstMessage = true
                                return
                            }
                            val msg = json.getString("text")
                            val matched = messageListeners.count { it.ProcessMessage(msg) }
                            log("Message \"$msg\" matched for $matched listeners.")
                        }
                    }

                })
                .connect()
    }


    fun AddMessageListener(listener : MessageListener) {
        messageListeners += listener
    }
}
