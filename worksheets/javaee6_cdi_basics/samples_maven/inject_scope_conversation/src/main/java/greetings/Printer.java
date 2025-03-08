/*
 * Copyright 2009 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */
package greetings;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class Printer implements Serializable {

    @Inject
    @Informal
    Greeting greeting;

    @Inject
    Conversation conversation;

    @Inject
    MyConversationStatus cstatus;

    private String name;
    private String salutation = "nothing yet!";
    private String old_salutation = "nothing yet!";

    public void startConversation() {
        cstatus.setConversationStatus("on");
        conversation.begin();
    }

    public void endConversation() {
        cstatus.setConversationStatus("off");
        conversation.end();
    }

    // When conversation scope is started, the
    // fields including "old_salutation" are
    // in the conversation scope.
    // When conversation scope is turned off,
    // the values of the fields are not maintained.
    // When the conversation scope is
    // turned off, the salutation field is set
    // with the greeting.greet(name) fresh.
    public void createSalutation() {
        this.old_salutation = salutation;
        this.salutation = greeting.greet(name);
    }

    public String getSalutation() {
        return salutation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the old_salutation
     */
    public String getOld_salutation() {
        return old_salutation;
    }

}
