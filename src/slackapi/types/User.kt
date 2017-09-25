package slackapi.types

import org.json.JSONObject
import utility.getSafely
import java.util.*

class User(jsonObject: JSONObject) {
    val Id : String = jsonObject.getSafely("id", "")
    val Name : String = jsonObject.getSafely("name", "")
    val Deleted : Boolean = jsonObject.getSafely("deleted", false)
    val Color : String = jsonObject.getSafely("color", "")
    val Profile : UserProfile = UserProfile(jsonObject.getJSONObject("profile"))
    val IsAdmin : Boolean = jsonObject.getSafely("is_admin", false)
    val IsOwner : Boolean = jsonObject.getSafely("is_owner", false)
    val IsPrimaryOwner : Boolean = jsonObject.getSafely("is_primary_owner", false)
    val IsRestricted : Boolean = jsonObject.getSafely("is_restricted", false)
    val IsUltraRestricted : Boolean = jsonObject.getSafely("is_ultra_restricted", false)
    val Updated : Date = Date(jsonObject.getSafely("updated", 0.toLong()))
    val HasTwoFactorAuth : Boolean = jsonObject.getSafely("has_2fa", false)
    val TwoFactorType : String = jsonObject.getSafely("two_factor_type", "")


    override fun toString(): String {
        val sb = StringBuilder()

        sb.append("User='$Name', IsAdmin=$IsAdmin, IsOwner=$IsOwner, IsPrimaryOwner=$IsPrimaryOwner, Mail=")
                .append(Profile.EMail).append(", Skype=").append(Profile.Skype).append(", Status=")
                .append(Profile.StatusText).append(", Ime=").append(Profile.FirstName).append(", Prezime=")
                .append(Profile.LastName)

        return sb.toString()
    }


}