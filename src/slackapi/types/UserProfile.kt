package slackapi.types

import org.json.JSONObject
import utility.getSafely

class UserProfile(jsonObj : JSONObject) {
    val AvatarHash : String = jsonObj.getSafely("avatar_hash", "")
    val StatusEmoji : String = jsonObj.getSafely("status_emoji", "")
    val StatusText : String = jsonObj.getSafely("status_text", "")
    val FirstName : String = jsonObj.getSafely("first_name", "")
    val LastName : String = jsonObj.getSafely("last_name", "")
    val RealName : String = jsonObj.getSafely("real_name", "")
    val EMail : String = jsonObj.getSafely("email", "")
    val Skype : String = jsonObj.getSafely("skype", "")
    val Phone : String = jsonObj.getSafely("phone", "")
    val Image24 : String = jsonObj.getSafely("image_24", "")
    val Image32 : String = jsonObj.getSafely("image_32", "")
    val Image48 : String = jsonObj.getSafely("image_48", "")
    val Image72 : String = jsonObj.getSafely("image_72", "")
    val Image192 : String = jsonObj.getSafely("image_192", "")
    val Image512 : String = jsonObj.getSafely("image_512", "")

}