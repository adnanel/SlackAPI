package slackapi.types

import org.json.JSONObject
import utility.getSafely
import java.util.*

public class Message(json: JSONObject) {
    val Id : String? = json.getSafely("id", "")
    val IsIM : Boolean = json.getSafely("is_im", false)
    val UserID : String = json.getSafely("user", "")
    val CreatedTimestamp = Date(json.getSafely<Long>("created", 0))
    val IsUserDeleted = json.getSafely("is_user_deleted", false)


}
