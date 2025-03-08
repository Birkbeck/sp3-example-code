/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greetings;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ApplicationScoped
public class MyConversationStatus implements Serializable {

    private String conversationStatus = "off";

    /**
     * @return the conversationStatus
     */
    public String getConversationStatus() {
        return conversationStatus;
    }

    /**
     * @param conversationStatus the conversationStatus to set
     */
    public void setConversationStatus(String conversationStatus) {
        this.conversationStatus = conversationStatus;
    }

}
