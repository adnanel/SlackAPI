package slackapi

import org.json.JSONObject
import slackapi.types.Channel
import utility.WebUtils
import utility.log

public class ChannelApi(private val ctx: SlackContext) {

    fun List() : List<Channel> {
        val obj = JSONObject(
                WebUtils.getHTML("https://slack.com/api/channels.list", WebUtils.UrlParam("token", ctx.config.token)))

        if ( !obj.getBoolean("ok") ) {
            log("Channels.List failed.")
            return ArrayList()
        }

        val res = ArrayList<Channel>()
        for ( jsonObj in obj.getJSONArray("channels") ) {
            res.add(Channel(jsonObj as JSONObject))
        }
        return res
    }
}