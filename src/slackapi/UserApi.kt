package slackapi

import org.json.JSONObject
import slackapi.types.Channel
import slackapi.types.User
import utility.WebUtils
import utility.log

class UserApi(private val ctx : SlackContext) {

    fun List() : List<User> {
        val obj = JSONObject(
                WebUtils.getHTML("https://slack.com/api/users.list",
                        WebUtils.UrlParam("token", ctx.config.token)))

        if ( !obj.getBoolean("ok") ) {
            log("Channels.List failed.")
            return ArrayList<User>()
        }

        val res = ArrayList<User>()
        for ( jsonObj in obj.getJSONArray("members") ) {
            res.add(User(jsonObj as JSONObject))
        }
        return res;
    }
}