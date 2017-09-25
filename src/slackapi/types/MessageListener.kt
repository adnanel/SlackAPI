package slackapi.types

public interface MessageListener {
    fun ProcessMessage(msg : String, senderId : String, ts : String, channelId : String) : Boolean

    fun NotifyUserUpdate( usr : User )
    fun NotifyUserJoined( usr : User )
}