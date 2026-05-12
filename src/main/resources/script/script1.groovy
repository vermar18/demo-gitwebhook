import com.sap.gateway.ip.core.customdev.util.Message
import com.sap.it.api.msglog.MessageLogFactory

def Message processData(Message message) {

    // Get message log instance
    def messageLog = MessageLogFactory.getMessageLog(message)

    if (messageLog != null) {

        // =========================
        // Log Headers
        // =========================
        def headers = message.getHeaders()

        headers.each { key, value ->
            messageLog.addCustomHeaderProperty(
                key.toString(),
                value?.toString()
            )
        }

        // =========================
        // Log Body Payload
        // =========================
        def body = message.getBody(String)

        messageLog.addAttachmentAsString(
            "Payload Body",
            body,
            "text/plain"
        )
    }

    println("This is jsut trail")

    return message
}