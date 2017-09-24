package slackapi

import org.json.JSONObject
import slackapi.types.Message
import utility.WebUtils
import utility.log

public class ChatApi(private val ctx : SlackContext ) {
    fun PostMessage(channelId : String, message : String, asBot : Boolean = true, botUsername : String = ctx.config.username) : Message {
        val json = JSONObject(WebUtils.getHTML("https://slack.com/api/chat.postMessage",
                WebUtils.UrlParam("token", ctx.config.token),
                WebUtils.UrlParam("channel", channelId),
                WebUtils.UrlParam("text", message),
                WebUtils.UrlParam("as_user", (!asBot).toString()),
                WebUtils.UrlParam("username", botUsername)))

        return Message(json)
    }

    fun UpdateMessage(channelId : String, ts : String, message : String) : Message {
        val json = JSONObject(WebUtils.getHTML("https://slack.com/api/chat.update",
                WebUtils.UrlParam("token", ctx.config.token),
                WebUtils.UrlParam("ts", ts),
                WebUtils.UrlParam("channel", channelId),
                WebUtils.UrlParam("text", message)))

        return Message(json)
    }

    fun DeleteMessage(channelId : String, ts : String) : Message {
        val json = JSONObject(WebUtils.getHTML("https://slack.com/api/chat.delete",
                WebUtils.UrlParam("token", ctx.config.token),
                WebUtils.UrlParam("ts", ts),
                WebUtils.UrlParam("channel", channelId)))

        return Message(json)
    }
}