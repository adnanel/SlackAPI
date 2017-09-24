package slackapi.types

import org.json.JSONObject
import utility.getSafely
import java.time.format.DateTimeFormatter
import java.util.*
import javax.print.attribute.standard.DateTimeAtCompleted

class Channel(jsonObject : JSONObject) {
    val Id: String = jsonObject.getSafely("id", "")
    val Name: String = jsonObject.getSafely("name", "")
    val IsChannel: Boolean = jsonObject.getSafely("is_channel", false)
    val CreatedDate: Date = Date(jsonObject.getSafely("created", 0.toLong()))
    val CreatorID: String = jsonObject.getSafely("creator", "")
    val IsArchived: Boolean = jsonObject.getSafely("is_archived", false)
    val IsGeneral: Boolean = jsonObject.getSafely("is_general", false)
    val IsMember: Boolean = jsonObject.getSafely("is_member", false)
    val IsPrivate: Boolean = jsonObject.getSafely("is_private", false)
    val MemberIDs: IntArray = IntArray(0)
    val Topic: ChannelTopic = ChannelTopic()
    val Purpose: ChannelPurpose = ChannelPurpose()
    val PreviousNames: Array<String> = arrayOf<String>()

    init {
        // todo initialize these
        //MemberIDs = jsonObject.getSafely("creator", "");
        //Topic = jsonObject.getSafely("topic", "");
        //Purpose = jsonObject.getSafely("purpose", "");
        //PreviousNames = jsonObject.getSafely("creator", "");
    }
}
