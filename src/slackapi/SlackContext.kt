package slackapi

import utility.WebUtils

public class SlackContext( public val config : SlackConfig ) {
    public val UserApi = UserApi(this)
    public val ChannelApi = ChannelApi(this)
    public val RTMApi = slackapi.RTMApi.Connect(this)
    public val ChatApi = ChatApi(this)

    companion object {
        fun Test(): String {
            return WebUtils.getHTML("https://slack.com/api/api.test")
        }
    }
}