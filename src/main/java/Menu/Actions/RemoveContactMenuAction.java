package Menu.Actions;

import Models.Contact;
import Services.ContactService;
import UI.ContactView;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class RemoveContactMenuAction implements MenuAction{

    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public void doAction() {
        contactService.remove(contactView.getContactIdToDelete());


    }

    @Override
    public String getName() {
        return "Delete contact";
    }
}
