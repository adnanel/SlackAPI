package slackapi.types

public interface MessageListener {
    fun ProcessMessage(msg : String) : Boolean
}